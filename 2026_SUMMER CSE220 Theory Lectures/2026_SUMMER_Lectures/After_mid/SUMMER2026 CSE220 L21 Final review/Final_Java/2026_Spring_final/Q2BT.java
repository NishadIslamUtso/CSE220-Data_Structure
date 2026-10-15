public class Q2BT {

    // ================= Approach 1 =================
    // Recursive Bottom-Up Processing
    // Time Complexity: Worst Case O(n^2)
    // Space Complexity: O(h)

    static int subtreeSum(BTNode node) {

        if (node == null) {
            return 0;
        }

        int leftSum = subtreeSum(node.left);
        int rightSum = subtreeSum(node.right);

        return node.elem + leftSum + rightSum;
    }

    static BTNode mutatingVirusApproach1(BTNode root) {

        if (root == null) {
            return null;
        }

        root.left = mutatingVirusApproach1(root.left);
        root.right = mutatingVirusApproach1(root.right);

        if (root.elem % 2 != 0) {

            // Two children → do nothing
            if (root.left != null && root.right != null) {
                return root;
            }

            // Only left child
            else if (root.left != null) {

                int sum = subtreeSum(root.left);

                root.elem = root.elem + sum;

                root.left = null;
            }

            // Only right child
            else if (root.right != null) {

                int sum = subtreeSum(root.right);

                root.elem = root.elem + sum;

                root.right = null;
            }
        }

        return root;
    }


    // ================= Approach 2 =================
    // Optimized Single Traversal
    // Time Complexity: O(n)
    // Space Complexity: O(h)

    static int virusHelper(BTNode node) {

        if (node == null) {
            return 0;
        }

        int leftSum = virusHelper(node.left);
        int rightSum = virusHelper(node.right);

        if (node.elem % 2 != 0) {

            // Only left child
            if (node.left != null && node.right == null) {

                node.elem = node.elem + leftSum;

                node.left = null;

                return node.elem;
            }

            // Only right child
            else if (node.right != null && node.left == null) {

                node.elem = node.elem + rightSum;

                node.right = null;

                return node.elem;
            }
        }

        return node.elem + leftSum + rightSum;
    }

    static BTNode mutatingVirusApproach2(BTNode root) {

        virusHelper(root);

        return root;
    }


    // ================= Driver Helpers =================

    static BTNode createSampleTree() {

        /*
                    10
                   /  \
                  5    23
                 /    /  \
                3    8   15
               / \         \
              1   2         25
        */

        BTNode root = new BTNode(10);

        root.left = new BTNode(5);
        root.right = new BTNode(23);

        root.left.left = new BTNode(3);

        root.left.left.left = new BTNode(1);
        root.left.left.right = new BTNode(2);

        root.right.left = new BTNode(8);

        root.right.right = new BTNode(15);

        root.right.right.right = new BTNode(25);

        return root;
    }


    static void printTree(BTNode root, String indent, boolean isRight) {

        if (root == null) {
            return;
        }

        printTree(root.right, indent + "        ", true);

        if (isRight) {
            System.out.println(indent + "R---- " + root.elem);
        } else {
            System.out.println(indent + "L---- " + root.elem);
        }

        printTree(root.left, indent + "        ", false);
    }


    // ================= Main Driver =================

    public static void main(String[] args) {

        // ---------- Original Tree ----------

        System.out.println("Original Tree:");

        BTNode original = createSampleTree();

        printTree(original, "", false);

        System.out.println("\n================================\n");


        // ---------- Approach 1 ----------

        System.out.println("Approach 1 Result:");

        BTNode root1 = createSampleTree();

        root1 = mutatingVirusApproach1(root1);

        printTree(root1, "", false);

        System.out.println("\n================================\n");


        // ---------- Approach 2 ----------

        System.out.println("Approach 2 Result:");

        BTNode root2 = createSampleTree();

        root2 = mutatingVirusApproach2(root2);

        printTree(root2, "", false);
    }
}