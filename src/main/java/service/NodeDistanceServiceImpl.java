package service;

import beans.Distance;
import beans.Node;
import beans.Transport;
import dbservice.NodeDistanceDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class NodeDistanceServiceImpl implements NodeDistanceService {
    private static final Logger logger = LoggerFactory.getLogger(NodeDistanceServiceImpl.class);

    private NodeDistanceDAOService nodeDistanceDAOService;

    @Override
    public void createNode(Node node, Collection<Transport> transports, Collection<Distance> distances){

        nodeDistanceDAOService.insertNode(node, transports, distances);
    }
}
