class Edge {

    int toVertex;
    int weight;
    Edge next;

    Edge(int toVertex, int weight) {
        this.toVertex = toVertex;
        this.weight = weight;
        this.next = null;
    }
}