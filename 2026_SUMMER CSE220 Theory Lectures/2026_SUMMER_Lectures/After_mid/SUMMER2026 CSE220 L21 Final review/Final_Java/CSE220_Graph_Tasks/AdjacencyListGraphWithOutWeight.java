class AdjacencyListGraphWithOutWeight {
    EdgeWithoutW[] adjList;
    int numVertices;

    AdjacencyListGraphWithOutWeight(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new EdgeWithoutW[numVertices];
    }

    void addEdge(int u, int v) {
        adjList[u] = new EdgeWithoutW(u, v, adjList[u]); // u -> v
        adjList[v] = new EdgeWithoutW(v, u, adjList[v]); // v -> u
    }

    void displayGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            EdgeWithoutW current = adjList[i];
            while (current != null) {
                System.out.print("(" + current.source + ", " + current.destination + ") → ");
                current = current.next;
            }
            System.out.println("None");
        }
    }
}


