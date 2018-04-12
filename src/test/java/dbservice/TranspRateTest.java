package dbservice;

import beans.Rate;
import beans.Transport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.TranspRateService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestConfiguration.class})
public class TranspRateTest {

    @Autowired
    private TranspRateDAOService transpRateDAOService;

   // @Autowired
    //private TranspRateService transpRateService;


    @Test
    public void testDataSource() throws ParseException{
        final double length =20;
        final double width = 4;
        final double height =5;
        double capacity = length * width * height;

        Transport transport = new Transport();
        transport.setVariety("ЖД перевозки");
        transport.setAvSpeed(50);
       // transport.setCostKm(10);
        transport.setMaxLength(length);
        transport.setMaxHeight(height);
        transport.setMaxWidth(width);
        transport.setTotalCapacity(capacity);
        transport.setTotalWeight(10);

        // Date Format --start From String to Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse("02/01/2015");
            end = sdf.parse("03/05/2016");
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        java.sql.Date dataStart = new java.sql.Date(start.getTime());
        java.sql.Date dataEnd = new java.sql.Date(end.getTime());

        // --end

        Rate rate = new Rate();
        rate.setName("Обновленный");
        rate.setCostShipping(17);
        rate.setAdditionalCost(25);
        rate.setStartAction(dataStart);
        rate.setEndAction(dataEnd);

        //transpRateDAOService.insertRate(rate, transport);

    }
}
