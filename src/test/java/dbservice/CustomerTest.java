package dbservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class CustomerTest {
    //@Autowired
   // private CustomerService customerService;
    @Autowired
    private DataSource ds;
    
    @Test
    public void testDataSource() throws SQLException {
        Connection connection = null;
        try {
            connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int mockVal = resultSet.getInt(1);
                //assertTrue(mockVal== 1);
            }
            statement.close();
        } catch (Exception e) {
            e.toString();
 //           logger.debug("Something unexpected happened.", e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}