public class Spring2025_Q3_SecondMaxInTree_typ2 {

    static Integer secondMax(NodeInt root) {
        Integer[] maxTwo = {null, null}; // [max_val, second_max_val]
        traverseAndUpdate(root, maxTwo);
        return maxTwo[1];
    }

    static void traverseAndUpdate(NodeInt node, Integer[] maxTwo) {
        if (node == null) return;

        int val = node.elem;
        
        // Update max and second max
        if (maxTwo[0] == null || val > maxTwo[0]) {
            maxTwo[1] = maxTwo[0];
            maxTwo[0] = val;
        } else if ((maxTwo[1] == null || val > maxTwo[1]) && (maxTwo[0] == null || val != maxTwo[0])) {
            maxTwo[1] = val;
        }

        // Recurse on left and right child
        traverseAndUpdate(node.left, maxTwo);
        traverseAndUpdate(node.right, maxTwo);
    }

    public static void main(String[] args) {
        // First test tree
        NodeInt root1 = new NodeInt(30);
        root1.left = new NodeInt(50);
        root1.right = new NodeInt(10);
        root1.right.left = new NodeInt(40);

        System.out.println("Second highest value: " + secondMax(root1)); // Output: 40

        // Second test tree
        NodeInt root2 = new NodeInt(70);
        root2.left = new NodeInt(60);
        root2.right = new NodeInt(90);
        root2.right.left = new NodeInt(80);
        root2.right.right = new NodeInt(100);

        System.out.println("Second highest value: " + secondMax(root2)); // Output: 90
    }
}
