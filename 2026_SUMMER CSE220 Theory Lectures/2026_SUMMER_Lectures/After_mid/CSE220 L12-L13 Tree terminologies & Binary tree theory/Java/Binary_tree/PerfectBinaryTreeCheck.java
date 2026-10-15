public class PerfectBinaryTreeCheck {

    // Get depth/level of the tree
    public static int getLevel(TNode node, int level) {
        if (node == null) {
            return level;
        }

        int leftLevel = getLevel(node.left, level + 1);
        int rightLevel = getLevel(node.right, level + 1);
        return Math.max(leftLevel, rightLevel);
    }

    // Check if the tree is a perfect binary tree
    public static boolean isPerfectTree(TNode root, int level) {
        if (root == null) {
            return true;
        }

        // If it's a leaf node
        if (root.left == null && root.right == null) {
            return true;
        }

        // If it's an internal node with one child missing
        if (root.left == null || root.right == null) {
            return false;
        }

        // Recursively check left and right subtrees and compare their levels
        return isPerfectTree(root.left, level + 1) &&
               isPerfectTree(root.right, level + 1) &&
               (getLevel(root.left, level) == getLevel(root.right, level));//Checking if the current level are same
               
    }

    public static void main(String[] args) {
        // Test case 1 - Perfect Tree
        String[] treeArr1 = {null, "A", "B", "C", "D", "E", "F", "G"};
        /*
                A
               / \
              B   C
             / \ / \
            D  E F  G
        */
        TNode root1 = BinaryTreeFromArray.arrToTree(treeArr1, 1);
        if (isPerfectTree(root1, 0)) {
            System.out.println("The tree is a perfect binary tree.");
        } else {
            System.out.println("The tree is not a perfect binary tree.");
        }

        // Test case 2 - Not Perfect
        String[] treeArr2 = {null, "A", "B", "C", "D", "E", null, null};
        /*
                A
               / \
              B   C
             / \
            D   E
        */
        TNode root2 = BinaryTreeFromArray.arrToTree(treeArr2, 1);
        if (isPerfectTree(root2, 0)) {
            System.out.println("The tree is a perfect binary tree.");
        } else {
            System.out.println("The tree is not a perfect binary tree.");
        }
    }
}
