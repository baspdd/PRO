
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class WeightedGraph<T> {

    private Map<T, Vertex<T>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public int get(T u, T v) {
        if (vertices.containsKey(u) && vertices.containsKey(v)) {
            Vertex<T> uVertex = vertices.get(u);
            Vertex<T> vVertex = vertices.get(v);
            return uVertex.getEdge(vVertex);
        }
        return 0;
    }

    public void setEdge(T u, T v, int weight) {
        if (!vertices.containsKey(u)) {
            vertices.put(u, new Vertex<>(u));
        }
        if (!vertices.containsKey(v)) {
            vertices.put(v, new Vertex<>(v));
        }
        Vertex<T> uVertex = vertices.get(u);
        Vertex<T> vVertex = vertices.get(v);
        uVertex.addEdge(vVertex, weight);
        vVertex.addEdge(uVertex, weight);
    }

    public List<List<Vertex<T>>> bfs() {
        List<List<Vertex<T>>> connectedList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        vertices.values().forEach(vertex -> {
            if (visited.containsKey(vertex)) {
                return;
            }
            List<Vertex<T>> Component = new ArrayList<>();
            connectedList.add(Component);
            List<Vertex<T>> queue = new LinkedList<>();
            queue.add(vertex);
            while (!queue.isEmpty()) {
                Vertex<T> next = queue.remove(0);
                if (visited.containsKey(next)) {
                    continue;
                }
                visited.put(next, true);
                Component.add(next);
                next.getAdjList().forEach(edge -> {
                    if (visited.containsKey(edge.getV())) {
                        return;
                    }
                    queue.add(edge.getV());
                });
            }
        });
        return connectedList;
    }

    public List<List<Vertex<T>>> dfs() {
        List<List<Vertex<T>>> connectedList = new ArrayList<>();
        Map<Vertex<T>, Boolean> visited = new HashMap<>();
        vertices.values().forEach(vertex -> {
            if (visited.containsKey(vertex)) {
                return;
            }
            List<Vertex<T>> Component = new ArrayList<>();
            connectedList.add(Component);
            Stack<Vertex<T>> stack = new Stack<>();
            stack.push(vertex);
            while (!stack.isEmpty()) {
                Vertex<T> next = stack.pop();
                if (visited.containsKey(next)) {
                    continue;
                }
                visited.put(next, true);
                Component.add(next);
                next.getAdjList().forEach(edge -> {
                    if (visited.containsKey(edge.getV())) {
                        return;
                    }
                    stack.push(edge.getV());
                });
            }
        });
        return connectedList;
    }

    public void getNumberOfConnectivityPart() {
        List<List<Vertex<T>>> list = bfs();
        for (List<Vertex<T>> list1 : list) {
            System.out.println(list1.size());
        }
    }

    public boolean isConnectivity() {
        List<List<Vertex<T>>> list = bfs();
        if (list.size() != 1) {
            return false;
        }
        return true;
    }

}
