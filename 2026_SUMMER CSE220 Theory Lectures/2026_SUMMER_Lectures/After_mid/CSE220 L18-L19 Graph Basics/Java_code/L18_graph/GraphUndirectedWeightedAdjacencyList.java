public class GraphUndirectedWeightedAdjacencyList {

    private int numVertices;   // Total number of vertices
    private WEdge[] adjList;   // Array of linked lists (Adjacency List)

    // Constructor: initialize graph
    public GraphUndirectedWeightedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new WEdge[numVertices]; // Initially all heads are null
    }

    // Add multiple edges from a 2D array
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {

            int source = edges[i][0];       // Starting vertex
            int destination = edges[i][1];  // Ending vertex
            int weight = edges[i][2];       // Weight of the edge

            // For UNDIRECTED graph:
            // Add edge in BOTH directions
            addEdge(source, destination, weight);   // source → destination
            addEdge(destination, source, weight);   // destination → source
        }
    }

    // Helper method to add a single edge (used twice for undirected graph)
    public void addEdge(int source, int destination, int weight) {

        // Step 1: Create a new edge node
        WEdge newEdge = new WEdge(destination, weight);

        // Step 2: Link new edge to the beginning of the list
        // (Prepending ensures O(1) insertion)
        newEdge.next = adjList[source];

        // Step 3: Update head of the adjacency list
        adjList[source] = newEdge;
    }

    // Print the full adjacency list
    public void printList() {

        System.out.println("Adjacency List with Weights:");

        // Traverse all vertices
        for (int i = 0; i < numVertices; i++) {

            System.out.print(i + ": ");

            // Traverse linked list of vertex i
            WEdge current = adjList[i];

            while (current != null) {

                // Print (neighbor, weight)
                System.out.print("(" + current.destination + ", " + current.weight + ") ");

                current = current.next; // Move to next edge
            }

            System.out.println();
        }
    }

    // Print neighbors of a given vertex
    public void findNeighbors(int vertex) {

        System.out.print("\nNeighbors of vertex " + vertex + ": ");

        WEdge current = adjList[vertex];

        // Traverse all connected edges
        while (current != null) {

            // Print neighbor and weight
            System.out.print("(" + current.destination + ", " + current.weight + ")");

            // Add comma if not the last element
            if (current.next != null) {
                System.out.print(",");
            }

            current = current.next; // Move to next edge
        }

        System.out.println();
    }


    // Driver
    public static void main(String[] args) {
        int numVertices = 5;

        // Provide each undirected edge only once to avoid duplicates in the list
        int[][] edges = {
            {0, 1, 2}, {0, 3, 6},
            {1, 2, 3}, {1, 4, 5},
            {3, 4, 2},
            {4, 2, 1}
        };

        GraphUndirectedWeightedAdjacencyList graph =
            new GraphUndirectedWeightedAdjacencyList(numVertices);

        System.out.println("Before adding connections:");
        graph.printList();

        graph.addEdges(edges);

        System.out.println("\nAfter adding connections:");
        graph.printList();

        for (int v = 0; v < numVertices; v++) {
            graph.findNeighbors(v);
        }
    }
}
