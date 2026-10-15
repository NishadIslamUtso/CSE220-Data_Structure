class AdjacencyListGraph {
    WEdge[] adjList;         // heads of adjacency lists
    int numVertices;

    AdjacencyListGraph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new WEdge[numVertices];
    }

    void addEdge(int u, int v, int weight) {
        // Directed edge u -> v
        WEdge newEdge = new WEdge(u, v, weight, adjList[u]);
        adjList[u] = newEdge;
    }

    void displayGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            WEdge current = adjList[i];
            while (current != null) {
                System.out.print("(" + current.source + " -> " + current.destination + ", w=" + current.weight + ") → ");
                current = current.next;
            }
            System.out.println("None");
        }
    }
}
