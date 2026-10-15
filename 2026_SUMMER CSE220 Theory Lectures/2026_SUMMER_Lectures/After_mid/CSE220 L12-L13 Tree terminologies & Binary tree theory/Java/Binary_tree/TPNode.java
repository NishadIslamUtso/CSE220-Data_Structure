class TPNode {
    String val;
    TPNode left;
    TPNode right;
    TPNode parent;

    TPNode(String val, TPNode parent) {
        this.val = val;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
}