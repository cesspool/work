package dbservice;

import beans.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

import java.sql.PreparedStatement;
import java.sql.Statement;


@Service
public class CustomerDAOServiceImpl extends DataService implements CustomerDAOService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOServiceImpl.class);

    private final static String SQL_INSERT = "INSERT INTO logistics.customer " +
        " (firstName, lastName, patronymic, address, telephone, hashcode, admin) " +
        " VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public Customer getByID(Long ID) {
        return null;
    }

    @Override
    public Customer getByEmail(String email) {
        return null;
    }

    @Override
    @Transactional
    public void insertCustomer(final Customer customer) {
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) -> {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT, new String[]{"id"}); //Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, customer.getFirstName());
                pst.setString(idx++, customer.getLastName());
                pst.setString(idx++, customer.getPatronymic());
                pst.setString(idx++, customer.getAddress());
                pst.setString(idx++, customer.getTelephone());
                pst.setString(idx++, customer.getMd5());
                pst.setBoolean(idx++, customer.isAdmin());
                return pst;
            }, keyHolder);
            Long ID = keyHolder.getKey().longValue();
            customer.setId(ID);
        }catch(DataAccessException dEx){
            Throwable ex = dEx.getCause();
            ex.toString();
        }
    }

    
    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }


}
