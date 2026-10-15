// ================= Node Class (String-based) =================
class StringNode {
    String data;      // Stored expression part
    StringNode next;  // Pointer to next node

    // Constructor
    public StringNode(String data) {
        this.data = data;
        this.next = null;
    }
}