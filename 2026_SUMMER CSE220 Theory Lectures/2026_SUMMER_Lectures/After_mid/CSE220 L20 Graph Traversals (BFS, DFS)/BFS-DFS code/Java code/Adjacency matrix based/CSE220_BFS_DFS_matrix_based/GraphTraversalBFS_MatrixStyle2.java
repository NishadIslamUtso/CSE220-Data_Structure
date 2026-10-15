public class GraphTraversalBFS_MatrixStyle2 {

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    public static Object[] bfs_style2(GraphDirectedMatrix graph, int s) {
        int numVertices = graph.getNumVertices();

        int[] color = new int[numVertices];
        int[] distance = new int[numVertices];
        Integer[] parent = new Integer[numVertices];

        for (int u = 0; u < numVertices; u++) {
            if (u != s) {
                color[u] = WHITE;
                distance[u] = Integer.MAX_VALUE;
                parent[u] = null;
            }
        }

        color[s] = GRAY;
        distance[s] = 0;
        parent[s] = null;

        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(s);

        System.out.println("\nBFS starting from vertex " + s + ":");

        while (!queue.isEmpty()) {
            int u = queue.dequeue();
            System.out.println("Visited " + u + " (Distance from source: " + distance[u] + ")");

            for (int v = 0; v < numVertices; v++) {
                if (graph.getAdjMatrix()[u][v] == 1 && color[v] == WHITE) {
                    color[v] = GRAY;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    queue.enqueue(v);
                }
            }

            color[u] = BLACK;
        }

        return new Object[]{distance, parent};
    }

    public static void printPath(Integer[] parent, int s, int v) {
        if (v == s) {
            System.out.print(s + " ");
        } else if (parent[v] == null) {
            System.out.println("No path from " + s + " to " + v);
        } else {
            printPath(parent, s, parent[v]);
            System.out.print(v + " ");
        }
    }
}