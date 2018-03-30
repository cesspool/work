package dbservice;

import beans.Customer;
import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class NodeDistanceDAOServiceImpl extends DataService implements NodeDistanceDAOService {
    private static final Logger logger = LoggerFactory.getLogger(NodeDistanceDAOServiceImpl.class);

    private final static String SQL_INSERT_NODE = "INSERT INTO logistics.node" +
            "(name, city, address, coordinatex, coordinatey, code)" +
            "VALUES (?,?,?,?,?,?)";

    private final static String SQL_INSERT_TRANSPORT_NODE = "INSERT INTO logistics.transport_node" +
            "(node_id, transport_id) VALUES (?,?)";

    private final static String SQL_INSERT_DISTANCE = "INSERT INTO logistics.distance" +
            "(length, node_id_start, node_id_end) VALUES(?,?,?)";

    private final static String SQL_SELECT_ALL = "SELECT id, city FROM logistics.node";
    
    private final static String SQL_SELECT_CITIES = "SELECT a.id, a.city FROM logistics.node a " + 
    		"inner join logistics.distance b on a.id=b.node_id_end where b.node_id_start = 1";
    		
    
    @Override
    @Transactional
    public void insertNode(NodeDistance nodeDistance){
    	Node node = nodeDistance.getNode();
    	Collection<Transport> transports = nodeDistance.getTransports();
    	Collection<Distance> distances = nodeDistance.getDistances();
    	
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) -> {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT_NODE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, node.getName());
                pst.setString(idx++, node.getCity());
                pst.setString(idx++, node.getAddress());
                pst.setDouble(idx++, node.getCoordinateX());
                pst.setDouble(idx++, node.getCoordinateY());
                pst.setString(idx++, node.getCode());
                return pst;
            }, keyHolder);
            Long ID = keyHolder.getKey().longValue();
            node.setId(ID);
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }

        List<Object[]> params = transports.stream()
                    .map(tr -> new Object[]{node.getId(), tr.getId()})
                    .collect(Collectors.toList());

        try {
            getJdbcTemplate().batchUpdate(SQL_INSERT_TRANSPORT_NODE, params);
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }

        List<Object[]> dist = distances.stream()
                    .map(dt -> new Object[]{dt.getLength(), node.getId(), dt.getNodeTarget().getId()})
                    .collect(Collectors.toList());

        try {
            getJdbcTemplate().batchUpdate(SQL_INSERT_DISTANCE, dist, new int[]{Types.REAL, Types.INTEGER, Types.INTEGER});
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();

        }

    }
    
    @Override
    @Transactional(readOnly = true)
    public Map<Long, String> getAllCities() {
           Map<Long, String> allCities = getJdbcTemplate().query(SQL_SELECT_ALL, (rs) -> {
                if (!rs.next()) {
                    return null;
                }
                Map<Long, String> cities = new HashMap<>();
                int idx = 1;
                cities.put(rs.getLong(idx++), rs.getString(idx++));
                return cities;
            });
            return allCities;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Map<Long, String> getCities(Long nodeID) {
    	Map<Long, String> cities = getJdbcTemplate().query(SQL_SELECT_CITIES, new Object[] {nodeID}, (rs) -> {
                if (!rs.next()) {
                    return null;
                }
               	Map<Long, String> city = new HashMap<>();
               	int idx = 1;
                city.put(nodeID, rs.getString(idx++));
                return city;
            });
            return cities;
        }
    
}
