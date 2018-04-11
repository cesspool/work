package service;

import beans.Boxing;
import beans.Distance;
import beans.Node;
import beans.NodeDistance;
import beans.Transport;
import dbservice.NodeDistanceDAOService;
import form.request.NewBoxingForm;
import form.request.NewNodeForm;
import utils.Pair;
import utils.Tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NodeDistanceServiceImpl implements NodeDistanceService {
    private static final Logger logger = LoggerFactory.getLogger(NodeDistanceServiceImpl.class);
    static private int i=7;
    @Autowired
    private NodeDistanceDAOService nodeDistanceDAOService;

    
    @Override
    public void changeNodeById(NewNodeForm nodeForm) {
    	NodeDistance nodeDistance = Tools.NewNodeFormToNodeDistance(nodeForm);
    	nodeDistanceDAOService.updateNode(nodeDistance);
    	//nodeDistanceDAOService.getCities(id);
    }
    
    @Override
    public Node getInfoNode(long id) {
    	Node node = new Node();
    	node = nodeDistanceDAOService.getNode(id);
    	List<Pair<Long, Long>> nodeTransport = nodeDistanceDAOService.getAllNodeTransports();
    	if (isHaveTransport(nodeTransport, node.getId(), 2L)) {
    		node.setAirport("checked");
    	}
    	if (isHaveTransport(nodeTransport, node.getId(), 3L)) {
    		node.setRail("checked");
    	}
    	return node;
    }
    
    private boolean isHaveTransport(List<Pair<Long, Long>> nodeTransport, Long nodeId, Long transportID) {
			Optional<Pair<Long, Long>> start = nodeTransport.stream()
			.filter(pair -> pair.getLeft().equals(nodeId))
			.filter(pair -> pair.getRight().equals(transportID))
			.findFirst();
			
			return start.isPresent();
}
    
    @Override
    public Map<Long, String> getCities(Long id) {
    	Map<Long, String> citiesMap = new HashMap<>();
    	List<Pair<Long, Long>> cities = nodeDistanceDAOService.getCities(id);
    	List<Long> ids = cities.stream()
    		  .map(pair -> {
	    		if(pair.getLeft().equals(id)) return pair.getRight();
	    		if(pair.getRight().equals(id)) return pair.getLeft();
	    		return null;
    	}).filter(Objects::nonNull)
    	.collect(Collectors.toList());
    	for (Long identify : ids) {
    		citiesMap.put(identify, nodeDistanceDAOService.getNode(identify).getCity());
    	}
    	return citiesMap;
    }

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
    public void deleteNodeById(Long ID) {
    	nodeDistanceDAOService.deleteNodeById(ID);
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
