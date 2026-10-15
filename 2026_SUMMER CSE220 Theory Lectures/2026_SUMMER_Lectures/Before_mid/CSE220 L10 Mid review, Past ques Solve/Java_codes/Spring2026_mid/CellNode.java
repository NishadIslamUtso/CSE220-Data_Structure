class CellNode {
    int val;
    int pulse_radius;
    CellNode next;
    CellNode prev;

    CellNode(int val, int radius) {
        this.val = val;
        this.pulse_radius = radius;
        this.next = null;
        this.prev = null;
    }
}