package dijkstra;

import logic.TransCoordinate;
import utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import beans.CharacteristicsPath;
import beans.Distance;
import beans.Node;
import beans.Order;
import beans.Package;
import beans.Rate;
import beans.Transport;
import dbservice.NodeDistanceDAOService;
import dbservice.NodeDistanceDAOServiceImpl;
import exception.PathNotFoundException;

@Component
public class Test {
   
    private NodeDistanceDAOService nodeDistanceDAOService;

    public CharacteristicsPath testExcute(Map<Long, String> nodeMap, List<Distance> distances, List<Transport> transports,
    									List<Rate> rates, Order order, List<Pair<Long, Long>> nodeTransport, Package cargo)
    									throws PathNotFoundException {
    	
        List<Edge> edges = new ArrayList<>();
        List<Vertex> nodes = nodeMap.entrySet()
        		.stream()
        		.map(e -> new Vertex(e.getKey(), e.getValue()))
        		.collect(Collectors.toList());

        int from;
    	int to;
    	int idx = 0;
    	double V = cargo.getHeight() * cargo.getLength() * cargo.getWidth()*cargo.getQuantity();
    	double KCargo;
    	double KRail;
    	double KAir;
    	double coef = getCoef(cargo);
    	
    	if(coef >= 250) {
    		KCargo = cargo.getWeight()*cargo.getQuantity()*rates.get(0).getAdditionalCost();
    	} else if((coef < 250)&&(coef>0)) {
    		KCargo = V*rates.get(0).getAdditionalCost();
    	} else {
    		KCargo = 0.00001*cargo.getQuantity();
    	}
    	if(coef >= 500) {
    		KAir = cargo.getWeight()*cargo.getQuantity()*rates.get(1).getAdditionalCost();
    	} else if((coef < 500)&&(coef>0)) {
    		KAir = V*rates.get(1).getAdditionalCost();
    	} else {
    		KAir = 0.00001*cargo.getQuantity();
    		}
    	if(coef >= 300) {
    		KRail = cargo.getWeight()*cargo.getQuantity()*rates.get(2).getAdditionalCost();
    	} else if((coef < 300)&&(coef>0)) {
    		KRail = V*rates.get(2).getAdditionalCost();
    	} else {
    		KRail = 0.00001*cargo.getQuantity();
    	}
    	
    	double timeAir = Double.MAX_VALUE;
    	double costAir = Double.MAX_VALUE;
    	double timeRail = Double.MAX_VALUE;
    	double costRail = Double.MAX_VALUE;
    	double timeCargo;
    	double costCargo;
    	for (Distance dist : distances) {
    		
    		//if ((nodeTransport.get(dist.getNodeFrom()).equals(nodeTransport.get(dist.getNodeTo()))) && 
    		//								(nodeTransport.get(dist.getNodeFrom()).longValue() == 2L)) {
    		if (isHaveEqualTransport(nodeTransport, dist, 2L)) {
            	timeAir = dist.getLength() / transports.get(1).getAvSpeed();
            	costAir = dist.getLength() * rates.get(1).getCostKm() + 
            			(dist.getLength() * rates.get(1).getCostKm())*KAir + 
            			(dist.getLength() * rates.get(1).getCostKm())*rates.get(1).getCostShipping();
            	
    		}
   		
    		if (isHaveEqualTransport(nodeTransport, dist, 3L)) {
            	timeRail = dist.getLength() / transports.get(2).getAvSpeed();
            	costRail = dist.getLength() * rates.get(2).getCostKm() +
            			(dist.getLength() * rates.get(2).getCostKm())*KRail + 
            			(dist.getLength() * rates.get(2).getCostKm())*rates.get(2).getCostShipping();
            	
    		}
    		
    		from = getIndexById(dist.getNodeFrom(), nodes);
    		to = getIndexById(dist.getNodeTo(), nodes);
    		
    		timeCargo = dist.getLength() / transports.get(0).getAvSpeed();
        	costCargo = (dist.getLength() * rates.get(0).getCostKm()) + 
        			(dist.getLength() * rates.get(0).getCostKm())*KCargo + 
        			(dist.getLength() * rates.get(0).getCostKm())*rates.get(0).getCostShipping();
        	
        	
        	//double timeAir = Double.MAX_VALUE;
        	
        	
        	List<Double> edgeTime = new ArrayList<>(Arrays.asList(timeCargo, timeAir, timeRail));
        	List<Double> edgeCost = new ArrayList<>(Arrays.asList(costCargo,costAir,costRail));
        	
        	addLane("Edge_"+idx++, from, to, edgeTime, edgeCost, nodes, edges);
    	}
    	
    	
    	//get all id of nodes from nodeTransport where transportId=2, convert into index of list<Nodes>
    	//create edges with all combinations of this nodes if such edge doesnt exist
    	//do the same with transportId=3
    	
    	//nodeMap 
    	//nodeTransport
    	
    	timeAir = Double.MAX_VALUE;
    	costAir = Double.MAX_VALUE;
    	timeRail = Double.MAX_VALUE;
    	costRail = Double.MAX_VALUE;
    	timeCargo = Double.MAX_VALUE;
    	costCargo = Double.MAX_VALUE;
    	List<Long> airList = new ArrayList();
    	List<Long> railList = new ArrayList();
    	for (int i=0; i< nodeTransport.size(); i++) {
    		if(nodeTransport.get(i).getRight()==2L) {
    			airList.add(nodeTransport.get(i).getLeft());
    		}
    		if(nodeTransport.get(i).getRight()==3L) {
    			railList.add(nodeTransport.get(i).getLeft());
    		}
    	}
    	
    	Node startNode = new Node();
    	Node endNode = new Node();
    	double legthDist;
    	TransCoordinate transCoordinate = new TransCoordinate();
    	for(int i=0; i<airList.size()-1; i++) {
    		for(int k=1+i; k<airList.size();k++) {
    			if (!checkEdge(edges, nodes.get(getIndexById(airList.get(i), nodes)), nodes.get(getIndexById(airList.get(k), nodes)))) {
	    			startNode = nodeDistanceDAOService.getCoordinate(airList.get(i));
	    			endNode = nodeDistanceDAOService.getCoordinate(airList.get(k));
	    			legthDist = transCoordinate.setGeoCoordinate(startNode.getCoordinateX(), startNode.getCoordinateY(),
	    												endNode.getCoordinateX(), endNode.getCoordinateY());
	    			timeAir = legthDist / transports.get(1).getAvSpeed();
	            	costAir = legthDist * rates.get(1).getCostKm() + 
	            			(legthDist * rates.get(1).getCostKm())*KAir + 
	            			(legthDist * rates.get(1).getCostKm())*rates.get(1).getCostShipping();
	            	
	            	List<Double> edgeTime = new ArrayList<>(Arrays.asList(timeCargo, timeAir, timeRail));
	            	List<Double> edgeCost = new ArrayList<>(Arrays.asList(costCargo,costAir,costRail));
	            	
	            	addLane("Edge_"+idx++, getIndexById(airList.get(i), nodes), getIndexById(airList.get(k), nodes), edgeTime, edgeCost, nodes, edges);
    			}
    		}
    	}
    	
    	
    	timeAir = Double.MAX_VALUE;
    	costAir = Double.MAX_VALUE;
    	timeRail = Double.MAX_VALUE;
    	costRail = Double.MAX_VALUE;
    	timeCargo = Double.MAX_VALUE;
    	costCargo = Double.MAX_VALUE;
    	
    	for(int i=0; i<railList.size()-1; i++) {
    		for(int k=1+i; k<railList.size();k++) {
    			if (!checkEdge(edges, nodes.get(getIndexById(railList.get(i), nodes)), nodes.get(getIndexById(railList.get(k),nodes)))) {
	    			startNode = nodeDistanceDAOService.getCoordinate(railList.get(i));
	    			endNode = nodeDistanceDAOService.getCoordinate(railList.get(k));
	    			legthDist = transCoordinate.setGeoCoordinate(startNode.getCoordinateX(), startNode.getCoordinateY(),
	    												endNode.getCoordinateX(), endNode.getCoordinateY());
	    			timeRail = legthDist / transports.get(2).getAvSpeed();
	            	costRail = legthDist * rates.get(2).getCostKm() + 
	            			(legthDist * rates.get(2).getCostKm())*KRail + 
	            			(legthDist * rates.get(2).getCostKm())*rates.get(2).getCostShipping();
	            	
	            	List<Double> edgeTime = new ArrayList<>(Arrays.asList(timeCargo, timeAir, timeRail));
	            	List<Double> edgeCost = new ArrayList<>(Arrays.asList(costCargo,costAir,costRail));
	            	
	            	addLane("Edge_"+idx++, getIndexById(railList.get(i), nodes), getIndexById(railList.get(k),nodes), edgeTime, edgeCost, nodes, edges);
    			}
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    	
        int NodeFrom = getIndexById(order.getNodeStart(), nodes);
        int NodeTarget = getIndexById(order.getNodeTarget(), nodes);
    	Graph graph = new Graph(nodes, edges);
        BestPath dijkstra = new  BestPath(graph);
        dijkstra.execute(nodes.get(NodeFrom), order.isUrgency()); //false is min from testC
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(NodeTarget));
        if (path == null) {
        	throw new PathNotFoundException("test.no-path");
        }
        CharacteristicsPath charPath = dijkstra.getAdditional(path);
        
        // assertNotNull(path);
        // assertTrue(path.size() > 0);

        List<String> pathStr = new ArrayList<>();
        List<Long> pathId = new ArrayList<>();
        for (Vertex vertex : path) {
        	pathStr.add(vertex.getName());
        	pathId.add(vertex.getId());
        }
        charPath.setPath(pathStr);
        charPath.setPathId(pathId);
        return charPath;

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         List<Double> duration, List<Double> cost, List<Vertex> nodes, final List<Edge> edges) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration, cost );
        edges.add(lane);
    }
    
    //true if such edge is existing
    private boolean checkEdge(List<Edge> edges, Vertex nodeSource, Vertex nodeDest) {
	    boolean isFound = edges.stream().anyMatch(edge -> {
        	return (edge.getSource().equals(nodeSource) && edge.getDestination().equals(nodeDest)) ||
        			(edge.getDestination().equals(nodeSource) && edge.getSource().equals(nodeDest));
        });
	    return isFound;
    }
    
    
    
    
    
    public int getIndexById(long toFind, List<Vertex> nodes) {
        OptionalInt optResult = IntStream.range(0,  nodes.size()).filter(idx -> nodes.get(idx).getId() == toFind).findFirst();
        int result = optResult.getAsInt();
        return result;
    }
    
    public double getCoef(Package cargo) {
    	double V = cargo.getHeight() * cargo.getLength() * cargo.getWidth();
    	if ((cargo.getWeight()>500)||(V>1.5)||((cargo.getHeight() + cargo.getLength() + cargo.getWidth())>5)) {
    		V=V*1.25;
    	}
    	else {
    		V=V*1.1;
    	}
    	double coef = cargo.getWeight()/V;
    	return coef;
    }
    
    //startNodeTransport list of Pair<nodeID, transportID>
    private boolean isHaveEqualTransport(List<Pair<Long, Long>> nodeTransport, 
    									 Distance dist, 
    									 Long transportID) {
    	Optional<Pair<Long, Long>> start = nodeTransport.stream()
    						.filter(pair -> pair.getLeft().equals(dist.getNodeFrom()))
    						.filter(pair -> pair.getRight().equals(transportID))
    						.findFirst();
    	
    	
    	Optional<Pair<Long, Long>> end = nodeTransport.stream()
    						.filter(pair -> pair.getLeft().equals(dist.getNodeTo()))
    						.filter(pair -> pair.getRight().equals(transportID))
    						.findFirst();
    	return start.isPresent() && end.isPresent();
    }

    @Autowired
	private void setNodeDistanceDAOService(NodeDistanceDAOService nodeDistanceDAOService) {
		this.nodeDistanceDAOService = nodeDistanceDAOService;
	}
    
    
//	List<List<Double>> totalEdgeTime = new ArrayList<>();
//	List<List<Double>> totalEdgeCost = new ArrayList<>();
    
}
