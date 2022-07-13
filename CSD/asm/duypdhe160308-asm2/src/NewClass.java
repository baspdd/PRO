/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NewClass {

    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.setEdge("A", "E", 1);
        graph.setEdge("A", "B", 2);
        graph.setEdge("A", "D", 7);
        graph.setEdge("B", "C", 3);
        graph.setEdge("C", "D", 1);
        graph.setEdge("D", "E", 10);
        graph.setEdge("F", "G", 1);
        System.out.println(graph.get("A", "G"));
        System.out.println(graph.bfs());
        graph.getNumberOfConnectivityPart();
        System.out.println(graph.dfs());
    }

}
