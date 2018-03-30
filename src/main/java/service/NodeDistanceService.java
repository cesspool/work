package service;

import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import form.request.NewNodeForm;

import java.util.Collection;

public interface NodeDistanceService {
    void createNode(NodeDistance nodeDistance);
    NodeDistance createNode(NewNodeForm nodeForm);
    //Node getFormNode(Node node);
}
