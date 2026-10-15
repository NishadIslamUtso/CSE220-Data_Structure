class WEdge {
    int destination;
    int weight;
    WEdge next;

    public WEdge( int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
        this.next = null;
    }
}