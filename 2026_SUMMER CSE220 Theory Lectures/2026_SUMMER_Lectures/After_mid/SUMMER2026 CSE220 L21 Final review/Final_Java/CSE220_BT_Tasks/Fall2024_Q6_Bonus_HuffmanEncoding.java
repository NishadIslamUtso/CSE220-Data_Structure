public class Fall2024_Q6_Bonus_HuffmanEncoding {

    // find_encoding
    static String find_encoding(TNode_Char node, char target, String path) {
        if (node == null) {
            return null;
        }

        // Leaf node: check match
        if (node.left == null && node.right == null) {
            if (node.elem == target) {
                return path;
            } else {
                return null;
            }
        }

        // Search left with '0'
        String result = find_encoding(node.left, target, path + "0");
        if (result != null) {
            return result;
        }

        // Search right with '1'
        return find_encoding(node.right, target, path + "1");
    }

    // getEncoding
    static String getEncoding(TNode_Char root, String text) {
        String encoded_text = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String code = find_encoding(root, ch, "");
            encoded_text += code; // Assuming char exists in tree
        }
        return encoded_text;
    }

    public static void main(String[] args) {
        // Build Huffman Tree
        TNode_Char root = new TNode_Char('\0'); // Internal node
        root.left = new TNode_Char('a'); // 'a' -> 0
        root.right = new TNode_Char('\0'); // Internal node

        root.right.left = new TNode_Char('\0');
        root.right.left.left = new TNode_Char('b'); // 'b' -> 100
        root.right.left.right = new TNode_Char('n'); // 'n' -> 101

        root.right.right = new TNode_Char('\0');
        root.right.right.left = new TNode_Char('d'); // 'd' -> 110
        root.right.right.right = new TNode_Char('e'); // 'e' -> 111

        // Example usage
        String text1 = "and";
        System.out.println(getEncoding(root, text1)); // Expected: "0101110"

        String text2 = "bad";
        System.out.println(getEncoding(root, text2)); // Expected: "1000110"
    }
}
