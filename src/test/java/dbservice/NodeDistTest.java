package dbservice;

import beans.Distance;
import beans.Node;
import beans.Transport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.NodeDistanceService;
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

//    @Autowired
//    private NodeDistanceService nodeDistanceService; 
    @Test
    public void testDataSource(){
        Integer i1=10;
        Integer i2=11;
        Integer i3=1;
        Integer i4=2;
        Long k1 = Long.valueOf(i1.longValue());
        Long k2 = Long.valueOf(i2.longValue());

        Long k3 = Long.valueOf(i3.longValue());
        Long k4 = Long.valueOf(i4.longValue());

        Node node = new Node();
        node.setName("Московский филиал");
        node.setAddress("г. Москва, ул. Новая");
        node.setCoordinateX(15362.135);
        node.setCoordinateY(63261.1847);
        node.setCity("Москва");
        node.setCode("Node_4");

        Node city1 = new Node();
        city1.setId(k1);

        Node city2 = new Node();
        city2.setId(k2);

        Transport transport1 = new Transport();
        transport1.setId(k3);

        Transport transport2 = new Transport();
        transport2.setId(k4);

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
