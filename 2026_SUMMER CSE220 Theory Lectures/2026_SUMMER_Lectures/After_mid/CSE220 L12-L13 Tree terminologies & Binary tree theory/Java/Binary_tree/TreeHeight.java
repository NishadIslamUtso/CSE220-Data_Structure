public class TreeHeight {

    // Get height of a node
    public static int getHeight(TNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    
        // Method to get the size of the tree
    public static int getSize(TNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }

    public static void main(String[] args) {
        // Tree array with 1-based indexing
        String[] treeArr = {
            null, "A", "B", "C", "D", "E", "F", "G",
            "H", null, null, null, "I", "J", null, "K"
        };

        TNode root = BinaryTreeFromArray.arrToTree(treeArr, 1); 

        System.out.println("----------------");
        System.out.println("Height of '" + root.val + "': " + getHeight(root));
        System.out.println("Height of '" + root.left.val + "': " + getHeight(root.left));
        System.out.println("Height of '" + root.right.left.val + "': " + getHeight(root.right.left));
        System.out.println("Height of '" + root.right.left.left.val + "': " + getHeight(root.right.left.left));
        
        // Get the size of the tree
        System.out.println("----------------");
        System.out.println("Size of the tree: " + getSize(root));
    }
}
