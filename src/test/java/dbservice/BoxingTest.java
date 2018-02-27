package dbservice;


import beans.Boxing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BoxingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class BoxingTest {
    @Autowired
    private BoxingDAOService boxingDAOService;

    @Test
    public void testDataSource() {
        Boxing box = new Boxing();
        box.setVariety("Черная зарплата");
        box.setCost(182);

        boxingDAOService.insertBoxing(box);
        int ID = box.getId();
    }
}