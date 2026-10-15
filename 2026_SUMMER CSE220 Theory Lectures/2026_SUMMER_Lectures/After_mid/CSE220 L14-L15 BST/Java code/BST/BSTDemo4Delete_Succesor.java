public class BSTDemo4Delete_Succesor {

    public static TNode delete_with_successor(TNode root, int key) {
        if (root == null) {
            return root;  // Base case: Tree is empty or node not found
        }

        // Traverse to the left subtree if key is smaller
        if (key < root.val) {
            root.left = delete_with_successor(root.left, key);
        }

        // Traverse to the right subtree if key is larger
        else if (key > root.val) {
            root.right = delete_with_successor(root.right, key);
        }

        else {
            // ==== Case 1 | No subtree or children ====
            if (root.left == null && root.right == null) {
                return null;  // Simply delete the node
            }

            // ==== Case 2 | One subtree (one child) ====
            else if (root.left == null) {
                // Only right child exists
                root.right.parent = root.parent;  // Connect child to parent
                return root.right;
            }
            else if (root.right == null) {
                // Only left child exists
                root.left.parent = root.parent;  // Connect child to parent
                return root.left;
            }

            // ==== Case 3 | Two subtrees (two children) ====
            else {
                // Find in-order successor (leftmost node in right subtree)
                TNode succ = BSTDemo.getMin(root.right);
                root.val = succ.val;  // Replace value with successor's value
                // Delete the in-order successor node recursively
                root.right = delete_with_successor(root.right, succ.val);
            }
        }

        return root;
    }

    // Sample1
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
        root = delete_with_successor(root, 20);
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
        root = delete_with_successor(root, 30);
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        // Case 3: Delete node with two children (50)
        /*
                 50
                /  \
              40    70
             / \    / \
            N  N  60  80
        */
        System.out.println("=== Case 3: Delete Node with Two Children (70) ===");
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);
        System.out.println("\nAfter Deletion:");
        root = delete_with_successor(root, 70);
        BSTDemo.inorderTraversal(root);
        System.out.println();

        // Case 1: Delete leaf node (80)
        /*
                 50
                /  \
              40    80
             / \    / \
            N  N  60   N
        */
        System.out.println("=== Case 1: Delete Leaf Node (80) ===");
        root = reset_tree_sample1();
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);
        System.out.println("\nAfter Deletion:");
        root = delete_with_successor(root, 80);
        BSTDemo.inorderTraversal(root);

        /*
                 50
                /  \
              40    60
             / \    / \
            N  N  N   N
        */
        System.out.println("\n");

        root = reset_tree_sample2();

        System.out.println("=== Case: Delete Node with Two Children (33) ===");
        System.out.println("Before Deletion:");
        BSTDemo.inorderTraversal(root);

        System.out.println("\nAfter Deletion:");
        root = delete_with_successor(root, 33);
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        /*
        Successor of 33 = 34

        Tree After Deletion:
                      2
                     / \
                    1   34
                   /   /  \
                  0   25   40
                     /      \
                    11       36
                   / \
                  7  12
                       \
                        13
        */
    }
}