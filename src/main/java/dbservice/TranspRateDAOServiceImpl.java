package dbservice;

import beans.Customer;
import beans.Rate;
import beans.Transport;
import beans.TransportRate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.Pair;
import utils.Tools;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TranspRateDAOServiceImpl extends DataService implements TranspRateDAOService {
    private static final Logger logger = LoggerFactory.getLogger(TranspRateDAOServiceImpl.class);
    

    private final static String SQL_INSERT_RATE = "INSERT INTO logistics.rate " +
            " (name, costShipping, additionalCost, startActionDate, endActionDate, transport_id) " +
            " VALUES (?, ?, ?, ?, ?, ?) ";

    private final static String SQL_INSERT_TRANSPORT = "INSERT INTO logistics.transport " +
            " (variety, avSpeed, costKm, maxHeight, maxWidth, maxLength, totalWeight, totalCapacity) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
    
    private final static String SQL_UPDATE_TRANSPORT = "UPDATE logistics.transport " +
            " SET maxheight=?, maxwidth=?, maxlength=?, totalweight=?, totalcapacity=?";
    
    private final static String SQL_SELECT_TRANSPORT = "SELECT id, variety, avspeed, costkm, " + 
    		"maxheight, maxwidth, maxlength, totalweight, totalcapacity from logistics.transport";
    
    private final static String SQL_SELECT_RATE = "select id, \"name\", costshipping, additionalcost," +
    		 " startactiondate, endactiondate from logistics.rate R where now() between R.startactiondate and R.endactiondate";
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Rate> getCurrentRate() {
           List<Rate> rates = getJdbcTemplate().query(SQL_SELECT_RATE, (rs, num) -> {
        	   Rate r = new Rate();
        	   int idx=1;
        	   r.setId(rs.getLong(idx++));
        	   r.setName(rs.getString(idx++));
               r.setCostShipping(rs.getDouble(idx++));
               r.setAdditionalCost(rs.getDouble(idx++));
               r.setStartAction(rs.getDate(idx++));
               r.setEndAction(rs.getDate(idx++));
               return r;
           });
           return rates;
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Transport> getAllTransports() {
           List<Transport> transports = getJdbcTemplate().query(SQL_SELECT_TRANSPORT, (rs, num) -> {
        	   Transport transport = new Transport();
        	   int idx=1;
        	   transport.setId(rs.getLong(idx++));
        	   transport.setVariety(rs.getString(idx++));
        	   transport.setAvSpeed(rs.getDouble(idx++));
        	   transport.setCostKm(rs.getDouble(idx++));
        	   transport.setMaxHeight(rs.getDouble(idx++));
        	   transport.setMaxWidth(rs.getDouble(idx++));
        	   transport.setMaxLength(rs.getDouble(idx++));
        	   transport.setTotalWeight(rs.getDouble(idx++));
        	   transport.setTotalCapacity(rs.getDouble(idx++));
               return transport;
           });
           return transports;
    }
    
    
    @Override
    @Transactional
    public void insertRate(TransportRate transportRate) {
    	Transport transport = transportRate.getTransport();
//    	Rate rateCargo = transportRate.getRate().get(0);
//    	Rate rateAir = transportRate.getRate().get(1);
//    	Rate rateRail = transportRate.getRate().get(2);
//        try {
//            KeyHolder keyHolder = new GeneratedKeyHolder();
//            getJdbcTemplate().update((con) ->  {
//                PreparedStatement pst = con.prepareStatement(SQL_UPDATE_TRANSPORT, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
//                int idx = 1;
//                pst.setString(idx++,transport.getVariety());
//                pst.setDouble(idx++, transport.getAvSpeed());
//                pst.setDouble(idx++, transport.getCostKm());
//                pst.setDouble(idx++, transport.getMaxHeight());
//                pst.setDouble(idx++, transport.getMaxWidth());
//                pst.setDouble(idx++, transport.getMaxLength());
//                pst.setDouble(idx++, transport.getTotalWeight());
//                pst.setDouble(idx++, transport.getTotalCapacity());
//                return pst;
//            }, keyHolder);
//            Long ID = keyHolder.getKey().longValue();
//            transport.setId(ID);
//        } catch (DataAccessException dEx) {
//            Throwable ex = dEx.getCause();
//            ex.toString();
//        }
    	
    	 try {
         	for(Rate rate : transportRate.getRate()) {
 	            KeyHolder keyHolder = new GeneratedKeyHolder();
 	            getJdbcTemplate().update((con) ->  {
 	                PreparedStatement pst = con.prepareStatement(SQL_INSERT_RATE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
 	                int idx = 1;
 	                pst.setString(idx++, rate.getName());
 	                pst.setDouble(idx++, rate.getCostShipping());
 	                pst.setDouble(idx++, rate.getAdditionalCost());
 	                pst.setDate(idx++, Tools.toSQLDate(rate.getStartAction()));
 	                pst.setDate(idx++, Tools.toSQLDate(rate.getEndAction()));
 	                pst.setLong(idx++, rate.getTransportID());
 	                return pst;
 	            }, keyHolder);
 	            Long ID1 = keyHolder.getKey().longValue();
 	            transport.setId(ID1);
         	}
         } catch (DataAccessException dEx) {
             Throwable ex = dEx.getCause();
             ex.toString();
         }
    	
    	getJdbcTemplate().update(SQL_UPDATE_TRANSPORT, (ps) -> {
            int idx = 1;
            ps.setDouble(idx++, transport.getMaxHeight());
            ps.setDouble(idx++, transport.getMaxWidth());
            ps.setDouble(idx++, transport.getMaxLength());
            ps.setDouble(idx++, transport.getTotalWeight());
            ps.setDouble(idx++, transport.getTotalCapacity());
        });
            
       

    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Transport> getTransports() {

        return Collections.emptyList();
    }

    @Override
    @Transactional(readOnly=true)
    public Pair<Rate, Transport> getByDate(LocalDate date) {


        Date param = new Date(date.atStartOfDay(ZoneOffset.systemDefault()).toInstant().toEpochMilli());
        return null;

    }
}
