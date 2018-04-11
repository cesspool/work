package dbservice;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.Boxing;
import beans.CharacteristicsPath;
import beans.Package;
import beans.Route;
import beans.CoordinatesPrep;
import beans.Node;
import beans.Order;
import beans.OrderShow;
import form.response.OrderingReq;
import utils.Pair;
import utils.Tools;

//import beans.Order;
//import beans.Rate;
//import beans.Transport;
//import beans.TransportRate;
//import utils.Tools;


//extends DataService
@Service
public class OrderDAOServiceImpl extends DataService  implements OrderDAOService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDAOServiceImpl.class);
	
//	private final static String SQL_INSERT_Order = "INSERT INTO logistics.order " +
//            " (name, urgency, ready, sender_id, rate_id, package_id, boxing_id) " +
//            " VALUES (?, ?, ?, ?, ?, ?, ?) ";
	
	private final static String SQL_SEL_ORDERS_BY_READY_AND_RECIPIENT= "select Ord.name," +
			" Ord.urgency, Ord.plan_date, Ord.cost, Ord.contact_information, Ord.shipment_date, Ord.real_date, Pk.envelop," +
			" Pk.height, Pk.width, Pk.length, Pk.weight, Pk.quantity, Bx.variety, Nds.city, Ndt.city, Ndt.address" + 
			" from logistics.order Ord" + 
			" inner join logistics.package Pk on Pk.id = Ord.package_id" + 
			" inner join logistics.boxing Bx on Bx.id = Ord.boxing_id" + 
			" inner join logistics.rate Rt on Rt.id = Ord.rate_id" + 
			" inner join logistics.node Nds on Nds.id = Ord.node_start_id" + 
			" inner join logistics.node Ndt on Ndt.id = Ord.node_target_id" + 
			" WHERE recipient_id = ? and ready=?";
	
	private final static String SQL_INSERT_ORDER="INSERT INTO logistics.order (name, urgency, ready, plan_date, cost,"
			+ " shipment_date, contact_information, recipient_id, rate_id, " + 
			" package_id, boxing_id, node_start_id, node_target_id) VALUES " + 
			" (?,?,'0',?,?,now(),?,?,?,?,?,?,?)";
	
	private final static String SQL_INSERT_PACKAGE="INSERT INTO logistics.package (name, envelop, height, width, "
			+ " length, weight, quantity, size) VALUES (?,?,?,?,?,?,?,?)";
	
	private final static String SQL_INSERT_ROUTE="INSERT INTO logistics.route (order_id, node_id, number_node) VALUES (?,?,?)";
	
	
	
	
    @Override
    @Transactional(readOnly = true)
    public Optional<List<OrderShow>> getOrders(Long ID, boolean ready) {
        List<OrderShow> orders = getJdbcTemplate().query(SQL_SEL_ORDERS_BY_READY_AND_RECIPIENT,
        						new Object[] {ID, ready}, (rs, num) -> {
//            if (!rs.next()) {
//                return null;
//            }
            OrderShow o = new OrderShow();
//            n.setId(ID);
            int idx = 1;
            o.getOrder().setName(rs.getString(idx++));
            o.getOrder().isUrgency(rs.getBoolean(idx++));
            o.getOrder().setPlanDate(rs.getDate(idx++));
            o.getOrder().setCost(rs.getDouble(idx++));
            o.getOrder().setContact_information(rs.getString(idx++));
            o.getOrder().setShipmentDate(rs.getDate(idx++));
            o.getOrder().setRealDate(rs.getDate(idx++));
            o.getCargo().isEnvelope(rs.getBoolean(idx++));
            o.getCargo().setHeight(rs.getDouble(idx++));
            o.getCargo().setWidth(rs.getDouble(idx++));
            o.getCargo().setLength(rs.getDouble(idx++));
            o.getCargo().setWeight(rs.getDouble(idx++));
            o.getCargo().setQuantity(rs.getInt(idx++));
            o.getBox().setVariety(rs.getString(idx++));
            o.getNodeStart().setCity(rs.getString(idx++));
            o.getNodeEnd().setCity(rs.getString(idx++));
            o.getNodeEnd().setAddress(rs.getString(idx++));
            return o;
        });
        return Optional.ofNullable(orders);
    }
	
	
	
	
	
	
	
    @Override
    @Transactional
    public void insertNewOrder(Order order, Package cargo, CharacteristicsPath charPath) {
    	String nameCargo = UUID.randomUUID().toString();
    	cargo.setName(nameCargo);
        KeyHolder keyHolderPackage = new GeneratedKeyHolder();
        getJdbcTemplate().update((con) ->  {
            PreparedStatement pst = con.prepareStatement(SQL_INSERT_PACKAGE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
            int idx = 1;
            pst.setString(idx++, cargo.getName());
            pst.setBoolean(idx++, cargo.isEnvelope());
            pst.setDouble(idx++, cargo.getHeight());
            pst.setDouble(idx++, cargo.getWidth());
            pst.setDouble(idx++, cargo.getLength());
            pst.setDouble(idx++, cargo.getWeight());
            pst.setDouble(idx++, cargo.getQuantity());
            pst.setDouble(idx++, cargo.getSize());
            return pst;
        }, keyHolderPackage);
        Long IDCargo = keyHolderPackage.getKey().longValue();
        cargo.setId(IDCargo);
        order.setPackageId(IDCargo);
    	
    	String name = UUID.randomUUID().toString();
    	order.setName(name);
        KeyHolder keyHolderOrder = new GeneratedKeyHolder();
        getJdbcTemplate().update((con) ->  {
            PreparedStatement pst = con.prepareStatement(SQL_INSERT_ORDER, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
            int idx = 1;
            pst.setString(idx++, order.getName());
            pst.setBoolean(idx++, order.isUrgency());
            pst.setDate(idx++,  Tools.toSQLDate(order.getPlanDate()));
            pst.setDouble(idx++, order.getCost());
            pst.setString(idx++, order.getContact_information());
            pst.setLong(idx++, order.getRecipientId());
            pst.setLong(idx++, order.getRateId());
            pst.setLong(idx++, order.getPackageId());
            pst.setLong(idx++, order.getBoxingId());
            pst.setLong(idx++, order.getNodeStart());
            pst.setLong(idx++, order.getNodeTarget());
            return pst;
        }, keyHolderOrder);
        Long IDOrder = keyHolderOrder.getKey().longValue();
        order.setId(IDOrder);
        
        List<Route> routes = new ArrayList<>();
        for (int i=0; i< charPath.getPathId().size(); i++) {
        	Route r = new Route();
        	r.setNodeId(charPath.getPathId().get(i));
        	r.setNumberNode(i);
        	r.setOrderId(order.getId());
        	routes.add(r);
        }
        //fill routes by orderId
        
        List<Object[]> route = routes.stream()
                .map(rt -> new Object[]{rt.getOrderId(), rt.getNodeId(), rt.getNumberNode()})
                .collect(Collectors.toList());

	    try {
	        getJdbcTemplate().batchUpdate(SQL_INSERT_ROUTE, route, new int[]{Types.INTEGER, Types.INTEGER, Types.INTEGER});
	    } catch (DataAccessException dEx) {
	        Throwable ex = dEx.getCause();
	        ex.toString();
	    }
            
            
    }
	
	
	
	
//	@Override
//    @Transactional(readOnly = true)
//    public List<OrderingReq> getOrdersByReady(Node start) {
//           List<Pair<Node, Node>> coordinates = getJdbcTemplate().query(SQL_SEL_COORDINATES_BY_ID, (rs, num) -> {
//               Node ndStart = new Node();
//               Node ndEnd = new Node();
//               int idx = 1;
//               ndStart.setCoordinateX(rs.getDouble(idx++));
//               ndStart.setCoordinateY(rs.getDouble(idx++));
//               ndStart.setId(rs.getLong(idx++));
//               ndEnd.setCoordinateX(rs.getDouble(idx++));
//               ndEnd.setCoordinateY(rs.getDouble(idx++));
//               ndEnd.setId(rs.getLong(idx++));
//               return new Pair<Node, Node>(ndStart, ndEnd);
//           });
//           List<CoordinatesPrep> result = new ArrayList<>();
//           for(Pair<Node, Node> path : coordinates) {
//        	   result.add(new CoordinatesPrep(path.getLeft(), path.getRight()));
//           }
//           return result;
//    }
	
	
	
	
	 	//@Override
	    //@Transactional
	    //public void insertOrder(Order order) {
	    	//Order order= transportRate.getTransport();
//	    	Rate rateCargo = transportRate.getRate().get(0);
//	    	Rate rateAir = transportRate.getRate().get(1);
//	    	Rate rateRail = transportRate.getRate().get(2);
//	        try {
//	            KeyHolder keyHolder = new GeneratedKeyHolder();
//	            getJdbcTemplate().update((con) ->  {
//	                PreparedStatement pst = con.prepareStatement(SQL_UPDATE_TRANSPORT, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
//	                int idx = 1;
//	                pst.setString(idx++,transport.getVariety());
//	                pst.setDouble(idx++, transport.getAvSpeed());
//	                pst.setDouble(idx++, transport.getCostKm());
//	                pst.setDouble(idx++, transport.getMaxHeight());
//	                pst.setDouble(idx++, transport.getMaxWidth());
//	                pst.setDouble(idx++, transport.getMaxLength());
//	                pst.setDouble(idx++, transport.getTotalWeight());
//	                pst.setDouble(idx++, transport.getTotalCapacity());
//	                return pst;
//	            }, keyHolder);
//	            Long ID = keyHolder.getKey().longValue();
//	            transport.setId(ID);
//	        } catch (DataAccessException dEx) {
//	            Throwable ex = dEx.getCause();
//	            ex.toString();
//	        }
	    	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	    	 try {
//	         	for(Rate rate : transportRate.getRate()) {
//	 	            KeyHolder keyHolder = new GeneratedKeyHolder();
//	 	            getJdbcTemplate().update((con) ->  {
//	 	                PreparedStatement pst = con.prepareStatement(SQL_INSERT_RATE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
//	 	                int idx = 1;
//	 	                pst.setString(idx++, rate.getName());
//	 	                pst.setDouble(idx++, rate.getCostShipping());
//	 	                pst.setDouble(idx++, rate.getAdditionalCost());
//	 	                pst.setDate(idx++, Tools.toSQLDate(rate.getStartAction()));
//	 	                pst.setDate(idx++, Tools.toSQLDate(rate.getEndAction()));
//	 	                pst.setLong(idx++, rate.getTransportID());
//	 	                return pst;
//	 	            }, keyHolder);
//	 	            Long ID1 = keyHolder.getKey().longValue();
//	 	            transport.setId(ID1);
//	         	}
//	         } catch (DataAccessException dEx) {
//	             Throwable ex = dEx.getCause();
//	             ex.toString();
//	         }
//	    	
//	    	getJdbcTemplate().update(SQL_UPDATE_TRANSPORT, (ps) -> {
//	            int idx = 1;
//	            ps.setDouble(idx++, transport.getMaxHeight());
//	            ps.setDouble(idx++, transport.getMaxWidth());
//	            ps.setDouble(idx++, transport.getMaxLength());
//	            ps.setDouble(idx++, transport.getTotalWeight());
//	            ps.setDouble(idx++, transport.getTotalCapacity());
//	        });
//	            
//	       
//
//	    }
	
}
