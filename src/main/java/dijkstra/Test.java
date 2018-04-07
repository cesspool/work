package dijkstra;

import logic.TransCoordinate;
import utils.Pair;
import utils.TimeCostCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import beans.CharacteristicsPath;
import beans.Distance;
import beans.Order;
import beans.Package;
import beans.Rate;
import beans.Transport;
import exception.PathNotFoundException;

public class Test {
    private List<Edge> edges = new ArrayList<>();;

    public CharacteristicsPath testExcute(Map<Long, String> nodeMap, List<Distance> distances, List<Transport> transports,
    									List<Rate> rates, Order order, List<Pair<Long, Long>> nodeTransport, Package cargo)
    									throws PathNotFoundException {
    	

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
    	for (Distance dist : distances) {
    		
    		//if ((nodeTransport.get(dist.getNodeFrom()).equals(nodeTransport.get(dist.getNodeTo()))) && 
    		//								(nodeTransport.get(dist.getNodeFrom()).longValue() == 2L)) {
    		if (isHaveEqualTransport(nodeTransport, dist, 2L)) {
            	timeAir = dist.getLength() / transports.get(1).getAvSpeed();
            	costAir = dist.getLength() * transports.get(1).getCostKm() + 
            			(dist.getLength() * transports.get(1).getCostKm())*KAir + 
            			(dist.getLength() * transports.get(1).getCostKm())*rates.get(1).getCostShipping();
            	
    		}
   		
    		if (isHaveEqualTransport(nodeTransport, dist, 3L)) {
            	timeRail = dist.getLength() / transports.get(2).getAvSpeed();
            	costRail = dist.getLength() * transports.get(2).getCostKm() +
            			(dist.getLength() * transports.get(2).getCostKm())*KRail + 
            			(dist.getLength() * transports.get(2).getCostKm())*rates.get(2).getCostShipping();
            	
    		}
    		
    		from = getIndexById(dist.getNodeFrom(), nodes);
    		to = getIndexById(dist.getNodeTo(), nodes);
    		
    		double timeCargo = dist.getLength() / transports.get(0).getAvSpeed();
        	double costCargo = (dist.getLength() * transports.get(0).getCostKm()) + 
        			(dist.getLength() * transports.get(0).getCostKm())*KCargo + 
        			(dist.getLength() * transports.get(0).getCostKm())*rates.get(0).getCostShipping();
        	
        	
        	//double timeAir = Double.MAX_VALUE;
        	
        	
        	List<Double> edgeTime = new ArrayList<>(Arrays.asList(timeCargo, timeAir, timeRail));
        	List<Double> edgeCost = new ArrayList<>(Arrays.asList(costCargo,costAir,costRail));
        	
        	addLane("Edge_"+idx++, from, to, edgeTime, edgeCost, nodes);
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
        for (Vertex vertex : path) {
        	pathStr.add(vertex.getName());
        }
        charPath.setPath(pathStr);
        return charPath;

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         List<Double> duration, List<Double> cost, List<Vertex> nodes) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration, cost );
        edges.add(lane);
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
//	List<List<Double>> totalEdgeTime = new ArrayList<>();
//	List<List<Double>> totalEdgeCost = new ArrayList<>();
    
}
