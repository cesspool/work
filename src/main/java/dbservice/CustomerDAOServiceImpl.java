package dbservice;

import beans.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;


@Service
public class CustomerDAOServiceImpl extends DataService implements CustomerDAOService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOServiceImpl.class);
    
    private final static String SQL_INSERT = "INSERT INTO  ";
    
    
    private PreparedStatementCreator psc = (con) -> {
        PreparedStatement pst = con.prepareStatement("", Statement.RETURN_GENERATED_KEYS);
        
        return pst;
    };
    
    @Override
    public Customer getByID(Long ID) {
        return null;
    }

    @Override
    public Customer getByEmail(String email) {
        return null;
    }

    @Override
    public void insertCustomer(Customer customer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(psc, keyHolder);
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }


}
