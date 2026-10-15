public class BSTDemo {

    public static TNode insert(TNode root, int key) {
        TNode newNode = new TNode(key); //z

        // Find the parent node to attach the new node
        TNode parent = null;  // Tracks the parent node y
        TNode current = root;  // Start from the root x

        while (current != null) { // finding parent
            parent = current;
            if (key < current.val) {  // Go left
                current = current.left;
            } else if (key > current.val) {  // Go right
                current = current.right;
            }
        }

        // Set the parent of the new node
        newNode.parent = parent;

        // Attach the new node to the left or right of the parent
        if (parent == null) {  // If tree is empty, make newNode the root
            root = newNode;
        } else if (key < parent.val) {  // Attach newNode to the left of the parent
            parent.left = newNode;
        } else {  // Attach newNode to the right of the parent
            parent.right = newNode;
        }

        return root;
    }

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
    // In-order Traversal (Left, Root, Right)
    public static void inorderTraversal(TNode root) {
        /** Left → Root → Right */
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    // Pre-order Traversal (Root, Left, Right)
    public static void preorderTraversal(TNode root) {
        /** Root → Left → Right */
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Post-order Traversal (Left, Right, Root)
    public static void postorderTraversal(TNode root) {
        /** Left → Right → Root */
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    // Method to get the minimum node iteratively
    public static TNode getMin(TNode node) {
        TNode current = node;

        // loop down to find the leftmost leaf
        while (current != null && current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Recursive method to get the minimum node
    public static TNode getMinRecursive(TNode node) {
        // Two Base cases
        if (node == null) {  // in case called on an empty tree
            return null;
        }
        if (node.left == null) {  // no left subtree, minimum found
            return node;
        }

        // Recursive case
        return getMinRecursive(node.left);  // recursive call
    }

    // Method to get the maximum node iteratively
    public static TNode getMax(TNode node) {
        TNode current = node;

        // loop down to find the rightmost leaf
        while (current != null && current.right != null) {
            current = current.right;
        }

        return current;
    }

    // Recursive method to get the maximum node
    public static TNode getMaxRecursive(TNode node) {
        if (node == null) {  // in case called on an empty tree
            return null;
        }
        if (node.right == null) {  // no right subtree, maximum found
            return node;
        }

        return getMaxRecursive(node.right);  // recursive call
    }
    
        // Method to search the BST
    public static TNode searchBST(TNode root, int key) {
        if (root == null || root.val == key) {
            return root;
        }
        if (key < root.val) {
            return searchBST(root.left, key);
        } else {
            return searchBST(root.right, key);
        }
    }
    
        // Method to print node description
    public static void printNodeDetails(TNode node) {
        if (node == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
            System.out.println("Node Description: ");
            System.out.println("val: " + node.val + ", parent: " + (node.parent != null ? node.parent.val : "null"));
            if (node.left != null && node.right != null) {
                System.out.println("left: " + node.left.val + ", right: " + node.right.val);
            } else if (node.left != null) {
                System.out.println("left: " + node.left.val + ", right: null");
            } else if (node.right != null) {
                System.out.println("left: null, right: " + node.right.val);
            } else {
                System.out.println("left: null, right: null");
            }
        }
    }
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx
    // Driver Part
    public static void main(String[] args) {
        TNode root = null;  // Start with an empty BST
        int[] valuesToInsert = {20, 10, 30, 5, 15, 25, 35};

        // Tree structure after inserting values:
        //      20
        //    /    \
        //  10      30
        // /  \    /  \
        //5   15  25  35

        // Insert each value into the BST
        for (int value : valuesToInsert) {
            root = insert(root, value);
        }

        System.out.println("In-order Traversal:");
        inorderTraversal(root);  // Expected: 5 10 15 20 25 30 35
        System.out.println("\nPre-order Traversal:");
        preorderTraversal(root);  // Expected: 20 10 5 15 30 25 35
        System.out.println("\nPost-order Traversal:");
        postorderTraversal(root);  // Expected: 5 15 10 25 35 30 20
        System.out.println();

        // Get the minimum values
        System.out.println(getMin(root).val); // Expected: 5
        System.out.println(getMinRecursive(root).val); // Expected: 5
        System.out.println("-".repeat(50));

        // Driver for left-skewed tree
        root = null;  // Start with an empty BST
        valuesToInsert = new int[]{50, 40, 30, 20, 10};

        // Tree structure:
        //            50
        //           /
        //        40
        //       /
        //     30
        //    /
        //  20
        // /
        //10

        // Insert each value into the BST
        for (int value : valuesToInsert) {
            root = insert(root, value);
        }

        System.out.println(getMin(root).val); // Expected: 10
        System.out.println(getMinRecursive(root).val); // Expected: 10
        System.out.println("-".repeat(50));

        // Driver for right-skewed tree
        root = null;  // Start with an empty BST
        valuesToInsert = new int[]{10, 20, 30, 40, 50};

        // Tree structure:
        // 10
        //   \
        //   20
        //     \
        //     30
        //       \
        //       40
        //         \
        //         50

        // Insert each value into the BST
        for (int value : valuesToInsert) {
            root = insert(root, value);
        }

        System.out.println(getMin(root).val); // Expected: 10
        System.out.println(getMinRecursive(root).val); // Expected: 10
        System.out.println("-".repeat(50));

        // Get the maximum values
        System.out.println(getMax(root).val); // Expected: 50
        System.out.println(getMaxRecursive(root).val); // Expected: 50
        System.out.println("-".repeat(50));
        
        /////////////////////////////////////////////////////
        

        TNode root2 = null;  // Added root2 = null;
        int[] valuesToInsert2 = {21, 14, 28, 11, 18, 25, 32, 5, 12, 15, 19, 23, 27, 30, 37};

        // Regular loop to insert each value into the BST
        for (int i = 0; i < valuesToInsert2.length; i++) {
            root2 = insert(root2, valuesToInsert2[i]);
        }

        // Search for the node with value 27
        TNode result = searchBST(root2, 27);
        System.out.println("Search for 27:");
        printNodeDetails(result);
        System.out.println("-".repeat(50));

        // Search for the node with value 270 (not present)
        result = searchBST(root2, 270);
        System.out.println("Search for 270:");
        printNodeDetails(result);
        System.out.println("-".repeat(50));

        // Search for the node with value 18
        result = searchBST(root2, 18);
        System.out.println("Search for 18:");
        printNodeDetails(result);
        System.out.println("-".repeat(50));
    }
}
