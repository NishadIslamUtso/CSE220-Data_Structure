public class ArrayCreationExamples {
    public static void main(String[] args) {
        int arrayLength = 5;

        // Created using 0's (default for int arrays)
        int[] arr0 = new int[arrayLength];
        printArray(arr0);

        // Created using nulls (Object array)
        String[] arr1 = new String[arrayLength];  // default is null
        printArray(arr1);

        // Created using 11's
        int[] arr2 = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arr2[i] = 11;
        }
        printArray(arr2);

        // Created with 0.0's (default for double arrays)
        double[] arr3 = new double[arrayLength];
        printArray(arr3);

        // Created using given values (inline initialization)
        int[] arr4 = {11, 22, 40};
        printArray(arr4);

        // Created using new with initialization
        Integer[] arr5 = new Integer[]{1, 2, 3};
        printArray(arr5);
    }

    // Overloaded methods to print different types of arrays using regular for loops
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
