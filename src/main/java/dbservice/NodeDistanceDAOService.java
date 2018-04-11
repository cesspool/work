package dbservice;

import beans.CoordinatesPrep;
import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import utils.Pair;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface NodeDistanceDAOService {
    void insertNode(NodeDistance nodeDistance);
    Map<Long, String> getAllCities();
    public List<CoordinatesPrep> getCoordinatesFromStart(Node start);
    public List<Distance> getAllDistances();
    public Node getByName(String name);
    public List<Pair<Long, Long>> getAllNodeTransports();
    public Node getCoordinate(Long ID);
    public void deleteNodeById(Long ID);
    public List<Pair<Long, Long>> getCities(Long ID);
    public Node getNode(Long ID);
    //public void updateNode(Node node);
    public void deleteLinkTransport(Long ID);
    public void deleteLinkNodes(Long ID);
    public void updateNode(NodeDistance nodeDistance);
    //Map<Long, String> getCities(Long nodeID); // searching cities linked with that node
    //SELECT id, city FROM logistics.node a inner join logistics.distance b on a.id=b.node_id_start where b.node_id_start = 2
}
