public class GraphUndirectedWeightedMatrix {

    private int numVertices;    // Total number of vertices
    private int[][] adjMatrix;  // 2D matrix to store edge weights

    // Constructor: initialize graph
    public GraphUndirectedWeightedMatrix(int numVertices) {
        this.numVertices = numVertices;

        // Create a V x V matrix
        // Initially all values are 0 (means no edge)
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add multiple edges with weights (UNDIRECTED)
    public void addEdges(int[][] edges) {

        // edges format: { {source, destination, weight}, ... }
        for (int i = 0; i < edges.length; i++) {

            int source = edges[i][0];        // one vertex
            int destination = edges[i][1];   // other vertex
            int weight = edges[i][2];        // weight of the edge

            // For UNDIRECTED graph:
            // Store weight in BOTH directions
            adjMatrix[source][destination] = weight;   // source → destination
            adjMatrix[destination][source] = weight;   // destination → source
        }
    }

    // Print the adjacency matrix
    public void printMatrix() {

        System.out.println("Adjacency Matrix:");

        // Traverse rows
        for (int i = 0; i < numVertices; i++) {

            // Traverse columns
            for (int j = 0; j < numVertices; j++) {

                // Print weight (0 means no edge)
                System.out.print(adjMatrix[i][j] + " ");
            }

            System.out.println(); // New line after each row
        }
    }

    // Print neighbors of a given vertex
    public void findNeighbors(int vertex) {

        System.out.print("\nNeighbors of vertex " + vertex + ": ");

        // Traverse row = vertex
        for (int i = 0; i < numVertices; i++) {

            // If weight is non-zero → edge exists
            if (adjMatrix[vertex][i] != 0) {

                // Print neighbor (connected vertex)
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1, 2}, // Edge between 0 and 1 with weight 2
            {0, 2, 3}, // Edge between 0 and 2 with weight 3
            {1, 3, 4}, // Edge between 1 and 3 with weight 4
            {1, 4, 5}, // Edge between 1 and 4 with weight 5
            {2, 3, 6}  // Edge between 2 and 3 with weight 6
        };

        GraphUndirectedWeightedMatrix graph = new GraphUndirectedWeightedMatrix(numVertices);

        System.out.println("Before putting connections:");
        graph.printMatrix();

        System.out.println("\nAfter putting connections:");
        graph.addEdges(edges);
        graph.printMatrix();

        for (int i = 0; i < numVertices; i++) {
            graph.findNeighbors(i);
        }
    }
}
