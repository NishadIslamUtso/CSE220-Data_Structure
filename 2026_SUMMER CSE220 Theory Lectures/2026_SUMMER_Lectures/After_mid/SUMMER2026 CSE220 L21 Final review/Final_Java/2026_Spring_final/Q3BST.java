public class Q3BST {

    // ================= Approach 1 =================
    // Iterative BST Search Using Array Index
    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    static void searchBSTArrIterative(int[] arr, int target) {

        int i = 1;
        // Start from root index

        int n = arr.length - 1;
        // Since index 0 is unused

        while (i <= n) {

            System.out.print(arr[i]);
            // Print current checked node

            if (arr[i] == target) {
                // Target found

                System.out.println();
                return;
            }

            else if (target < arr[i]) {
                // Go to left child

                System.out.print(", ");

                i = 2 * i;
            }

            else {
                // Go to right child

                System.out.print(", ");

                i = 2 * i + 1;
            }
        }

        System.out.println("Not_Found");
        // Invalid index reached
    }


    // ================= Approach 2 =================
    // Recursive BST Search Using Array Index
    // Time Complexity: O(log n)
    // Space Complexity: O(log n)

    static void searchBSTArrRecursive(int[] arr, int target) {

        int n = arr.length - 1;

        recursiveSearch(arr, target, 1, n);
    }

    static void recursiveSearch(int[] arr, int target, int i, int n) {

        if (i > n) {

            System.out.println("Not_Found");

            return;
        }

        System.out.print(arr[i]);
        // Print current node

        if (arr[i] == target) {

            System.out.println();

            return;
        }

        else if (target < arr[i]) {

            System.out.print(", ");

            recursiveSearch(arr, target, 2 * i, n);
        }

        else {

            System.out.print(", ");

            recursiveSearch(arr, target, 2 * i + 1, n);
        }
    }


    // ================= Main Driver =================

    public static void main(String[] args) {

        // Using 1-based indexing
        int[] arr = {0, 41, 20, 65, 11, 29, 50, 91};

        System.out.println("====== Approach 1: Iterative ======");

        System.out.println("\nTarget = 50");
        searchBSTArrIterative(arr, 50);

        System.out.println("\nTarget = 30");
        searchBSTArrIterative(arr, 30);


        System.out.println("\n==================================");


        System.out.println("\n====== Approach 2: Recursive ======");

        System.out.println("\nTarget = 50");
        searchBSTArrRecursive(arr, 50);

        System.out.println("\nTarget = 30");
        searchBSTArrRecursive(arr, 30);
    }
}