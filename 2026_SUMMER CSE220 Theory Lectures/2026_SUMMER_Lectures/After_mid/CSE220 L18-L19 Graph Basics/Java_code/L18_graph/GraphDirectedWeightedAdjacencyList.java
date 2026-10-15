public class GraphDirectedWeightedAdjacencyList {

    private int numVertices;     // Total number of vertices in the graph
    private WEdge[] adjList;     // Array of linked lists (Adjacency List)

    // Constructor: initialize graph with given number of vertices
    public GraphDirectedWeightedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new WEdge[numVertices]; // Initially all entries are null
    }

    // Add multiple edges from a 2D array
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];       // Starting vertex
            int destination = edges[i][1];  // Ending vertex
            int weight = edges[i][2];       // Weight of the edge
            
            // For DIRECTED graph:
            // Add edge in only 1 direction
            addEdge(source, destination, weight); // Add edge to graph
        }
    }

    // Add a single directed weighted edge
    public void addEdge(int source, int destination, int weight) {

        // Step 1: Create a new edge node
        WEdge newEdge = new WEdge(destination, weight);

        // Step 2: Link new edge to the beginning of the list
        // (prepend for O(1) insertion)
        newEdge.next = adjList[source];

        // Step 3: Update head of the list for this source vertex
        adjList[source] = newEdge;
    }

    // Print the full adjacency list
    public void printList() {
        System.out.println("Adjacency List with Weights:");

        // Traverse each vertex
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");

            // Traverse linked list of edges for vertex i
            WEdge current = adjList[i];
            while (current != null) {

                // Print (destination, weight)
                System.out.print("(" + current.destination + ", " + current.weight + ") ");

                current = current.next; // Move to next edge
            }
            System.out.println();
        }
    }

    // Print neighbors of a specific vertex
    public void findNeighbors(int vertex) {

        System.out.print("\nNeighbors of vertex " + vertex + ": ");

        WEdge current = adjList[vertex];

        // Traverse all edges from this vertex
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


    // Driver code
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1, 2}, {0, 3, 6},
            {1, 2, 3}, {1, 4, 5},
            {3, 1, 4}, {3, 4, 2},
            {4, 2, 1}
        };

        GraphDirectedWeightedAdjacencyList graph = new GraphDirectedWeightedAdjacencyList(numVertices);

        System.out.println("Before adding connections:");
        graph.printList();

        graph.addEdges(edges);

        System.out.println("\nAfter adding connections:");
        graph.printList();

        for (int vertex = 0; vertex < numVertices; vertex++) {
            graph.findNeighbors(vertex);
        }
    }
}