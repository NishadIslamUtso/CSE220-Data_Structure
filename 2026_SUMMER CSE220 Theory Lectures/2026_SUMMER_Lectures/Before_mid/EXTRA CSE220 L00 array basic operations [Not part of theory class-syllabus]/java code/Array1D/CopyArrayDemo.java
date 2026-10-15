public class CopyArrayDemo {
    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40};
        int[] copied1 = original;
        int[] copied2 = copyArray(original);

        // Print original array
        System.out.println("Original Array:");
        printArray(original);

        // Print copied array
        System.out.println("Copied Array:");
        printArray(copied1);

        // Check if both arrays point to the same object
        System.out.println("original identity (original): " + System.identityHashCode(original));
        System.out.println("copied identity (pass by reference): " + System.identityHashCode(copied1));
        System.out.println("copied identity (copied by values): " + System.identityHashCode(copied2));
    }

    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
