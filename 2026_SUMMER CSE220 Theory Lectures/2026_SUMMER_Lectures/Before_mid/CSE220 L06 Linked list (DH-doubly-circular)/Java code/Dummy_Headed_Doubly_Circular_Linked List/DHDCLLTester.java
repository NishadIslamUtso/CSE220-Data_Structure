public class DHDCLLTester {
    public static void main(String[] args) {
        // Step 1: Create an instance of DHDCLL
        DHDCLL linkedList = new DHDCLL();

        // Step 2: Initialize the list with an array
        int[] arr = {10, 20, 30, 40};
        linkedList.createDoublyCircularLL_inPlace(arr);

        // Step 3: Get the size of the linked list
        System.out.println("Size of the linked list: " + linkedList.getSize());  // Expected output: 4
        System.out.println();

        // Step 4: Try getNode()
        int indexToFind = 2;
        Node node2 = linkedList.getNode(indexToFind);
        System.out.println("Node at index 2: " + (node2 != null ? node2.elem : "None"));  // Expected output: 30

        indexToFind = 4;
        Node node3 = linkedList.getNode(indexToFind);
        System.out.println("Node at index 4 (wrong index): " + (node3 != null ? node3.elem : "None"));  // Expected output: None
        System.out.println();

        // Step 5: Print the original list
        System.out.println("Original List:");
        linkedList.printLLForward();
        linkedList.printLLBackward();

        // Step 6: Insert 15 at index 1
        System.out.println("\nInserting 15 at index 1:");
        linkedList.insertAt(15, 1);
        linkedList.printLLForward();

        // Step 7: Insert 5 at index 0
        System.out.println("\nInserting 5 at index 0:");
        linkedList.insertAt(5, 0);
        linkedList.printLLForward();

        // Step 8: Insert 45 at the end (index 6 after additions)
        System.out.println("\nInserting 45 at the end:");
        linkedList.insertAt(45, linkedList.getSize());
        linkedList.printLLForward();

        // Step 9: Remove node at index 3
        System.out.println("\nRemoving node at index 3:");
        linkedList.removeAt(3);
        linkedList.printLLForward();

        // Step 10: Remove node at index 0
        System.out.println("\nRemoving node at index 0:");
        linkedList.removeAt(0);
        linkedList.printLLForward();
        
        System.out.println("\nReversing the linked list:");
        linkedList.reverseLL();
        linkedList.printLLForward();
        
        System.out.println("\nReversing the linked list-out of place:");
        linkedList.reverseLL_out_of_place();
        linkedList.printLLForward();        
    }
}
