package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class WeightedGraph<T> {
    private Map<T, Vertex<T>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addEdge(T u, T v, int weight) {
        if (!vertices.containsKey(u)) vertices.put(u, new Vertex<>(u));
        if (!vertices.containsKey(v)) vertices.put(v, new Vertex<>(v));
        Vertex<T> uVertex = vertices.get(u);
        Vertex<T> vVertex = vertices.get(v);
        uVertex.addEdge(vVertex, weight);
        vVertex.addEdge(uVertex, weight);
    }

    public List<List<Vertex<T>>> bfs() {
        List<List<Vertex<T>>> connectedComponentList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        vertices.values().forEach(vertex -> {
            if (visited.containsKey(vertex)) return;
            List<Vertex<T>> connectedComponent = new ArrayList<>();
            connectedComponentList.add(connectedComponent);
            List<Vertex<T>> queue = new LinkedList<>();
            queue.add(vertex);
            while (!queue.isEmpty()) {
                Vertex<T> next = queue.remove(0);
                if (visited.containsKey(next)) continue;
                visited.put(next, true);
                connectedComponent.add(next);
                next.getAdjList().forEach(edge -> {
                    if (visited.containsKey(edge.getV())) return;
                    queue.add(edge.getV());
                });
            }
        });
        return connectedComponentList;
    }

    public List<List<Vertex<T>>> dfs() {
        List<List<Vertex<T>>> connectedComponentList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        vertices.values().forEach(vertex -> {
            if (visited.containsKey(vertex)) return;
            List<Vertex<T>> connectedComponent = new ArrayList<>();
            connectedComponentList.add(connectedComponent);
            List<Vertex<T>> stack = new LinkedList<>();
            stack.add(vertex);
            while (!stack.isEmpty()) {
                Vertex<T> next = stack.remove(stack.size()-1);
                if (visited.containsKey(next)) continue;
                visited.put(next, true);
                connectedComponent.add(next);
                next.getAdjList().forEach(edge -> {
                    if (visited.containsKey(edge.getV())) return;
                    stack.add(edge.getV());
                });
            }
        });
        return connectedComponentList;
    }
}
