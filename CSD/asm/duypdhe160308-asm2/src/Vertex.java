
import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {

    private final T value;
    private final List<Edge<T>> adjList;

    protected Vertex(T value) {
        this.value = value;
        this.adjList = new ArrayList<>();
    }

    public Vertex(T value, List<Edge<T>> adjList) {
        this.value = value;
        this.adjList = adjList;
    }

    public T getValue() {
        return this.value;
    }

    public List<Edge<T>> getAdjList() {
        return this.adjList;
    }

    public void addEdge(Vertex<T> v, int weight) {
        adjList.add(new Edge<T>(this, v, weight));
    }
    
    public int getEdge(Vertex<T> v) {
        for (Edge<T> edge : adjList) {
            if (edge.getU().equals(this) && edge.getV().equals(v)) {
                return edge.getWeight();
            }
        }
        return 0;
    }
    

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vertex<?>) {
            return this.value.equals(((Vertex<?>) obj).value);
        }
        return this.value.equals(obj);
    }

    public int hashCode() {
        return value.hashCode();
    }

    public String toString() {
        return value.toString();
    }
}
