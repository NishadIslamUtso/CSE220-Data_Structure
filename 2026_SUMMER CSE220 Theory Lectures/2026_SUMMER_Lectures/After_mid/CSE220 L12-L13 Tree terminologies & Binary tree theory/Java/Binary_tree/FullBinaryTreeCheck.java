public class FullBinaryTreeCheck {

    // Function to check if a binary tree is a full binary tree
    public static boolean isFullTree(TNode root) {
        // Base case: empty tree is full
        if (root == null) {
            return true;
        }

        // Leaf node is full
        if (root.left == null && root.right == null) {
            return true;
        }

        // Node has both children: check recursively
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }

        // Node has only one child: not full
        return false;
    }

    public static void main(String[] args) {
        // First test case
        String[] treeArr1 = {
            null, "A", "B", "C", "D", "E", "F", "G",
            "H", null, null, null, "I", "J", null, "K"
        };

        TNode root1 = BinaryTreeFromArray.arrToTree(treeArr1, 1); 
        if (isFullTree(root1)) {
            System.out.println("The tree is a full binary tree.");
        } else {
            System.out.println("The tree is not a full binary tree.");
        }

        // Second test case
        String[] treeArr2 = {
            null, "A", "B", "C", "D", "E", "F", "G"
        };

        TNode root2 = BinaryTreeFromArray.arrToTree(treeArr2, 1);
        if (isFullTree(root2)) {
            System.out.println("The tree is a full binary tree.");
        } else {
            System.out.println("The tree is not a full binary tree.");
        }
    }
}
