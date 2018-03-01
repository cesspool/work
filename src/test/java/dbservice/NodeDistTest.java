package dbservice;

import beans.Distance;
import beans.Node;
import beans.Transport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.TranspRateService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class NodeDistTest {
    @Autowired
    private NodeDistanceDAOService nodeDistanceDAOService;

    @Test
    public void testDataSource(){
        Integer i1=10;
        Integer i2=12;
        Long k1 = Long.valueOf(i1.longValue());
        Long k2 = Long.valueOf(i2.longValue());

        Node node = new Node();
        node.setName("Московский филиал");
        node.setAddress("г. Москва, ул. Новая");
        node.setCoordinateX(15362.135);
        node.setCoordinateY(63261.1847);
        node.setCode("Node_1");

        Node city1 = new Node();
        city1.setId(k1);

        Node city2 = new Node();
        city2.setId(k2);

        Transport transport1 = new Transport();
        transport1.setId(k1);
//        transport1.setVariety("ЖД перевозки");
//        transport1.setAvSpeed(50);
//        transport1.setCostKm(10);
//        transport1.setMaxLength(2);
//        transport1.setMaxHeight(3);
//        transport1.setMaxWidth(4);
//        transport1.setTotalCapacity(5);
//        transport1.setTotalWeight(10);

        Transport transport2 = new Transport();
        transport2.setId(k2);
//        transport2.setVariety("ЖД перевозки");
//        transport2.setAvSpeed(50);
//        transport2.setCostKm(10);
//        transport2.setMaxLength(1);
//        transport2.setMaxHeight(5);
//        transport2.setMaxWidth(2);
//        transport2.setTotalCapacity(5);
//        transport2.setTotalWeight(10);

        List<Transport> transports = new ArrayList<>();
        transports.add(transport1);
        transports.add(transport2);

        Distance dist1= new Distance();
        dist1.setLength(15);
        dist1.setNodeStart(node);
        dist1.setNodeTarget(city1);

        Distance dist2= new Distance();
        dist2.setLength(20);
        dist2.setNodeStart(node);
        dist2.setNodeTarget(city2);

        List<Distance> distances = new ArrayList<>();
        distances.add(dist1);
        distances.add(dist2);

        nodeDistanceDAOService.insertNode(node, transports, distances);

    }
}
