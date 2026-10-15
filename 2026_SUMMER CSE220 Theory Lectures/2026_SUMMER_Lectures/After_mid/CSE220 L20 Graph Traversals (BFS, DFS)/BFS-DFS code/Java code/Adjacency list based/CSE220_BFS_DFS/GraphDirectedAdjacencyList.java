public class GraphDirectedAdjacencyList {
    private int numVertices;
    private Edge[] adjList;

    // Constructor
    public GraphDirectedAdjacencyList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new Edge[numVertices]; // Initialize adjacency list
    }

    // Method to add directed edges
    public void addEdges(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            addEdge(source, destination);
        }
    }

    // Helper method to add a directed edge from source to destination
    private void addEdge(int source, int destination) {
        Edge newEdge = new Edge(source, destination, adjList[source]);
        adjList[source] = newEdge;
    }

    // Method to print the adjacency list
    public void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            Edge current = adjList[i];
            while (current != null) {
                System.out.print(current.destination + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Method to find and print neighbors of a given vertex
    public void findNeighbors(int vertex) {
        System.out.print("\nNeighbors of vertex " + vertex + ": ");
        Edge current = adjList[vertex];
        boolean first = true;
        while (current != null) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(current.destination);
            first = false;
            current = current.next;
        }
        System.out.println();
    }
    
    public int getNumVertices() {
        return numVertices;
    }
    
    public Edge[] getAdjList() {
        return adjList;
    }

}
