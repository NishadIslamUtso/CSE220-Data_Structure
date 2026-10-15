public class Summer2025_Q3_Escape {

    static String walk(NodeInt node, int[] seq, int i) {

        if (node == null) { // Base case: null node → no match
            return "LOST";
        }

        // Mismatch (sequence finished or element mismatch)
        if (i >= seq.length || node.elem != seq[i]) {
            return "LOST";
        }

        // If last index of sequence
        if (i == seq.length - 1) {

            // If this node is a leaf → ESCAPED
            if (node.left == null && node.right == null) {
                return "ESCAPED";
            }

            // Otherwise partial match → TRAPPED
            return "TRAPPED";
        }

        // Continue recursion on left
        String leftRes = walk(node.left, seq, i + 1);
        if (leftRes.equals("ESCAPED")) return "ESCAPED";

        // Continue recursion on right
        String rightRes = walk(node.right, seq, i + 1);
        if (rightRes.equals("ESCAPED")) return "ESCAPED";

        // If a TRAPPED occurred
        if (leftRes.equals("TRAPPED") || rightRes.equals("TRAPPED")) {
            return "TRAPPED";
        }

        // No match
        return "LOST";
    }

 
    static String findPath(NodeInt root, int[] seq) {
        return walk(root, seq, 0);
    }

    public static void main(String[] args) {

        // ---------- Build the tree ----------
        //
        //                1
        //              /   \
        //             0     1
        //            / \   / \
        //           1   0 0   1
        //          / \     / \
        //         1   0   1   0
        //

        NodeInt root = new NodeInt(1);

        root.left = new NodeInt(0);
        root.right = new NodeInt(1);

        root.left.left = new NodeInt(1);
        root.left.right = new NodeInt(0);

        root.left.left.left = new NodeInt(1);
        root.left.left.right = new NodeInt(0);

        root.right.left = new NodeInt(0);
        root.right.right = new NodeInt(1);

        root.right.left.left = new NodeInt(1);
        root.right.left.right = new NodeInt(0);

        // ---------- Test Cases ----------
        int[][] testSeqs = {
            {1, 0, 1, 1},   // ESCAPED
            {1, 1, 0},      // TRAPPED
            {1, 0, 0, 1}    // LOST
        };

        String[] expected = {"ESCAPED", "TRAPPED", "LOST"};
        String[] notes = {
            "Matches 1→0→1→1 (root to leaf)",
            "Matches part of a path but stops early",
            "No such path"
        };

        // ---------- Run Tests ----------
        for (int t = 0; t < testSeqs.length; t++) {
            int[] seq = testSeqs[t];
            String result = findPath(root, seq);

            // Print input
            System.out.print("Input seq = [");
            for (int i = 0; i < seq.length; i++) {
                System.out.print(seq[i]);
                if (i < seq.length - 1) System.out.print(", ");
            }
            System.out.println("]");

            // Print results
            System.out.println("s = findPath(root, seq) -> " + result);
            System.out.println("Expected: " + expected[t]);
            System.out.println("Explanation: " + notes[t] + "\n");
        }
    }
}
