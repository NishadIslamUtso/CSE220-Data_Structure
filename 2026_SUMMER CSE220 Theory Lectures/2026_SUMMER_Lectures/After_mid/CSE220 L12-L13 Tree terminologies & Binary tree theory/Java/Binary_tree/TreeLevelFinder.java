public class TreeLevelFinder {

    // Build the tree from an array
    public static TPNode arrToTree(String[] arr, int i, TPNode parent) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }

        TPNode node = new TPNode(arr[i], parent);
        node.left = arrToTree(arr, 2 * i, node);
        node.right = arrToTree(arr, 2 * i + 1, node);

        return node;
    }

    // Recursively find the node with the given value
    public static TPNode findNode(TPNode root, String target) {
        if (root == null) return null;
        if (root.val.equals(target)) return root;

        TPNode left = findNode(root.left, target);
        if (left != null) return left;

        return findNode(root.right, target);
    }

    // Recursively compute the level using parent pointers
    public static int getLevelWithParent(TPNode node) {
        if (node == null) return -1;
        if (node.parent == null) return 0;
        return 1 + getLevelWithParent(node.parent);
    }

    // ---------------- Driver Code ----------------
    public static void main(String[] args) {
        // Index 0 is unused (like Python's [None, "A", ...])
        String[] treeArr = {
            null, "A", "B", "C", "D", "E", "F", "G",
            "H", null, null, null, "I", "J", null, "K"
        };

        TPNode root = arrToTree(treeArr, 1, null);

        String[] testVals = {"A", "F", "H", "K", "G", "P"};
        for (String val : testVals) {
            TPNode node = findNode(root, val);
            int level = getLevelWithParent(node);
            System.out.println("Level of '" + val + "': " + level);
        }
    }
}