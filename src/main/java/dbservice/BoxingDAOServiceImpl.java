package dbservice;

import beans.Boxing;
import beans.Customer;
import utils.Pair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoxingDAOServiceImpl extends DataService implements BoxingDAOService{
    private static final Logger logger =  LoggerFactory.getLogger(BoxingDAOServiceImpl.class);

    private final static String SQL_INSERT = "INSERT INTO logistics.boxing " +
            " (variety, cost) " + " VALUES (?, ?)";

    private final static String SQL_DELETE = "DELETE FROM logistics.boxing " +
            " WHERE variety=?";
    
    private final static String SQL_SELECT_ALL = "SELECT id, variety FROM logistics.boxing";
    
    private final static String SQL_SELECT_BOX_BY_ID = "select B.cost from logistics.boxing B where id = ?";
    
    

    @Override
    @Transactional(readOnly = true)
    public Boxing getCostByID(Long ID) {
    	List<Boxing> boxes = getJdbcTemplate().query(SQL_SELECT_BOX_BY_ID, new Object[] {ID}, new CostMapper(ID)); 
        return boxes.size() > 0 ? boxes.get(0) : null;
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public Map<Long, String> getAllBoxes() {
           List<Pair<Long, String>> boxes = getJdbcTemplate().query(SQL_SELECT_ALL, (rs, num) -> {
               return new Pair<>(rs.getLong(1), rs.getString(2));
           });
           Map<Long, String> allBoxes = boxes.stream().collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
           return allBoxes;
    }
    
    
    @Override
    @Transactional
    public void insertBoxing(final Boxing boxing) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) ->  {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, boxing.getVariety());
                pst.setDouble(idx++, boxing.getCost());
                return pst;
            }, keyHolder);
            Long ID = keyHolder.getKey().longValue();
            boxing.setId(ID);

        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }

    }

    @Override
    @Transactional
    public void deleteBoxing(final Boxing boxing) {
        getJdbcTemplate().update(SQL_DELETE, boxing.getVariety());
    };
    
    
    private class CostMapper implements RowMapper<Boxing> {
    	private Long id;
    	public CostMapper(Long ID) {
    		this.id = ID;
    	}
    	
		@Override
		public Boxing mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Boxing boxy = new Boxing();
    		boxy.setId(this.id);
            int idx = 1;
            boxy.setCost(rs.getDouble(idx++));
            return boxy;
		}
    }
}
