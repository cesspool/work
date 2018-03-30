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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Collections;

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
