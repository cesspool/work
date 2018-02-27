package dbservice;

import beans.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.CustomerService;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class CustomerTest {
    @Autowired
    private CustomerDAOService customerDAOService;

    @Autowired
    private CustomerService customerService;

    @Test
    public void testDataSource() {
        Customer cmr = new Customer();
        cmr.setFirstName("Иван");
        cmr.setLastName("Петров");
        cmr.setPatronymic("Иваныч");
        cmr.setTelephone("223-322");
        cmr.setAddress("За углом");
        
        customerDAOService.insertCustomer(cmr);
        Long ID = cmr.getId();

        customerService.setPassword(cmr, "StrongPass");
        String md5 = cmr.getMd5();
        md5.toString();
    }
    
    @Test
    public void testPassword(){
        Optional<Customer> crm = customerDAOService.getByID(2l);
        crm.ifPresent((c) -> c.toString());

    }
}