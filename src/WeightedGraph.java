import java.util.*;

public class WeightedGraph<V> {
    private final Map<V, Map<V, Double>> adjacencyMap = new HashMap<>();

    public void addVertex(V vertex) {
        adjacencyMap.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(V source, V destination, double weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyMap.get(source).put(destination, weight);
    }

    public Set<V> getVertices() {
        return adjacencyMap.keySet();
    }

    public Map<V, Double> getAdjVertices(V vertex) {
        return adjacencyMap.getOrDefault(vertex, new HashMap<>());
    }
}
