public class GraphTraversalBFS {

    public static Object[] bfs(GraphDirectedAdjacencyList graph, int source) {
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
    
            Edge current = graph.getAdjList()[u];
    
            while (current != null) {
                int v = current.destination;
                if (distance[v] == Integer.MAX_VALUE) {
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                    visited[v] = true;
                    queue.enqueue(v);
                }
                current = current.next;
            }
        }
    
        return new Object[]{distance, parent};
    }
    
    // Recursive method to print path from s to v using the parent array
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
    
    
        // Print paths from source (0) to various destinations
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
