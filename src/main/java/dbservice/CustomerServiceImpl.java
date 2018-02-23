package dbservice;

import beans.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl extends DataService implements CustomerService {

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
        JdbcTemplate templ = new JdbcTemplate(ds);
        
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }


}
