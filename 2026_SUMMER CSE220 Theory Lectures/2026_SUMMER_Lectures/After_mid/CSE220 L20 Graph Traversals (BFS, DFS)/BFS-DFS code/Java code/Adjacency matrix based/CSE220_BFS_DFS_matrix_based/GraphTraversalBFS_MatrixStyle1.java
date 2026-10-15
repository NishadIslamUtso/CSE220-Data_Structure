public class GraphTraversalBFS_MatrixStyle1 {

    public static Object[] bfs_style1(GraphDirectedMatrix graph, int source) {
        int numVertices = graph.getNumVertices();
        boolean[] visited = new boolean[numVertices];
        int[] distance = new int[numVertices];
        Integer[] parent = new Integer[numVertices];

        for (int i = 0; i < numVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = null;
        }

        LinkedListQueue queue = new LinkedListQueue();

        visited[source] = true;
        distance[source] = 0;
        queue.enqueue(source);

        System.out.println("\nBFS starting from vertex " + source + ":");

        while (!queue.isEmpty()) {
            int u = queue.dequeue();
            System.out.println("Visited " + u + " (Distance from source: " + distance[u] + ")");

            for (int v = 0; v < numVertices; v++) {
                if (graph.getAdjMatrix()[u][v] == 1 && distance[v] == Integer.MAX_VALUE) {
                    visited[v] = true;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    queue.enqueue(v);
                }
            }
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
