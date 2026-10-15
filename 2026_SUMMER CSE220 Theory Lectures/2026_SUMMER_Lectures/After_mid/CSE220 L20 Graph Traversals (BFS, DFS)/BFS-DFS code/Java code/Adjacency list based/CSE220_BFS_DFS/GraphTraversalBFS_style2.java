public class GraphTraversalBFS_style2 {

    // Constants for vertex colors
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    public static Object[] bfs(GraphDirectedAdjacencyList graph, int s) {
        int numVertices = graph.getNumVertices();

        int[] color = new int[numVertices];             // WHITE, GRAY, BLACK
        int[] distance = new int[numVertices];          // Distance from source
        Integer[] parent = new Integer[numVertices];    // Parent array

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

        LinkedListQueue Q = new LinkedListQueue();
        Q.enqueue(s);

        System.out.println("\nBFS starting from vertex " + s + ":");

        while (!Q.isEmpty()) {
            int u = Q.dequeue();
            System.out.println("Visited " + u + " (Distance from source: " + distance[u] + ")");

            Edge current = graph.getAdjList()[u];

            while (current != null) {
                int v = current.destination;
                if (color[v] == WHITE) {
                    color[v] = GRAY;
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    Q.enqueue(v);
                }
                current = current.next;
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

    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1}, {0, 3},
            {1, 2}, {1, 4},
            {3, 1}, {3, 4},
            {4, 2}
        };

        GraphDirectedAdjacencyList graph = new GraphDirectedAdjacencyList(numVertices);
        graph.addEdges(edges);
        graph.printList();

        Object[] result = bfs(graph, 0);
        int[] distance = (int[]) result[0];
        Integer[] parent = (Integer[]) result[1];

        System.out.println("\nResults (Vertex, Distance, Parent):");
        for (int v = 0; v < numVertices; v++) {
            String parentStr;
            if (parent[v] != null) {
                parentStr = parent[v].toString();
            } else {
                parentStr = "null";
            }
            System.out.println("(" + v + ", " + distance[v] + ", " + parentStr + ")");
        }

        System.out.println("----------------------------");
        System.out.println("printPath for BFS");

        System.out.println("\nPath from 0 to 2:");
        printPath(parent, 0, 2);
        System.out.println();

        System.out.println("Path from 0 to 4:");
        printPath(parent, 0, 4);
        System.out.println();

        System.out.println("Path from 0 to 3:");
        printPath(parent, 0, 3);
        System.out.println();

        System.out.println("----------------------------");
    }
}
