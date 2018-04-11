package dbservice;

import beans.CoordinatesPrep;
import beans.Customer;
import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import logic.TransCoordinate;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import utils.Pair;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    private final static String SQL_SELECT_ALL = "SELECT id, city FROM logistics.node"
    		+ " where unavailable = 'false'";

    private final static String SQL_SELECT_ALL_DISTANCES = "SELECT D.length, D.node_id_start, D.node_id_end " +
    		" FROM logistics.distance D" +
    		" inner join logistics.node Ns on Ns.id = D.node_id_start and Ns.unavailable=false" +
            " inner join logistics.node Ne on Ne.id = D.node_id_end and Ne.unavailable=false";
   
    
    
     private final static String SQL_SELECT_CITIES = "select D.node_id_start, D.node_id_end " +
    		 						"from logistics.distance D " +
	" inner join logistics.node Ns on Ns.id = D.node_id_start" +
	" inner join logistics.node Nt on Nt.id = D.node_id_end" +
    " where ((D.node_id_start = ?) or (D.node_id_end = ?)) and Ns.unavailable=false and Nt.unavailable= false;";
    
    
    
    
    
    private final static String SQL_SEL_COORDINATES_BY_ID = "select Ns.coordinatex, Ns.coordinatey, Ns.id, " + 
    		" Ne.coordinatex, Ne.coordinatey, Ne.id  from logistics.distance D" +
    		" inner join logistics.node Ns on Ns.id = D.node_id_start" +
    		" inner join logistics.node Ne on Ne.id = D.node_id_end" +
    		"where D.node_id_start = ?";
    
    
    private final static String SQL_SEL_COORDINATE = "select coordinatex, coordinatey from logistics.node where"
    		+ " id = ? and unavailable = false";
    
    private final static String SQL_CITYID_BY_NAME = "select id from logistics.node"
    		+ " where city = ? and unavailable = 'false'";
    
    private final static String SQL_CITY_BY_ID = "select name, city, address, coordinatex, coordinatey"
    		+ " from logistics.node where unavailable = false and id = ?";
    
    private final static String SQL_SEL_ALL_NODE_TRANSPORT = "select Tn.node_id, Tn.transport_id " + 
    		" from logistics.transport_node Tn" + 
    		" inner join logistics.node N on Tn.node_id = N.id and N.unavailable = false";
    
    private final static String SQL_DEL_NODE_BY_ID= "UPDATE logistics.node set unavailable = true where id = ?";
    
    private final static String SQL_UPDATE_NODE= "UPDATE logistics.node set name = ?, city =?, " +
    		"address =?, coordinatex =?, coordinatey=? WHERE id = ?";
    
    private final static String SQL_DEL_LINK_TRANSPORT="delete from logistics.transport_node where node_id=?";
    private final static String SQL_DEL_LINK_NODES="delete from logistics.distance where" +
    		  " (node_id_start = ?) or (node_id_end = ?)";
    
    
    @Override
    @Transactional
    public void deleteLinkTransport(Long ID) {
        int chnaged = getJdbcTemplate().update(SQL_DEL_LINK_TRANSPORT, ID);
    }
    
    @Override
    @Transactional
    public void deleteLinkNodes(Long ID) {
        int chnaged = getJdbcTemplate().update(SQL_DEL_LINK_NODES, new Object[] {ID, ID});
    }
    
    @Override
    @Transactional
    public void updateNode(NodeDistance nodeDistance) {
    	Node node = nodeDistance.getNode();
    	Long ID = node.getId();
    	deleteLinkTransport(ID);
    	deleteLinkNodes(ID);
        getJdbcTemplate().update(SQL_UPDATE_NODE, (ps) -> {
            int idx = 1;
            ps.setString(idx++, node.getName());
            ps.setString(idx++, node.getCity());
            ps.setString(idx++, node.getAddress());
            ps.setDouble(idx++, node.getCoordinateX());
            ps.setDouble(idx++, node.getCoordinateY());
            ps.setLong(idx++, node.getId());
        });
        
        List<Distance> distances = new ArrayList();
        
        List<Pair<Long, Long>> transNode = new ArrayList();
        
        for (int i =0; i< nodeDistance.getTransport().size();i++) {
        	Pair<Long, Long> pair = new Pair(node.getId(), Long.valueOf(nodeDistance.getTransport().get(i)));
        	transNode.add(pair);
        }
       
        List<Object[]> typeOfNodes = transNode.stream()
                .map(td -> new Object[]{td.getLeft(), td.getRight()})
                .collect(Collectors.toList());

	    try {
	        getJdbcTemplate().batchUpdate(SQL_INSERT_TRANSPORT_NODE, typeOfNodes, new int[]{Types.INTEGER, Types.INTEGER});
	    } catch (DataAccessException dEx) {
	        Throwable ex = dEx.getCause();
	        ex.toString();
	    }

	    
	    double x1 = node.getCoordinateX();
        double y1= node.getCoordinateY();
        double x2;
        double y2;
        double result;
        TransCoordinate transCoordinate = new TransCoordinate();
        Node nd = new Node();
	      
	    
     	for (int i=0; i<nodeDistance.getCities().length; i++) {
     		nd = getCoordinate(Long.parseLong(nodeDistance.getCities()[i], 10));
        	x2= nd.getCoordinateX();
        	y2 = nd.getCoordinateY();
        	result = transCoordinate.setGeoCoordinate(x1, y1, x2, y2); //write somewhere
        	
    		Distance dst = new Distance();
    		dst.setNodeTo(Long.parseLong(nodeDistance.getCities()[i], 10));
    		dst.setNodeFrom(node.getId());
    		dst.setLength(result);
    		distances.add(dst);
    	}


        List<Object[]> dist = distances.stream()
                    .map(dt -> new Object[]{dt.getLength(), dt.getNodeFrom(), dt.getNodeTo()})
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
    public Node getNode(Long ID) {
        Node res = getJdbcTemplate().query(SQL_CITY_BY_ID, new Object[] {ID}, (rs) -> {
            if (!rs.next()) {
                return null;
            }
            Node node = new Node();
            node.setId(ID);
            int idx = 1;
            node.setName(rs.getString(idx++));
            node.setCity(rs.getString(idx++));
            node.setAddress(rs.getString(idx++));
            node.setCoordinateX(rs.getDouble(idx++));
            node.setCoordinateY(rs.getDouble(idx++));
            return node;
        });
        return res;
    }
 
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Pair<Long, Long>> getCities(Long ID) {
    	List<Pair<Long, Long>> res = getJdbcTemplate().query(SQL_SELECT_CITIES, new Object[] {ID, ID}, (rs, num) -> {
            Pair<Long, Long> n = new Pair<>();
            int idx = 1;
            n.setLeft(rs.getLong(idx++));
            n.setRight(rs.getLong(idx++));
            return n;
        });
        return res;
    }
    
    
    
//    @Override
//    @Transactional
//    public void updateCustomer(Customer customer) {
//        getJdbcTemplate().update(SQL_UPDATE, (ps) -> {
//            int idx = 1;
//            ps.setString(idx++, customer.getFirstName());
//            ps.setString(idx++, customer.getLastName());
//            ps.setString(idx++, customer.getPatronymic());
//            ps.setString(idx++, customer.getAddress());
//            ps.setString(idx++, customer.getTelephone());
//            ps.setString(idx++, customer.getEmail());
//            ps.setString(idx++, customer.getMd5());
//            ps.setBoolean(idx++, customer.isAdmin());
//            ps.setBoolean(idx++, customer.isManager());
//            ps.setLong(idx++, customer.getId());
//        });
//    }
    
    
    @Override
    @Transactional
    public void deleteNodeById(Long ID) {
    	Node node = new Node();
    	node.setId(ID);
    	getJdbcTemplate().update(SQL_DEL_NODE_BY_ID, (ps) -> {
    		int idx=1;
    		ps.setLong(idx++, node.getId());
    	});
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Pair<Long, Long>> getAllNodeTransports() {
           List<Pair<Long, Long>> transports = getJdbcTemplate().query(SQL_SEL_ALL_NODE_TRANSPORT, (rs, num) -> {
               return new Pair<>(rs.getLong(1), rs.getLong(2));
           });
           return transports;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Node getByName(String name) {
        Node res = getJdbcTemplate().query(SQL_CITYID_BY_NAME, new Object[] {name}, (rs) -> {
            if (!rs.next()) {
                return null;
            }
            Node n = new Node();
            n.setCity(name);
            int idx = 1;
            n.setId(rs.getLong(idx++));
            return n;
        });
        return res;
    }
    
    
    @Override
    @Transactional
    public void insertNode(NodeDistance nodeDistance){
    	Node node = nodeDistance.getNode();
    	//Collection<Transport> transports = nodeDistance.getTransports();
    	//Collection<Distance> distances = nodeDistance.getDistances();
    	List<Distance> distances = new ArrayList();
    	
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
        
        List<Pair<Long, Long>> transNode = new ArrayList();
        
        for (int i =0; i< nodeDistance.getTransport().size();i++) {
        	Pair<Long, Long> pair = new Pair(node.getId(), Long.valueOf(nodeDistance.getTransport().get(i)));
        	transNode.add(pair);
        }
       
        List<Object[]> typeOfNodes = transNode.stream()
                .map(td -> new Object[]{td.getLeft(), td.getRight()})
                .collect(Collectors.toList());

	    try {
	        getJdbcTemplate().batchUpdate(SQL_INSERT_TRANSPORT_NODE, typeOfNodes, new int[]{Types.INTEGER, Types.INTEGER});
	    } catch (DataAccessException dEx) {
	        Throwable ex = dEx.getCause();
	        ex.toString();
	    }

	    
	    double x1 = node.getCoordinateX();
        double y1= node.getCoordinateY();
        double x2;
        double y2;
        double result;
        TransCoordinate transCoordinate = new TransCoordinate();
        Node nd = new Node();
	      
	    
     	for (int i=0; i<nodeDistance.getCities().length; i++) {
     		nd = getCoordinate(Long.parseLong(nodeDistance.getCities()[i], 10));
        	x2= nd.getCoordinateX();
        	y2 = nd.getCoordinateY();
        	result = transCoordinate.setGeoCoordinate(x1, y1, x2, y2); //write somewhere
        	
    		Distance dst = new Distance();
    		dst.setNodeTo(Long.parseLong(nodeDistance.getCities()[i], 10));
    		dst.setNodeFrom(node.getId());
    		dst.setLength(result);
    		distances.add(dst);
    	}

//        List<Object[]> params = transports.stream()
//                    .map(tr -> new Object[]{node.getId(), tr.getId()})
//                    .collect(Collectors.toList());

//        try {
//            getJdbcTemplate().batchUpdate(SQL_INSERT_TRANSPORT_NODE, params);
//        } catch (DataAccessException dEx) {
//            Throwable ex = dEx.getCause();
//            ex.toString();
//        }

        List<Object[]> dist = distances.stream()
                    .map(dt -> new Object[]{dt.getLength(), dt.getNodeFrom(), dt.getNodeTo()})
                    .collect(Collectors.toList());

        try {
            getJdbcTemplate().batchUpdate(SQL_INSERT_DISTANCE, dist, new int[]{Types.REAL, Types.INTEGER, Types.INTEGER});
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }
        
        
        
        
        
        
        
        //do update for correcting coordinates
        
        

    }
    
    @Override
    @Transactional(readOnly = true)
    public Map<Long, String> getAllCities() {
           List<Pair<Long, String>> cities = getJdbcTemplate().query(SQL_SELECT_ALL, (rs, num) -> {
               return new Pair<>(rs.getLong(1), rs.getString(2));
           });
           Map<Long, String> allCities = cities.stream().collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
           return allCities;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Distance> getAllDistances() {
           List<Distance> distances = getJdbcTemplate().query(SQL_SELECT_ALL_DISTANCES, (rs, num) -> {
        	   Distance distance = new Distance();
        	   int idx = 1;
        	   distance.setLength(rs.getDouble(idx++));
        	   distance.setNodeFrom(rs.getLong(idx++));
        	   distance.setNodeTo(rs.getLong(idx++));
               return distance;
           });
           return distances;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<CoordinatesPrep> getCoordinatesFromStart(Node start) {
           List<Pair<Node, Node>> coordinates = getJdbcTemplate().query(SQL_SEL_COORDINATES_BY_ID, (rs, num) -> {
               Node ndStart = new Node();
               Node ndEnd = new Node();
               int idx = 1;
               ndStart.setCoordinateX(rs.getDouble(idx++));
               ndStart.setCoordinateY(rs.getDouble(idx++));
               ndStart.setId(rs.getLong(idx++));
               ndEnd.setCoordinateX(rs.getDouble(idx++));
               ndEnd.setCoordinateY(rs.getDouble(idx++));
               ndEnd.setId(rs.getLong(idx++));
               return new Pair<Node, Node>(ndStart, ndEnd);
           });
           List<CoordinatesPrep> result = new ArrayList<>();
           for(Pair<Node, Node> path : coordinates) {
        	   result.add(new CoordinatesPrep(path.getLeft(), path.getRight()));
           }
           return result;
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public Node getCoordinate(Long ID) {
        List<Node> res = getJdbcTemplate().query(SQL_SEL_COORDINATE, new Object[] {ID}, (rs, num) -> {
//            if (!rs.next()) {
//                return null;
//            }
            Node n = new Node();
            n.setId(ID);
            int idx = 1;
            n.setCoordinateX(rs.getDouble(idx++));
            n.setCoordinateY(rs.getDouble(idx++));
            return n;
        });
        return res.get(0);
    }
    
//    @Override !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    @Transactional(readOnly = true)
//    public Map<Long, String> getCities(Long nodeID) {
//    	List<Pair<Long, String>> cities = getJdbcTemplate().query(SQL_SELECT_CITIES, new Object[] {nodeID}, (rs, num) -> {
//    		return new Pair<>(rs.getLong(1), rs.getString(2));
//    	});
//    	    Map<Long, String> city = cities.stream().collect(Collectors.toMap(Pair::getLeft, Pair::getRight));
//               	int idx = 1;
//                city.put(nodeID, rs.getString(idx++));
//                return city;
//            });
//            return cities;
//        } 
    
}
