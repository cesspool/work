package dbservice;

import beans.Distance;
import beans.Node;
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
import java.util.List;
import java.util.stream.Collectors;


@Service
public class NodeDistanceDAOServiceImpl extends DataService implements NodeDistanceDAOService {
    private static final Logger logger = LoggerFactory.getLogger(NodeDistanceDAOServiceImpl.class);

    private final static String SQL_INSERT_NODE = "INSERT INTO logistics.node" +
            "(name, address, coordinatex, coordinatey, code)" +
            "VALUES (?,?,?,?,?)";

    private final static String SQL_INSERT_TRANSPORT_NODE = "INSERT INTO logistics.transport_node" +
            "(node_id, transport_id) VALUES (?,?)";

    private final static String SQL_INSERT_DISTANCE = "INSERT INTO logistics.distance" +
            "(length, node_id_start, node_id_end) VALUES(?,?,?)";

    @Override
    @Transactional
    public void insertNode(Node node, Collection<Transport> transports, Collection<Distance> distances){
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) -> {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT_NODE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, node.getName());
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

        }

    }
}
