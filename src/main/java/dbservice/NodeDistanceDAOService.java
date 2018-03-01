package dbservice;

import beans.Distance;
import beans.Node;
import beans.Transport;

import java.util.Collection;

public interface NodeDistanceDAOService {
    void insertNode(Node node, Collection<Transport> transports, Collection<Distance> distances);
}
