package service;

import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import form.request.NewNodeForm;

import java.util.Collection;
import java.util.Map;

public interface NodeDistanceService {
    void createNode(NodeDistance nodeDistance);
    NodeDistance createNode(NewNodeForm nodeForm);
    public void deleteNodeById(Long ID);
    public void changeNodeById(NewNodeForm nodeForm);
    //Node getFormNode(Node node);
    public Map<Long, String> getCities(Long id);
    Map<Long, String> getAllCities();
    public Node getInfoNode(long id);
    //Map<Long, String> getCities(Long nodeID); // searching cities linked with that node

}
