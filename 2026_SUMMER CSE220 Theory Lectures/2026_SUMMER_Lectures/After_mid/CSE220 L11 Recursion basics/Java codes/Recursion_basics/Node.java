class Node {
    int elem;
    Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public Node(int elem) {
        this.elem = elem;
        this.next = null;
    }
}