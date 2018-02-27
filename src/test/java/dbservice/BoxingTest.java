package dbservice;


import beans.Boxing;
import beans.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BoxingService;
import service.CustomerService;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class BoxingTest {
    @Autowired
    private BoxingDAOService boxingDAOService;

    @Autowired
    private BoxingService boxingService;

    @Test
    public void testDataSource() {
        Boxing box = new Boxing();
        box.setVariety("Белая");
        box.setCost(152);

        boxingDAOService.insertBoxing(box);
        int ID = box.getId();

    }
}
