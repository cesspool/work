package service;

import beans.Boxing;
import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import dbservice.NodeDistanceDAOService;
import form.request.NewBoxingForm;
import form.request.NewNodeForm;
import utils.Tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class NodeDistanceServiceImpl implements NodeDistanceService {
    private static final Logger logger = LoggerFactory.getLogger(NodeDistanceServiceImpl.class);
    static private int i=7;
    @Autowired
    private NodeDistanceDAOService nodeDistanceDAOService;

    @Override
    public void createNode(NodeDistance nodeDistance){
    	//node = getFormNode(node);
    	i++;
    	nodeDistance.getNode().setCode("Node_"+i);
    	
        nodeDistanceDAOService.insertNode(nodeDistance);
    }
    
    @Override
    public NodeDistance createNode(NewNodeForm nodeForm) {
        NodeDistance nodeDistance = Tools.NewNodeFormToNodeDistance(nodeForm);
        createNode(nodeDistance);
        return nodeDistance;
    }

    @Override
    public Map<Long, String> getAllCities() {
        return nodeDistanceDAOService.getAllCities();
    }

//    @Override   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    public Map<Long, String> getCities(Long nodeID) {
//        return nodeDistanceDAOService.getCities(nodeID);
//    }
    
//    @Override
//    public Node getFormNode(Node node) {
//    	i++;
//    	node.setCode("Node_" + i);
//    	return node;
//    }
}
