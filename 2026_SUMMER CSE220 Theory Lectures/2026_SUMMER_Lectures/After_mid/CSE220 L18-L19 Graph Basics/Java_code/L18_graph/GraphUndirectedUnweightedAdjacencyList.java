public class GraphUndirectedUnweightedAdjacencyList {

    private int numVertices;   // Total number of vertices
    private Edge[] adjList;    // Array of linked lists (Adjacency List)

    // Constructor: initialize graph
    public GraphUndirectedUnweightedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;

        // Create an array of size = numVertices
        // Each index will store the head of a linked list
        adjList = new Edge[numVertices]; // Initially all values are null
    }

    // Add multiple edges to the graph
    public void addEdges(int[][] edges) {

        // edges format: { {source, destination}, ... }
        for (int i = 0; i < edges.length; i++) {

            int source = edges[i][0];        // Starting vertex
            int destination = edges[i][1];   // Ending vertex

            // For UNDIRECTED graph:
            // Add edge in BOTH directions
            addEdge(source, destination);      // source → destination
            addEdge(destination, source);      // destination → source
        }
    }

    // Helper method to add a single edge
    private void addEdge(int source, int destination) {

        // Step 1: Create a new edge node
        Edge newEdge = new Edge(destination);

        // Step 2: Insert at the beginning (prepend)
        // This ensures O(1) insertion time
        newEdge.next = adjList[source];

        // Step 3: Update head of the list
        adjList[source] = newEdge;
    }

    // Print the full adjacency list
    public void printList() {

        System.out.println("Adjacency List:");

        // Traverse each vertex
        for (int i = 0; i < numVertices; i++) {

            System.out.print(i + ": ");

            // Traverse linked list of edges for vertex i
            Edge current = adjList[i];

            while (current != null) {

                // Print neighbor (destination only, since unweighted)
                System.out.print(current.destination + " ");

                current = current.next; // Move to next edge
            }

            System.out.println();
        }
    }


    // Print neighbors of a given vertex
    public void findNeighbors(int vertex) {

        System.out.print("\nNeighbors of vertex " + vertex + ": ");

        Edge current = adjList[vertex];

        // Traverse all neighbors
        while (current != null) {

            // Print current neighbor
            System.out.print(current.destination);

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
            {0, 1},
            {0, 3},
            {1, 3},
            {1, 2},
            {1, 4},
            {2, 4},
            {3, 4}
        };

        GraphUndirectedUnweightedAdjacencyList graph = new GraphUndirectedUnweightedAdjacencyList(numVertices);

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