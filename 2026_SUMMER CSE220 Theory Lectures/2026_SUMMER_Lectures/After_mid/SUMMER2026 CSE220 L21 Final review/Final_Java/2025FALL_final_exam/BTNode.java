// ============================================================
// Node of Binary Tree
// ============================================================
class BTNode {
    int elem;
    BTNode left;
    BTNode right;

    BTNode(int elem, BTNode left, BTNode right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    BTNode(int elem) {
        this(elem, null, null);
    }
}