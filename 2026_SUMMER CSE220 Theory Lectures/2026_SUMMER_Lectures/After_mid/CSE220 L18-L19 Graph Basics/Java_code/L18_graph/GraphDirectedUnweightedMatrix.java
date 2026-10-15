public class GraphDirectedUnweightedMatrix {

    private int numVertices;    // Total number of vertices
    private int[][] adjMatrix;  // 2D matrix to store edges

    // Constructor: initialize graph
    public GraphDirectedUnweightedMatrix(int numVertices) {
        this.numVertices = numVertices;

        // Create a V x V matrix
        // Initially all values are 0 (no edges)
        adjMatrix = new int[numVertices][numVertices];
    }

    // Add multiple edges (DIRECTED)
    public void addEdges(int[][] edges) {

        // edges format: { {source, destination}, ... }
        for (int i = 0; i < edges.length; i++) {

            int source = edges[i][0];        // starting vertex
            int destination = edges[i][1];   // ending vertex

            // For DIRECTED graph:
            // Mark only source → destination
            adjMatrix[source][destination] = 1;
        }
    }

    // Print the adjacency matrix
    public void printMatrix() {

        System.out.println("Adjacency Matrix:");

        // Traverse rows
        for (int i = 0; i < numVertices; i++) {

            // Traverse columns
            for (int j = 0; j < numVertices; j++) {

                // Print 0 or 1
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

            // If there is an edge vertex → i
            if (adjMatrix[vertex][i] == 1) {

                // Print neighbor
                System.out.print(i + "  ");
            }
        }

        System.out.println();
    }


    // Driver code
    public static void main(String[] args) {
        int numVertices = 5;
        int[][] edges = {
            {0, 1}, {0, 2},
            {1, 0}, {1, 2}, {1, 3},
            {2, 1},
            {3, 2}, {3, 4},
            {4, 0}, {4, 2}
        };

        GraphDirectedUnweightedMatrix graph = new GraphDirectedUnweightedMatrix(numVertices);

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
