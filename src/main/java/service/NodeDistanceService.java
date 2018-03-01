package service;

import beans.Distance;
import beans.Node;
import beans.Transport;

import java.util.Collection;

public interface NodeDistanceService {
    void createNode(Node node, Collection<Transport> transports, Collection<Distance> distances);
}
