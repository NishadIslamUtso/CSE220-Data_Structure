public class GraphTraversalAlgorithmsDFS {

    // Constants for colors
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    public static Object[] dfs(GraphDirectedAdjacencyList graph) {
        int numVertices = graph.getNumVertices();

        int[] colors = new int[numVertices];
        Integer[] parents = new Integer[numVertices];
        int[] discoveryTime = new int[numVertices];
        int[] finishingTime = new int[numVertices];

        int time = 0; 

        for (int u = 0; u < numVertices; u++) {
            colors[u] = WHITE;
            parents[u] = null;
        }

        for (int u = 0; u < numVertices; u++) {
            if (colors[u] == WHITE) {
                dfsVisit(graph, u, colors, parents, discoveryTime, finishingTime, time);
            }
        }

        return new Object[]{discoveryTime, finishingTime, parents};
    }

    private static void dfsVisit(GraphDirectedAdjacencyList graph, int u, int[] colors,
                                  Integer[] parents, int[] discoveryTime, int[] finishingTime, int time) {
        colors[u] = GRAY;
        time++;
        discoveryTime[u] = time;

        Edge current = graph.getAdjList()[u];
        while (current != null) {
            int v = current.destination;
            if (colors[v] == WHITE) {
                parents[v] = u;
                dfsVisit(graph, v, colors, parents, discoveryTime, finishingTime, time);
            }
            current = current.next;
        }

        colors[u] = BLACK;
        time++;
        finishingTime[u] = time;
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

        System.out.println("Graph (Adjacency List):");
        graph.printList();

        Object[] result = dfs(graph);
        int[] dTime = (int[]) result[0];
        int[] fTime = (int[]) result[1];
        Integer[] parents = (Integer[]) result[2];

        System.out.println("\nDFS Results:");
    
        for (int v = 0; v < numVertices; v++) {
            String parentStr;
            if (parents[v] != null) {
                parentStr = parents[v].toString();
            } else {
                parentStr = "null";
            }
            System.out.println("Vertex " + v + ": d = " + dTime[v] + ", f = " + fTime[v] + ", parent = " + parentStr);
        }
        
        System.out.println("----------------------------");
        System.out.println("printPath for DFS");
        // Print paths from source (0) to various destinations
        System.out.println("\nPath from 0 to 2:");
        GraphTraversalBFS.printPath(parents, 0, 2);
        System.out.println();
        
        System.out.println("Path from 0 to 4:");
        GraphTraversalBFS.printPath(parents, 0, 4);
        System.out.println();
        
        System.out.println("Path from 0 to 3:");
        GraphTraversalBFS.printPath(parents, 0, 3);
        System.out.println();
  
    }
}
