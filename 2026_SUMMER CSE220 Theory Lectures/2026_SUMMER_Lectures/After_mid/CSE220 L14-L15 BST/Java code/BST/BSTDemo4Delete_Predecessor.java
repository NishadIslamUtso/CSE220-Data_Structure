public class BSTDemo4Delete_Predecessor {

    public static TNode delete_with_predecessor(TNode root, int key) {
        if (root == null) {
            return root;  // Base case: Tree is empty or node not found
        }

        // Traverse to the left subtree if key is smaller
        if (key < root.val) {
            root.left = delete_with_predecessor(root.left, key);
        }

        // Traverse to the right subtree if key is larger
        else if (key > root.val) {
            root.right = delete_with_predecessor(root.right, key);
        }

        else {
            // ==== Case 1 | No subtree or children ====
            if (root.left == null && root.right == null) {
                return null;  // Simply delete the node
            }

            // ==== Case 2 | One subtree (one child) ====
            else if (root.left == null) {
                root.right.parent = root.parent;
                return root.right;
            }
            else if (root.right == null) {
                root.left.parent = root.parent;
                return root.left;
            }

            // ==== Case 3 | Two subtrees (two children) ====
            else {
                // Find in-order predecessor (rightmost node in left subtree)
                TNode pred = BSTDemo.getMax(root.left);
                root.val = pred.val;  // Replace value with predecessor's value
                // Delete the in-order predecessor node recursively
                root.left = delete_with_predecessor(root.left, pred.val);
            }
        }

        return root;
    }

    // Ssample1

    // --- Reset Tree Helper ---
    public static TNode reset_tree_sample1() {
        /*
                 50
                /  \
              30    70
             / \    / \
            20  40  60  80
        */
        TNode root = null;
        int[] arr = {50, 30, 70, 20, 40, 60, 80};

        for (int i = 0; i < arr.length; i++) {
            root = BSTDemo.insert(root, arr[i]);
        }
        return root;
    }

    // Sample2

    // --- Reset Tree Helper ---
    public static TNode reset_tree_sample2() {
        /*
                  2
                 / \
                1   33
               /   /  \
              0   25   40
                 /    /
                11   34
               / \     \
              7  12     36
                   \
                    13
        */
        TNode root = null;
        int[] arr = {2, 1, 33, 0, 25, 40, 11, 34, 7, 12, 36, 13};

        for (int i = 0; i < arr.length; i++) {
            root = BSTDemo.insert(root, arr[i]);
        }

        return root;
    }

    public static void main(String[] args) {

        TNode root = reset_tree_sample1();

        // Case 1: Delete leaf node (20)
        System.out.println("=== Case 1: Delete Leaf Node (20) ===");
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);
        System.out.println("\nAfter Deletion:");
        root = delete_with_predecessor(root, 20);
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        // Case 2: Delete node with one child (30)
        System.out.println("=== Case 2: Delete Node with One Child (30) ===");
        /*
                 50
                /  \
              30    70
             / \    / \
            N  40  60  80
        */
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);
        System.out.println("\nAfter Deletion:");
        root = delete_with_predecessor(root, 30);
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        // Case 3: Delete node with two children (70)
        System.out.println("=== Case 3: Delete Node with Two Children (70) ===");
        /*
                 50
                /  \
              40    70
             / \    / \
            N  N0  60  80
        */
        root = reset_tree_sample1();
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);
        System.out.println("\nAfter Deletion:");
        root = delete_with_predecessor(root, 70);
        BSTDemo.inorderTraversal(root);
        System.out.println();

        /*
                 50
                /  \
              40    60
             / \    / \
            N  N0  N  80
        */
        System.out.println("=== Case 1: Delete Leaf Node (60) ===");
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);
        System.out.println("\nAfter Deletion:");
        root = delete_with_predecessor(root, 60);
        BSTDemo.inorderTraversal(root);
        /*
                 50
                /  \
              40    80
             / \    / \
            N  N0  N   N
        */
        System.out.println("\n");

        root = reset_tree_sample2();

        System.out.println("=== Case: Delete Node with Two Children (2) ===");
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);

        System.out.println("\nAfter Deletion:");
        root = delete_with_predecessor(root, 2);
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        /*
        Predecessor of 2 = 1

        Tree After Deletion:
                      1
                     / \
                    0   33
                       /  \
                      25   40
                     /    /
                    11   34
                   / \     \
                  7  12     36
                       \
                        13
        */
    }
}