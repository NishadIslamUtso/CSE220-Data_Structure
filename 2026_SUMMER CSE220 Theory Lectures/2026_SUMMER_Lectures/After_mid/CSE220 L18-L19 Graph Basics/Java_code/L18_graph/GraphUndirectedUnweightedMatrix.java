public class GraphUndirectedUnweightedMatrix {

    private int numVertices;    // Total number of vertices
    private int[][] adjMatrix;  // 2D matrix to store edges

    // Constructor: initialize graph
    public GraphUndirectedUnweightedMatrix(int numVertices) {
        this.numVertices = numVertices;

        // Create a V x V matrix
        // Initially all values are 0 (no edges)
        adjMatrix = new int[numVertices][numVertices];
    }

    // Method to add edges (UNDIRECTED)
    public void addEdges(int[][] edges) {

        // edges format: { {source, destination}, ... }
        for (int i = 0; i < edges.length; i++) {

            int source = edges[i][0];        // one vertex
            int destination = edges[i][1];   // other vertex

            // For UNDIRECTED graph:
            // Add edge in BOTH directions
            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1;
        }
    }

    // Method to print adjacency matrix
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

    // Method to find and print neighbors of a given vertex
    public void findNeighbors(int vertex) {

        System.out.print("\nNeighbors of vertex " + vertex + ": ");

        // Traverse row = vertex
        for (int i = 0; i < numVertices; i++) {

            // If there is an edge vertex — i
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
        int[][] edges1 = {
            {0, 1}, {0, 2},
            {1, 3}, {1, 4},
            {2, 3}
        };

        GraphUndirectedUnweightedMatrix graph1 = new GraphUndirectedUnweightedMatrix(numVertices);
        System.out.println("Before putting connections:");
        graph1.printMatrix();

        graph1.addEdges(edges1);
        System.out.println("\nAfter putting connections:");
        graph1.printMatrix();

        for (int i = 0; i < numVertices; i++) {
            graph1.findNeighbors(i);
        }

        System.out.println("\n---\n");

        int[][] edges2 = {
            {0, 1}, {0, 3},
            {1, 3}, {1, 2}, {1, 4},
            {2, 4},
            {3, 4}
        };

        GraphUndirectedUnweightedMatrix graph2 = new GraphUndirectedUnweightedMatrix(numVertices);
        System.out.println("Before putting connections:");
        graph2.printMatrix();

        graph2.addEdges(edges2);
        System.out.println("\nAfter putting connections:");
        graph2.printMatrix();

        for (int i = 0; i < numVertices; i++) {
            graph2.findNeighbors(i);
        }
    }
}
