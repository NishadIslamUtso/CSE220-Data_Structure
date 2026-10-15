public class BSTDemo4Delete {

    // Delete using in-order successor
    public static TNode deleteWithSuccessor(TNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteWithSuccessor(root.left, key);
        } else if (key > root.val) {
            root.right = deleteWithSuccessor(root.right, key);
        } else {
            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            else if (root.left == null) {
                root.right.parent = root.parent;
                return root.right;
            } else if (root.right == null) {
                root.left.parent = root.parent;
                return root.left;
            }

            // Case 3: Two children
            else {
                TNode succ = BSTDemo.getMin(root.right);
                root.val = succ.val;
                root.right = deleteWithSuccessor(root.right, succ.val);
            }
        }
        return root;
    }
    
    public static TNode deleteWithPredecessor(TNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteWithPredecessor(root.left, key);
        } else if (key > root.val) {
            root.right = deleteWithPredecessor(root.right, key);
        } else {
            // Case 1: No children
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                root.right.parent = root.parent;
                return root.right;
            } else if (root.right == null) {
                root.left.parent = root.parent;
                return root.left;
            }

            // Case 3: Two children
            TNode pred = BSTDemo.getMax(root.left);
            root.val = pred.val;
            root.left = deleteWithPredecessor(root.left, pred.val);
        }

        return root;
    }

        // Reset tree helper
    public static TNode resetTree() {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        TNode root = null;
        for (int val : values) {
            root = BSTDemo.insert(root, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TNode root;
        System.out.println("==========Delete with succesor==============");

        // Case 1: Delete leaf node (20)
        System.out.println("=== Case 1: Delete Leaf Node (20) ===");
        root = resetTree();
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root);
        root = deleteWithSuccessor(root, 20);
        System.out.print("\nAfter Deletion: ");
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        // Case 2: Delete node with one child (30)
        System.out.println("=== Case 2: Delete Node with One Child (30) ===");
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root);
        root = deleteWithSuccessor(root, 30);
        System.out.print("\nAfter Deletion: ");
        BSTDemo.inorderTraversal(root);
        System.out.println("\n");

        // Case 3: Delete node with two children (70)
        System.out.println("=== Case 3: Delete Node with Two Children (70) ===");
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root);
        root = deleteWithSuccessor(root, 70);
        System.out.print("\nAfter Deletion: ");
        BSTDemo.inorderTraversal(root);
        System.out.println();
        
        ////////////////////////////////////////////////////////////////////////////
        System.out.println("==========Delete with Predecessor==============");
        TNode root2 = resetTree();

        System.out.println("=== Case 1: Delete Leaf Node (20) ===");
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println();
        root2 = deleteWithPredecessor(root2, 20);
        System.out.print("After Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println("\n");

        System.out.println("=== Case 2: Delete Node with One Child (30) ===");
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println();
        root2 = deleteWithPredecessor(root2, 30);
        System.out.print("After Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println("\n");

        System.out.println("=== Case 3: Delete Node with Two Children (70) ===");
        root2 = resetTree();
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println();
        root2 = deleteWithPredecessor(root2, 70);
        System.out.print("After Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println("\n");

        System.out.println("=== Case 1: Delete Leaf Node (60) ===");
        System.out.print("Before Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println();
        root2 = deleteWithPredecessor(root2, 60);
        System.out.print("After Deletion: ");
        BSTDemo.inorderTraversal(root2);
        System.out.println();
    }
}
