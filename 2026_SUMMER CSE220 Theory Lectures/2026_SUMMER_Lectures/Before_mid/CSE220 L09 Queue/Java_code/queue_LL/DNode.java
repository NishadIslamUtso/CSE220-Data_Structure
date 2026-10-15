class DNode {
    int elem;
    DNode next;
    DNode prev;

    // Initializes a node with the given element, next, and previous pointers.
    public DNode(int elem, DNode next, DNode prev) {
        this.elem = elem;
        this.next = next;
        this.prev = prev;
    }

    public DNode(int elem) {
        this(elem, null, null);
    }
}