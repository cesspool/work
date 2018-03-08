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
    //private int i=3;
    
    private NodeDistanceDAOService nodeDistanceDAOService;

    @Override
    public void createNode(Node node, Collection<Transport> transports, Collection<Distance> distances){
    	//node = getFormNode(node);
        nodeDistanceDAOService.insertNode(node, transports, distances);
    }
    
//    @Override
//    public Node getFormNode(Node node) {
//    	i++;
//    	node.setCode("Node_" + i);
//    	return node;
//    }
}
