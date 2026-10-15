public class BSTDemo2 {

    // Method to convert a sorted array to a balanced BST using recursion
    public static TNode sortedArrayToBSTRecur(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }

        // Find the middle element
        int mid = (right + left) / 2;

        // Create the root node
        TNode root = new TNode(arr[mid]);

        // Recursively create the left and right subtrees
        root.left = sortedArrayToBSTRecur(arr, left, mid - 1);
        root.right = sortedArrayToBSTRecur(arr, mid + 1, right);

        return root;
    }

    // In-order Traversal (Left, Root, Right)
    public static void inorderTraversal(TNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 11, 12, 14, 15, 18, 19, 21, 23, 25, 27, 28, 30, 32, 37};
        
        // Create a balanced BST from the sorted array
        TNode root = sortedArrayToBSTRecur(arr, 0, arr.length - 1);

        // Perform an in-order traversal
        inorderTraversal(root);
    }
}
