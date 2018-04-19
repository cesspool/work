package dbservice;

import beans.Customer;
import beans.Node;
import beans.Rate;
import beans.Transport;
import beans.TransportRate;
import exception.RateAlreadyExistException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.Pair;
import utils.Tools;

import java.util.Date;
import java.util.HashMap;
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
            " (name, costShipping, additionalCost, costkm, startActionDate, endActionDate, transport_id) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?) ";

    private final static String SQL_INSERT_TRANSPORT = "INSERT INTO logistics.transport " +
            " (variety, avSpeed, maxHeight, maxWidth, maxLength, totalWeight, totalCapacity) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?) ";
    
    private final static String SQL_UPDATE_TRANSPORT = "UPDATE logistics.transport " +
            " SET maxheight=?, maxwidth=?, maxlength=?, totalweight=?, totalcapacity=?";
    
    private final static String SQL_SELECT_TRANSPORT = "SELECT id, variety, avspeed, " + 
    		"maxheight, maxwidth, maxlength, totalweight, totalcapacity from logistics.transport";
    
    private final static String SQL_SELECT_RATE = "select id, \"name\", costshipping, additionalcost, costkm, " +
    		 " startactiondate, endactiondate from logistics.rate R where now() between R.startactiondate and R.endactiondate";
    
    private final static String SQL_SELECT_ALL_RATE = "select id, \"name\", costshipping, additionalcost, costkm, " +
   		 " startactiondate, endactiondate from logistics.rate";
    
    private final static String SQL_SELECT_RATE_BY_ID = "select R.id, R.name, R.costshipping, R.additionalcost, R.costkm, " + 
    		" R.startactiondate, R.endactiondate from ( " + 
    		" select \"name\" " + 
    		" from logistics.rate " + 
    		" where \"id\"=? " + 
    		" )tbl inner join logistics.rate R on R.name=tbl.name";
    
    private final static String SQL_UPDATE_RATE_BY_NAME = "update logistics.rate" +
    		 " set name = ?, costshipping=?, additionalcost=?, costkm = ?, " +
    		 " startactiondate = ?, endactiondate=? where id =  ?";
    
    private final static String SQL_DATA_RATE_CHECK = "select * from logistics.rate R " + 
    		" where ( :sd >= R.startactiondate and :sd < R.endactiondate) or " + 
    		"       ( :ed >= R.startactiondate and :ed < R.endactiondate) or " + 
    		"       ( :sd <= R.startactiondate and :ed > R.endactiondate) or " + 
    		"       ( :sd >= R.startactiondate and :ed < R.endactiondate) ";
    
    
    @Override
    @Transactional
    public void updateTransport(Transport transport) {
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
    @Transactional
    public void updateRateById(List<Rate> rates)  {
//    	if (checkDataRate(rates.get(0).getStartAction(), rates.get(0).getEndAction())) {
//    		throw new RateAlreadyExistException("rate.already.exists");
//    	}
	    for (Rate rate : rates) {
	    	getJdbcTemplate().update(SQL_UPDATE_RATE_BY_NAME, (ps) -> {
	            int idx = 1;
	            ps.setString(idx++, rate.getName());
	            ps.setDouble(idx++, rate.getCostShipping());
	            ps.setDouble(idx++, rate.getAdditionalCost());
	            ps.setDouble(idx++, rate.getCostKm());
	            ps.setDate(idx++, Tools.toSQLDate(rate.getStartAction()));
	            ps.setDate(idx++, Tools.toSQLDate(rate.getEndAction()));
	            ps.setLong(idx++, rate.getId());
	        });
	    }
    }
    
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Rate> getRatesById(Long ID) {
    	List<Rate> res = getJdbcTemplate().query(SQL_SELECT_RATE_BY_ID, new Object[] {ID}, (rs, num) -> {
            Rate r = new Rate();
            int idx = 1;
            r.setId(rs.getLong(idx++));
            r.setName(rs.getString(idx++));
            r.setCostShipping(rs.getDouble(idx++));
            r.setAdditionalCost(rs.getDouble(idx++));
            r.setCostKm(rs.getDouble(idx++));
            r.setStartAction(rs.getDate(idx++));
            r.setEndAction(rs.getDate(idx++));
            return r;
        });
        return res;
    }
    
    
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
               r.setCostKm(rs.getDouble(idx++));
               r.setStartAction(rs.getDate(idx++));
               r.setEndAction(rs.getDate(idx++));
               return r;
           });
           return rates;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Rate> getAllRate() {
           List<Rate> rates = getJdbcTemplate().query(SQL_SELECT_ALL_RATE, (rs, num) -> {
        	   Rate r = new Rate();
        	   int idx=1;
        	   r.setId(rs.getLong(idx++));
        	   r.setName(rs.getString(idx++));
               r.setCostShipping(rs.getDouble(idx++));
               r.setAdditionalCost(rs.getDouble(idx++));
               r.setCostKm(rs.getDouble(idx++));
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
    public void insertRate(List<Rate> rates) throws RateAlreadyExistException {
    	if (checkDataRate(rates.get(0).getStartAction(), rates.get(0).getEndAction())) {
    		throw new RateAlreadyExistException("rate.already.exists");
    	}
    	
    	 try {
         	for(Rate rate : rates) {
 	            KeyHolder keyHolder = new GeneratedKeyHolder();
 	            getJdbcTemplate().update((con) ->  {
 	                PreparedStatement pst = con.prepareStatement(SQL_INSERT_RATE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
 	                int idx = 1;
 	                pst.setString(idx++, rate.getName());
 	                pst.setDouble(idx++, rate.getCostShipping());
 	                pst.setDouble(idx++, rate.getAdditionalCost());
 	                pst.setDouble(idx++, rate.getCostKm());
 	                pst.setDate(idx++, Tools.toSQLDate(rate.getStartAction()));
 	                pst.setDate(idx++, Tools.toSQLDate(rate.getEndAction()));
 	                pst.setLong(idx++, rate.getTransportID());
 	                return pst;
 	            }, keyHolder);
 	            Long ID1 = keyHolder.getKey().longValue();
 	            //transport.setId(ID1);
         	}
         } catch (DataAccessException dEx) {
             Throwable ex = dEx.getCause();
             ex.toString();
         }
    	
    }
    
    private boolean checkDataRate(Date start, Date end){
    	Map<String, Date> params = new HashMap<>();
    	params.put("sd", Tools.toSQLDate(start));
    	params.put("ed", Tools.toSQLDate(end));
    	Boolean isExist = getNamedParameterJdbcTemplate().query(SQL_DATA_RATE_CHECK, params, (rs) -> {
    		return  rs.next() ? Boolean.TRUE : Boolean.FALSE; 
    	});
    	return isExist;
    }
    
    @Override
    @Transactional
    public void insertTransport(Transport transport) {
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
