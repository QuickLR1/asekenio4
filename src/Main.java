public class Main {
    public static void main(String[] args) {
        WeightedGraph<Vertex> graph = new WeightedGraph<>();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        graph.addEdge(a, b, 1);
        graph.addEdge(a, c, 4);
        graph.addEdge(b, c, 2);
        graph.addEdge(c, d, 1);

        System.out.println("BFS:");
        Search<Vertex> bfs = new BreadthFirstSearch<>(graph, a);
        System.out.println(bfs.pathTo(d));

        System.out.println("Dijkstra:");
        Search<Vertex> dijkstra = new DijkstraSearch<>(graph, a);
        System.out.println(dijkstra.pathTo(d));
    }
}