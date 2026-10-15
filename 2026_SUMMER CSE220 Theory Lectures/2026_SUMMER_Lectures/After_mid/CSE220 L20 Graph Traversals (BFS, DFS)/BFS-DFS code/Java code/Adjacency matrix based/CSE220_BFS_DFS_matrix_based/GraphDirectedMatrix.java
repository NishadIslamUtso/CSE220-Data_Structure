public class GraphDirectedMatrix {
    private int numVertices;
    private int[][] adjMatrix;

    // Constructor
    public GraphDirectedMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    // Method to add edges for a directed graph (using regular for loop)
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjMatrix[u][v] = 1; // Only mark u -> v, because it's directed
        }
    }

    // Method to print adjacency matrix
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to find and print neighbors of a given vertex
    public void findNeighbors(int vertex) {
        System.out.print("\nNeighbors of vertex " + vertex + ": ");
        boolean first = true;
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == 1) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();
    }
    
    // Method to get adjacency matrix
    public int[][] getAdjMatrix() {
        return adjMatrix;  // Return the adjacency matrix
    }

    // Method to get number of vertices
    public int getNumVertices() {
        return numVertices;
    }
}