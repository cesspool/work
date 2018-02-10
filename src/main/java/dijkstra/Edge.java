package dijkstra;

import java.util.Collections;
import java.util.List;

public class Edge {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private List<Double> weight;
    private List<Double> cost;
    private int transport;

    public Edge(String id, Vertex source, Vertex destination, List<Double> weight, List<Double> cost) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.cost = cost;
    }

    public int getTransport(){
        return transport;
    }

    public double getAdditionalC(){
        return cost.get(this.transport);
    }

    public double getAdditionalW(){
        return weight.get(this.transport);
    }


    public double getCost(){
        this.transport = getElement(cost);
        return Collections.min(cost);
    }

    public String getId() {
        return id;
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public double getWeight() {
        this.transport = getElement(weight);
        return Collections.min(weight);
    }

    @Override
    public String toString() {
        return source + " " + destination;
    }

    private int getElement(List<Double> mas){
        double min = Double.MAX_VALUE;
        int limit = mas.size();
        int minPosition = -1;
        for (int i=0; i< limit; i++){
            double value = mas.get(i);
            if (value < min){
                min = value;
                minPosition = i;
            }
        }
        return minPosition;
    }
}
