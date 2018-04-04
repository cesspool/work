package dijkstra;

import logic.TransCoordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import beans.CharacteristicsPath;
import beans.Distance;
import beans.Order;
import beans.Transport;

public class Test {
    private List<Edge> edges;

    public CharacteristicsPath testExcute(Map<Long, String> nodeMap, List<Distance> distances,
    									List<Transport> transports, Order order, Map<Long, Long> nodeTransport) {
    	
        edges = new ArrayList<>();

        List<Vertex> nodes = nodeMap.entrySet()
        		.stream()
        		.map(e -> new Vertex(e.getKey(), e.getValue()))
        		.collect(Collectors.toList());

        int from;
    	int to;
    	
    	for (int i=0; i<distances.size(); i++) {
    		from = getIndexById(distances.get(i).getNodeFrom(), nodes);
    		to = getIndexById(distances.get(i).getNodeTo(), nodes);
    		
    		double timeCargo = distances.get(i).getLength() / transports.get(0).getAvSpeed();
        	double costCargo = distances.get(i).getLength() * transports.get(0).getCostKm();
        	
        	
        	double timeAir = distances.get(i).getLength() / transports.get(1).getAvSpeed();
        	double costAir = distances.get(i).getLength() * transports.get(1).getCostKm();
        	
        	double timeRail = distances.get(i).getLength() / transports.get(2).getAvSpeed();
        	double costRail = distances.get(i).getLength() * transports.get(2).getCostKm();
        	
        	List<Double> edgeTime = new ArrayList<>(Arrays.asList(timeCargo, timeAir, timeRail));
        	List<Double> edgeCost = new ArrayList<>(Arrays.asList(costCargo,costAir,costRail));
        	
        	addLane("Edge_"+i, from, to, edgeTime, edgeCost, nodes);
    	}
    	
        int NodeFrom = getIndexById(order.getNodeStart(), nodes);
        int NodeTarget = getIndexById(order.getNodeTarget(), nodes);
    	Graph graph = new Graph(nodes, edges);
        BestPath dijkstra = new  BestPath(graph);
        dijkstra.execute(nodes.get(NodeFrom), order.isUrgency()); //false is min from testC
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(NodeTarget));
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
    
    
//	List<List<Double>> totalEdgeTime = new ArrayList<>();
//	List<List<Double>> totalEdgeCost = new ArrayList<>();
    
}
