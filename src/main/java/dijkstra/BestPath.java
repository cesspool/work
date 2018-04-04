package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import beans.CharacteristicsPath;

public class BestPath {

    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unSettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Double> distance;

    public BestPath(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<>(graph.getVertexes());
        this.edges = new ArrayList<>(graph.getEdges());
    }


    public void execute(Vertex source, boolean key) {
        boolean switcher = key;
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0.0);
        unSettledNodes.add(source);

        while (unSettledNodes.size() > 0) {
            Vertex node = getMinimum(unSettledNodes); //return minimal node
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node, switcher);
        }
    }
    // find node that have minimal distance  from source(and near our previous node)
    private void findMinimalDistances(Vertex node, boolean key) {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target, key)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target, key));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }

    }

    private double getDistance(Vertex node, Vertex target, boolean key) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                if(key)
                    return edge.getWeight();
                else
                    return edge.getCost();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private double getShortestDistance(Vertex destination) {
        Double d = distance.get(destination);
        if (d == null) {
            return Double.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

    public Edge getEdge(Vertex node, Vertex target){
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge;
            }
        }
        return null;
    }

    public CharacteristicsPath getAdditional(LinkedList Path){
        double[] costAndTime = {0.0, 0.0};
        List<Integer> transport = new ArrayList<>();
        int limit = Path.size()-1;
        for(int i = 0; i<limit; i++){
            Vertex node1 = (Vertex) Path.get(i);
            Vertex node2 = (Vertex) Path.get(i+1);
            Edge someEdge = getEdge(node1, node2);
            costAndTime[0] += someEdge.getAdditionalC();
            costAndTime[1] += someEdge.getAdditionalW();
            transport.add(someEdge.getTransport());
        }
        CharacteristicsPath charPath = new CharacteristicsPath();
        charPath.setCost(costAndTime[0]);
        charPath.setTime(costAndTime[1]);
        charPath.setTransport(transport);
        return charPath;
    }

}
