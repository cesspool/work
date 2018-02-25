package dbservice;

import beans.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class CustomerTest {
    @Autowired
    private CustomerDAOService customerService;
    
    @Test
    public void testDataSource() {
        Customer cmr = new Customer();
        cmr.setFirstName("Иван");
        cmr.setLastName("Иванов");
        cmr.setPatronymic("Иваныч");
        cmr.setTelephone("223-322");
        cmr.setAddress("За углом");
        
        customerService.insertCustomer(cmr);
        Long ID = cmr.getId();
        ID.toString();
    }
}