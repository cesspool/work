package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    private List<Vertex> nodes;
    private List<Edge> edges;

    public static void main (String[] args) {
        Test test = new Test();
        test.testExcute();
    }
    // @Test
    public void testExcute() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }


        List<Double> testD1 = new ArrayList<>(Arrays.asList(85.0,152.0,15.0,16.0));
        List<Double> testD2 = new ArrayList<>(Arrays.asList(2170.0,217.0,1500.0,1600.0));
        List<Double> testD3 = new ArrayList<>(Arrays.asList(1500.0,1520.0,173.0,1006.0));
        List<Double> testD4 = new ArrayList<>(Arrays.asList(186.0,1520.0,1500.0,1600.0));
        List<Double> testD5 = new ArrayList<>(Arrays.asList(103.0,180.0,150.0,106.0));
        List<Double> testD6 = new ArrayList<>(Arrays.asList(183.0,1520.0,1500.0,1600.0));
        List<Double> testD7 = new ArrayList<>(Arrays.asList(250.0,1520.0,1500.0,1600.0));
        List<Double> testD8 = new ArrayList<>(Arrays.asList(84.0,152.0,150.0,160.0));
        List<Double> testD9 = new ArrayList<>(Arrays.asList(167.0,1520.0,1500.0,1600.0));
        List<Double> testD10 = new ArrayList<>(Arrays.asList(502.0,1520.0,1500.0,1600.0));
        List<Double> testD11 = new ArrayList<>(Arrays.asList(40.0,152.0,150.0,160.0));
        List<Double> testD12 = new ArrayList<>(Arrays.asList(600.0,1520.0,1500.0,1600.0));

        List<Double> testC1 = new ArrayList<>(Arrays.asList(234.0,433.0,30.0,433.0));
        List<Double> testC2 = new ArrayList<>(Arrays.asList(453.0,125.0,1500.0,1600.0));
        List<Double> testC3 = new ArrayList<>(Arrays.asList(85.0,152.0,150.0,16.0));
        List<Double> testC4 = new ArrayList<>(Arrays.asList(85.0,152.0,150.0,16.0));
        List<Double> testC5 = new ArrayList<>(Arrays.asList(8500.0,163.0,1500.0,1600.0));
        List<Double> testC6 = new ArrayList<>(Arrays.asList(8500.0,15200.0,361.0,1600.0));
        List<Double> testC7 = new ArrayList<>(Arrays.asList(85.0,152.0,26.0,160.0));
        List<Double> testC8 = new ArrayList<>(Arrays.asList(85.0,71.0,150.0,160.0));
        List<Double> testC9 = new ArrayList<>(Arrays.asList(8500.0,183.0,1500.0,1600.0));
        List<Double> testC10 = new ArrayList<>(Arrays.asList(8500.0,263.0,1500.0,1600.0));
        List<Double> testC11 = new ArrayList<>(Arrays.asList(851.0,172.0,1500.0,1600.0));
        List<Double> testC12 = new ArrayList<>(Arrays.asList(85.0,152.0,20.0,160.0));
        //------------------------------------------------

        addLane("Edge_0", 0, 1, testD1, testC1); //0000
        addLane("Edge_1", 0, 2, testD2, testC2);
        addLane("Edge_2", 0, 4, testD3, testC3);
        addLane("Edge_3", 2, 6, testD4, testC4);
        addLane("Edge_4", 2, 7, testD5, testC5);
        addLane("Edge_5", 3, 7, testD6, testC6);
        addLane("Edge_6", 5, 8, testD7, testC7);
        addLane("Edge_7", 8, 9, testD8, testC8);
        addLane("Edge_8", 7, 9, testD9, testC9);
        addLane("Edge_9", 4, 9, testD10, testC10);
        addLane("Edge_10", 9, 10, testD11, testC11);
        addLane("Edge_11", 1, 10, testD12, testC12); //000

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        BestPath dijkstra = new  BestPath(graph);
        dijkstra.execute(nodes.get(0), true); //false is min from testC
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));
        dijkstra.getAdditional(path);
        // assertNotNull(path);
        // assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
                         List<Double> duration, List<Double> cost) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration, cost );
        edges.add(lane);
    }
}
