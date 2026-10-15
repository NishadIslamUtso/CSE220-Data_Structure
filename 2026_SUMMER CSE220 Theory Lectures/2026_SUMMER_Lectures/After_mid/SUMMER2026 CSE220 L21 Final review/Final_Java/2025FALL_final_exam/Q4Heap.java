public class Q4Heap {

    /**
     * scanMaxInGroup(numbers, k)
     * Returns an array containing the maximum of each consecutive group of size k
     * Must use MaxHeap and only insert() / extractMax()
     */
    static int[] scanMaxInGroup(int[] numbers, int k) {
    
        // Handle invalid cases: empty array or invalid window size
        if (numbers == null || k <= 0 || k > numbers.length) {
            return new int[0];
        }
    
        int n = numbers.length;
    
        // Result array to store maximum of each group (only integer array allowed)
        int[] result = new int[n - k + 1];
    
        // Slide the window from index 0 to (n - k)
        for (int start = 0; start <= n - k; start++) {
    
            // Create a MaxHeap for the current group of size k
            MaxHeap heap = new MaxHeap(k);
    
            // Insert k consecutive elements into the heap
            for (int i = start; i < start + k; i++) {
                heap.insert(numbers[i]);
            }
    
            // Extract and store the maximum element of the current group
            result[start] = heap.extractMax();
        }
    
        // Return array containing the maximum of each group
        return result;
    }

    // ==============================
    // DRIVER METHOD
    // ==============================
    public static void main(String[] args) {

        int[] numbers1 = {1, 3, -1, -3, 5, 3, 6};
        int k1 = 3;
        int[] result1 = scanMaxInGroup(numbers1, k1);

        System.out.print("Input: [1, 3, -1, -3, 5, 3, 6], k = 3\nOutput: ");
        printArray(result1);   // Expected: [3, 3, 5, 5, 6]

        System.out.println();

        int[] numbers2 = {2, 1, 5, 3, 4, 6};
        int k2 = 4;
        int[] result2 = scanMaxInGroup(numbers2, k2);

        System.out.print("Input: [2, 1, 5, 3, 4, 6], k = 4\nOutput: ");
        printArray(result2);   // Expected: [5, 5, 6]
    }

    // Helper method to print arrays
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}