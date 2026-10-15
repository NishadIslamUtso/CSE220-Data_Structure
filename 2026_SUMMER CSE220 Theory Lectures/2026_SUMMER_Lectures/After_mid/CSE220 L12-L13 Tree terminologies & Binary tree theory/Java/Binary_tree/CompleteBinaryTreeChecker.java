public class CompleteBinaryTreeChecker {

    // Check if binary tree is complete
    public static boolean isComplete(TNode node, int index, int totalNodes) {
        if (node == null)
            return true;
        if (index > totalNodes)
            return false;
        return isComplete(node.left, 2 * index, totalNodes) &&
               isComplete(node.right, 2 * index + 1, totalNodes);
    }

    public static void main(String[] args) {
        // Tree 1: Complete Binary Tree
        //       "A"
        //      /   \
        //    "B"   "C"
        //    /
        //  "F"

        TNode tree1 = new TNode("A");
        tree1.left = new TNode("B");
        tree1.right = new TNode("C");
        tree1.left.left = new TNode("F");

        // Tree 2: Not Complete Binary Tree
        //       "A"
        //      /   \
        //    "B"   "C"
        //    / \     \
        //  "F" "D"   "E"

        TNode tree2 = new TNode("A");
        tree2.left = new TNode("B");
        tree2.right = new TNode("C");
        tree2.left.left = new TNode("F");
        tree2.left.right = new TNode("D");
        tree2.right.right = new TNode("E");

        // Check Tree 1
        int nodes1 = TreeHeight.getSize(tree1);
        System.out.println("Tree 1 is complete: " + isComplete(tree1, 1, nodes1)); // Expected: true

        // Check Tree 2
        int nodes2 = TreeHeight.getSize(tree2);
        System.out.println("Tree 2 is complete: " + isComplete(tree2, 1, nodes2)); // Expected: false
    }
}