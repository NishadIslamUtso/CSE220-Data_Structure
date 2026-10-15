public class BSTDemo3 {

    // Function to create a tree from an array representation
    public static TNode arrToTree(Integer[] arr, int i, TNode parent) {
        // Base case: Check if index is out of bounds or the current element is null
        if (i >= arr.length || arr[i] == null) {
            return null;
        }

        // Recursive case:
        // 1. Create a node for the current index, set its parent
        TNode root = new TNode(arr[i]);
        root.parent = parent;

        // 2. Set the left child by recursively calling for index 2 * i
        root.left = arrToTree(arr, 2 * i, root);

        // 3. Set the right child by recursively calling for index 2 * i + 1
        root.right = arrToTree(arr, 2 * i + 1, root);

        return root;
    }

    // Find the in-order successor of a given node in a binary tree
    public static TNode inOrderSuccessor(TNode root, TNode x) {
        // Case 1 - Right subtree of x exists
        if (x.right != null) {
            // Successor is the leftmost node of the right subtree
            return BSTDemo.getMin(x.right);
        }

        // Case 2 - Right subtree of x doesn't exist
        // Move up the tree as the node is a left child
        TNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }

        return y; // Case 3 - If x is parent's left child, then parent is the successor
    }

    // Find the in-order predecessor of a given node in a binary tree
    public static TNode inOrderPredecessor(TNode root, TNode x) {
        // Case 1 - Left subtree of x exists
        if (x.left != null) {
            // Predecessor is the rightmost node of the left subtree
            return BSTDemo.getMax(x.left);
        }

        // Case 2 - Left subtree of x doesn't exist
        // Move up the tree as long as the node is a left child
        TNode y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = y.parent;
        }

        return y; // Case 3 - If x is parent's right child, then parent is the predecessor
    }


    public static void main(String[] args) {
        // Manually creating the tree
        TNode root = new TNode(50);
        root.left = new TNode(17);
        root.right = new TNode(72);

        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new TNode(12);
        root.left.right = new TNode(23);
        root.right.left = new TNode(54);
        root.right.right = new TNode(76);

        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        root.left.left.left = new TNode(9);
        root.left.left.right = new TNode(14);
        root.left.right.left = new TNode(19);

        root.left.left.left.parent = root.left.left;
        root.left.left.right.parent = root.left.left;
        root.left.right.left.parent = root.left.right;

        root.left.right.left.left = new TNode(18);
        root.left.right.left.left.parent = root.left.right.left;

        root.right.left.right = new TNode(67);
        root.right.left.right.parent = root.right.left;

        // Performing in-order traversal
        System.out.print("Inorder Traversal (Manually Created Tree)   : ");
        BSTDemo.inorderTraversal(root);
        System.out.println();

        // Creating tree using recursive code
        Integer[] treeArr = {null, 50, 17, 72, 12, 23, 54, 76, 9, 14, 19, null, null, 67, null, null, null, null, null, null, 18, null};
        //             0    1   2   3   4   5   6   7  8   9  10   11   12    13   14    15    16    17   18     19
        TNode root2 = arrToTree(treeArr, 1, null);
        System.out.print("Inorder Traversal (using recursive function): ");
        BSTDemo.inorderTraversal(root2);
        System.out.println();

        // Inorder successor and predecessor
        System.out.println("Inorder successor of 17 is " + inOrderSuccessor(root, root.left).val);
        System.out.println("Inorder successor of 23 is " + inOrderSuccessor(root, root.left.right).val);
        System.out.println("Inorder successor of 19 is " + inOrderSuccessor(root, root.left.right.left).val);
        TNode successor = inOrderSuccessor(root, root.right.right);
        if (successor != null) {
            System.out.println("Inorder successor of 76 is " + successor.val);
        } else {
            System.out.println("Inorder successor of 76 is None");
        }
        System.out.println("-".repeat(50));

        System.out.println("Inorder predecessor of 17 is " + inOrderPredecessor(root, root.left).val);
        System.out.println("Inorder predecessor of 23 is " + inOrderPredecessor(root, root.left.right).val);
        System.out.println("Inorder predecessor of 19 is " + inOrderPredecessor(root, root.left.right.left).val);
        TNode predecessor = inOrderPredecessor(root, root.right.right);
        if (predecessor != null) {
            System.out.println("Inorder predecessor of 76 is " + predecessor.val);
        } else {
            System.out.println("Inorder predecessor of 76 is None");
        }
        System.out.println("-".repeat(50));
    }
}
