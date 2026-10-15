public class GetNodeLevel {

    // Get level of node with a given value
    public static int getLevel(TNode root, String value, int level) {
        if (root == null) {
            return -1;
        }

        if (root.val.equals(value)) {
            return level;
        }

        int leftLevel = getLevel(root.left, value, level + 1);
        int rightLevel = getLevel(root.right, value, level + 1);

        if (leftLevel == -1 && rightLevel == -1) {
            return -1;
        }

        return Math.max(leftLevel, rightLevel);
    }

    public static void main(String[] args) {
        // Tree array with 1-based indexing
        String[] treeArr = {
            null, "A", "B", "C", "D", "E", "F", "G",
            "H", null, null, null, "I", "J", null, "K"
        };

        TNode root = BinaryTreeFromArray.arrToTree(treeArr, 1);    

        System.out.println("\n---------------------------------");
        System.out.println("Level of 'A': " + getLevel(root, "A", 0));
        System.out.println("Level of 'F': " + getLevel(root, "F", 0));
        System.out.println("Level of 'H': " + getLevel(root, "H", 0));
        System.out.println("Level of 'K': " + getLevel(root, "K", 0));
        System.out.println("Level of 'P': " + getLevel(root, "P", 0));  // not in tree
    }
}
