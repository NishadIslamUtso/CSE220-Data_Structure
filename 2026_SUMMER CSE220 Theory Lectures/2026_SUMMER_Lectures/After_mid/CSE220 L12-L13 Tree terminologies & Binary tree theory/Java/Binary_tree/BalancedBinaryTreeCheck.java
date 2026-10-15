public class BalancedBinaryTreeCheck {

    // Get height difference (df) of left and right subtree
    public static int getDf(TNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = TreeHeight.getHeight(node.left);
        int rightHeight = TreeHeight.getHeight(node.right);

        return Math.abs(leftHeight - rightHeight);
    }

    // Check if the tree is height-balanced
    public static boolean isBalanced(TNode root) {
        if (root == null) {
            return true;
        }

        int df = getDf(root);
        if (df > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        // Balanced Tree
        String[] treeArrBalanced = {null, "A", "B", "C", "D", "E", "F", "G"};
        /*
                A
               / \
              B   C
             / \ / \
            D  E F  G
        */
        TNode root2 = BinaryTreeFromArray.arrToTree(treeArrBalanced, 1);
        if (isBalanced(root2)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }

        // Unbalanced Tree
        String[] treeArrUnbalanced = {null, "A", "B", null, "C", "D", null, null, "E"};
        /*
                A
               /
              B
             / \
            C   D
           /
          E
        */
        TNode root3 = BinaryTreeFromArray.arrToTree(treeArrUnbalanced, 1);
        if (isBalanced(root3)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
