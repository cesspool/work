package dbservice;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.CoordinatesPrep;
import beans.Node;
import form.response.OrderingReq;
import utils.Pair;

//import beans.Order;
//import beans.Rate;
//import beans.Transport;
//import beans.TransportRate;
//import utils.Tools;


//extends DataService
@Service
public class OrderDAOServiceImpl  implements OrderDAOService {
	private static final Logger logger = LoggerFactory.getLogger(OrderDAOServiceImpl.class);
	
	private final static String SQL_INSERT_Order = "INSERT INTO logistics.order " +
            " (name, urgency, ready, sender_id, rate_id, package_id, boxing_id) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?) ";
	
	private final static String SQL_SEL_ORDERS_BY_READY_AND_RECIPIENT= "select Ord.name," +
			" Ord.urgency, Ord.plan_date, Ord.cost, Ord.contact_information, Pk.envelop," +
			" Pk.height, Pk.width, Pk.length, Pk.weight, Pk.size, Bx.variety, Nds.city, Ndt.city" + 
			" from logistics.order Ord" + 
			" inner join logistics.package Pk on Pk.id = Ord.package_id" + 
			" inner join logistics.boxing Bx on Bx.id = Ord.boxing_id" + 
			" inner join logistics.rate Rt on Rt.id = Ord.rate_id" + 
			" inner join logistics.node Nds on Nds.id = Ord.node_start_id" + 
			" inner join logistics.node Ndt on Ndt.id = Ord.node_target_id" + 
			" WHERE recipient_id = ? and ready=?";
	
	
	
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
