class Tree {
    Object[] tree;

    // Constructor
    public Tree(Object root, int length) {
        // Index 0 is unused; we use 1-based indexing
        tree = new Object[length];
        tree[1] = root;  // Root at index 1
    }

    // Method to set left or right child
    public void setChild(int parentIndex, String side, Object child) {
        int childIndex;
        if (side.equals("left")) {
            childIndex = parentIndex * 2;
            tree[childIndex] = child;
        } else if (side.equals("right")) {
            childIndex = parentIndex * 2 + 1;
            tree[childIndex] = child;
        }
    }

    // Method to print the tree array
    public void printTreeArray() {
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                System.out.print(tree[i] + " ");
            } else {
                System.out.print("- ");
            }
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        Tree tree = new Tree(11, 8);  // Tree of length 8 to hold 7 nodes

        /*
                    11
                 /      \
               22        33
              /  \      /    \
            44   55   66     77
        */

        tree.setChild(1, "left", 22);
        tree.setChild(1, "right", 33);
        tree.setChild(2, "left", 44);
        tree.setChild(2, "right", 55);
        tree.setChild(3, "left", 66);
        tree.setChild(3, "right", 77);

        tree.printTreeArray();  // Output the tree array
    }
}
