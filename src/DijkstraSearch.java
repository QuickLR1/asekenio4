import java.util.*;

public class DijkstraSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo = new HashMap<>();
    private final Map<V, Double> distTo = new HashMap<>();
    private final V start;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        this.start = start;

        for (V v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);

        PriorityQueue<V> queue = new PriorityQueue<>(Comparator.comparingDouble(distTo::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (Map.Entry<V, Double> neighborEntry : graph.getAdjVertices(current).entrySet()) {
                V neighbor = neighborEntry.getKey();
                double newDist = distTo.get(current) + neighborEntry.getValue();
                if (newDist < distTo.get(neighbor)) {
                    distTo.put(neighbor, newDist);
                    edgeTo.put(neighbor, current);
                    queue.remove(neighbor); // to update priority
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return distTo.get(destination) < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<V> pathTo(V destination) {
        if (!hasPathTo(destination)) return null;
        LinkedList<V> path = new LinkedList<>();
        for (V at = destination; at != null; at = edgeTo.get(at)) {
            path.addFirst(at);
        }
        return path;
    }
}
