package dbservice;

import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;

import java.util.Collection;
import java.util.Map;

public interface NodeDistanceDAOService {
    void insertNode(NodeDistance nodeDistance);
    Map<Long, String> getAllCities();
    Map<Long, String> getCities(Long nodeID); // searching cities linked with that node
    //SELECT id, city FROM logistics.node a inner join logistics.distance b on a.id=b.node_id_start where b.node_id_start = 2
}
