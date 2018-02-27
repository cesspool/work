package dbservice;

import beans.Boxing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

@Service
public class BoxingDAOServiceImpl extends DataService implements BoxingDAOService{
    private static final Logger logger =  LoggerFactory.getLogger(BoxingDAOServiceImpl.class);

    private final static String SQL_INSERT = "INSERT INTO logistics.boxing " +
            " (variety, cost) " + " VALUES (?, ?)";

    private final static String SQL_DELETE = "DELETE FROM logistics.boxing " +
            " WHERE variety=?";

    @Override
    @Transactional
    public void insertBoxing(final Boxing boxing) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) -> {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, boxing.getVariety());
                pst.setDouble(idx++, boxing.getCost());
                return pst;
            }, keyHolder);
            int ID = keyHolder.getKey().intValue();
            boxing.setId(ID);
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }
    }
}
