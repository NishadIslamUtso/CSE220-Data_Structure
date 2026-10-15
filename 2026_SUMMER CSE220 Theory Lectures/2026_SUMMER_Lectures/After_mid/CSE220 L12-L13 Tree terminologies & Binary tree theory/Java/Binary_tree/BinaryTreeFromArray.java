public class BinaryTreeFromArray {

    // Function to build the tree from array
    public static TNode arrToTree(String[] arr, int i) {
        if (i >= arr.length || arr[i] == null) {
            return null;
        }

        TNode root = new TNode(arr[i]);
        root.left = arrToTree(arr, 2 * i);
        root.right = arrToTree(arr, 2 * i + 1);
        return root;
    }

    // PreOrder Traversal (Root, Left, Right)
    public static void printPreOrder(TNode root) {
        if (root == null){ 
            return ;
        }
        else {
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    // InOrder Traversal (Left, Root, Right)
    public static void printInOrder(TNode root) {
        if (root == null){ 
            return ;
        }
        else {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }

    // PostOrder Traversal (Left, Right, Root)
    public static void printPostOrder(TNode root) {
        if (root == null){ 
            return ;
        }
        else {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        // 0     1    2    3    4    5    6    7    8    9     10    11   12    13   14   15
        // [null, "A", "B", "C", "D", "E", "F", "G", "H", null, null, null, "I", "J", null, "K"]
        String[] treeArr = {
            null, "A", "B", "C", "D", "E", "F", "G",
            "H", null, null, null, "I", "J", null, "K"
        };

        TNode root = arrToTree(treeArr, 1);

        System.out.print("PreOrder Traversal: ");
        printPreOrder(root);
        System.out.println();

        System.out.print("InOrder Traversal: ");
        printInOrder(root);
        System.out.println();

        System.out.print("PostOrder Traversal: ");
        printPostOrder(root);
        System.out.println();
    }
}
