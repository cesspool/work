package dbservice;

import beans.Rate;
import beans.Transport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.Pair;

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



    @Override
    @Transactional
    public void insertRate(Rate rate, Transport transport) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) ->  {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT_TRANSPORT, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++,transport.getVariety());
                pst.setDouble(idx++, transport.getAvSpeed());
                pst.setDouble(idx++, transport.getCostKm());
                pst.setDouble(idx++, transport.getMaxHeight());
                pst.setDouble(idx++, transport.getMaxWidth());
                pst.setDouble(idx++, transport.getMaxLength());
                pst.setDouble(idx++, transport.getTotalWeight());
                pst.setDouble(idx++, transport.getTotalCapacity());
                return pst;
            }, keyHolder);
            Long ID = keyHolder.getKey().longValue();
            transport.setId(ID);
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }

        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) ->  {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT_RATE, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, rate.getName());
                pst.setDouble(idx++, rate.getCostShipping());
                pst.setDouble(idx++, rate.getAdditionalCost());
                pst.setDate(idx++, rate.getStartAction());
                pst.setDate(idx++, rate.getEndAction());
                pst.setLong(idx++, transport.getId());
                return pst;
            }, keyHolder);
            Long ID = keyHolder.getKey().longValue();
            transport.setId(ID);
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }

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
