public class Q2_OuterInnerSum {
    // ============================================================
    // ========================== STYLE 1 ==========================
    // - Uses separate helper functions to calculate:
    //   total sum, leaf sum, left outer boundary sum, right outer boundary sum
    // - Then computes:
    //   exterior = root + outer boundaries + leaf nodes
    //   interior = total - exterior
    // ============================================================

    static void outerInnerSum_style1(BTNode root) {
        if (root == null) {
            System.out.println("Exterior: 0");
            System.out.println("Interior: 0");
            return;
        }

        int totalSum = calculateTotalSum(root);
        int leafSum = calculateLeafSum(root);

        // outer layer = left boundary (excluding leaves) + right boundary (excluding leaves)
        int outerLayer = calculateLeftOuterLayer(root.left) + calculateRightOuterLayer(root.right);

        int exteriorSum = root.elem + outerLayer + leafSum;
        int interiorSum = totalSum - exteriorSum;

        System.out.println("Exterior: " + exteriorSum);
        System.out.println("Interior: " + interiorSum);
    }



    // Sum of all nodes
    static int calculateTotalSum(BTNode node) {
        if (node == null) {
            return 0;
        }
        return node.elem + calculateTotalSum(node.left) + calculateTotalSum(node.right);
    }


    // Sum of all leaf nodes
    static int calculateLeafSum(BTNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.elem;
        }
        return calculateLeafSum(node.left) + calculateLeafSum(node.right);
    }


    // Sum of left outer boundary excluding leaves (follow left pointers)
    static int calculateLeftOuterLayer(BTNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;  // exclude leaf
        }
        return node.elem + calculateLeftOuterLayer(node.left);
    }


    // Sum of right outer boundary excluding leaves (follow right pointers)
    static int calculateRightOuterLayer(BTNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 0;  // exclude leaf
        }
        return node.elem + calculateRightOuterLayer(node.right);
    }


    // ============================================================
    // ========================== STYLE 2 ==========================
    // - Uses iterative traversal for left and right outer boundaries
    // - Uses one recursive helper sumTree() for:
    //   (a) summing only leaves
    //   (b) summing all nodes
    // - Then computes:
    //   interior = total - exterior
    // ============================================================

    static void outerInnerSum_style2(BTNode root) {
        if (root == null) {
            System.out.println("Exterior: 0");
            System.out.println("Interior: 0");
            return;
        }

        int exteriorSum = 0;

        // Outer left border (excluding leaf): root -> left -> left -> ...
        BTNode r = root;
        while (r.left != null) {          // stops at parent of leftmost leaf
            exteriorSum += r.elem;        // add current boundary node
            r = r.left;                   // move down left side
        }

        // Outer right border (excluding leaf): root.right -> right -> right -> ...
        r = root.right;
        while (r != null && r.right != null) {
            exteriorSum += r.elem;        // add current boundary node
            r = r.right;                  // move down right side
        }

        // Add all leaf nodes
        exteriorSum += sumTree(root, true);

        System.out.println("Exterior: " + exteriorSum);

        // Interior = total sum − exterior sum
        int totalSum = sumTree(root, false);
        int interiorSum = totalSum - exteriorSum;

        System.out.println("Interior: " + interiorSum);
    }


    // leafOnly = True  → sum only leaves
    // leafOnly = False → sum all nodes
    static int sumTree(BTNode root, boolean leafOnly) {
        if (root == null) {
            return 0;
        }

        if (leafOnly) {
            if (root.left == null && root.right == null) {
                return root.elem;
            }
            return sumTree(root.left, true) + sumTree(root.right, true);
        } else {
            return root.elem + sumTree(root.left, false) + sumTree(root.right, false);
        }
    }


    // ============================================================
    // ========================== STYLE 3 ==========================
    // - Uses one recursive helper() to classify every node directly as:
    //   exterior or interior
    // - Tracks both sums in one traversal using boundary flags
    // - Does not need separate total/leaf/boundary sum functions
    // ============================================================

    // Helper function to compute sums recursively
    static void helper(BTNode node, boolean isLeftBoundary, boolean isRightBoundary, int[] sums) {
        if (node == null) {
            return;
        }

        // A leaf has no children
        boolean isLeaf = (node.left == null && node.right == null);

        // Boundary or leaf → exterior
        if (isLeftBoundary || isRightBoundary || isLeaf) {
            sums[0] += node.elem;      // exterior sum
        } else {
            sums[1] += node.elem;      // interior sum
        }

        // Recurse to left child
        helper(node.left,
               isLeftBoundary,                    // left child stays left boundary
               isRightBoundary && node.right == null,
               sums);

        // Recurse to right child
        helper(node.right,
               isLeftBoundary && node.left == null,
               isRightBoundary,                   // right child stays right boundary
               sums);
    }


    static void outerInnerSum_style3(BTNode root) {
        // sums[0] → exterior sum, sums[1] → interior sum
        int[] sums = {0, 0};

        if (root == null) {
            System.out.println("Exterior: 0");
            System.out.println("Interior: 0");
            return;
        }

        // Start recursion from root
        helper(root, true, true, sums);

        System.out.println("Exterior: " + sums[0]);
        System.out.println("Interior: " + sums[1]);
    }


    // ============================================================
    // ================= DRIVER (ONE FOR ALL 3 STYLES) =================
    // ============================================================
    static BTNode buildPerfectTree(int i, int max_val) {
        if (i > max_val) {
            return null;
        }
        BTNode node = new BTNode(i);
        node.left = buildPerfectTree(2 * i, max_val);
        node.right = buildPerfectTree(2 * i + 1, max_val);
        return node;
    }


    public static void main(String[] args) {
        BTNode root = buildPerfectTree(1, 31);

        System.out.println("====== Style 1 ======");
        outerInnerSum_style1(root);

        System.out.println("====== Style 2 ======");
        outerInnerSum_style2(root);

        System.out.println("====== Style 3 ======");
        outerInnerSum_style3(root);
    }
}