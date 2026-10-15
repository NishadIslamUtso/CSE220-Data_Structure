public class BubbleSortExample {

    // Bubble sort method
    public static int[] bubbleSort(int[] arr) {
        // Traverse through all array elements
        for (int i = 0; i < arr.length; i++) { // iteration
            // Last i elements are already in place
            for (int j = 0; j < arr.length - i - 1; j++) { // comparison
                // Swap if the element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // Tester method
    public static void main(String[] args) {
        int[] exampleList = {17, 3, 9, 21, 2};
        

        System.out.print("Original list: ");
        for (int val : exampleList) {
            System.out.print(val + " ");
        }
        
        int[] sortedList = bubbleSort(exampleList);
        
        System.out.println();
        
        System.out.print("Sorted list: ");
        for (int val : sortedList) {
            System.out.print(val + " ");
        }
    }
}
