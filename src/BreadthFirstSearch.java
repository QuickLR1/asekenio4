import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private final Map<V, V> edgeTo = new HashMap<>();
    private final Set<V> visited = new HashSet<>();
    private final V start;
    private final WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        this.graph = graph;
        this.start = start;
        bfs(start);
    }

    private void bfs(V root) {
        Queue<V> queue = new LinkedList<>();
        visited.add(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            for (V neighbor : graph.getAdjVertices(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.offer(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(V destination) {
        return visited.contains(destination);
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
