public class DHDLLLTester {

    public static void main(String[] args) {
        // Step 1: Create an instance of DHDLLL
        DHDLLL linkedList = new DHDLLL();

        // Step 2: Initialize the list with an array
        int[] arr = {10, 20, 30, 40};
        linkedList.createDoublyLinearLL(arr);

        // Step 3: Get the size of LL
        System.out.println("Size of the linked list: " + linkedList.getSize());  // Expected output: 4
        System.out.println();

        // Step 4: Try nodeAt()
        int indexToFind = 2;
        Node node2 = linkedList.getNode(indexToFind);
        if (node2 != null) {
            System.out.println("Node at index 2: " + node2.elem); // Expected output: 30
        } else {
            System.out.println("Node at index 2: None");
        }

        indexToFind = 4;
        Node node3 = linkedList.getNode(indexToFind);
        System.out.println("Node at index 4 (wrong index): " + node3);  // Expected output: null
        System.out.println();

        // Step 5: Print the original list
        System.out.println("Original List:");
        linkedList.printForward();
        linkedList.printBackward();

        // Step 6: Insert 15 at index 1
        System.out.println("\nInserting 15 at index 1:");
        linkedList.insertAt(15, 1);
        linkedList.printForward();

        // Step 7: Insert 5 at index 0
        System.out.println("\nInserting 5 at index 0:");
        linkedList.insertAt(5, 0);
        linkedList.printForward();

        // Step 8: Insert 45 at the end (index 6 after additions)
        System.out.println("\nInserting 45 at the end:");
        linkedList.insertAt(45, linkedList.getSize());
        linkedList.printForward();

        // Step 9: Remove node at index 3
        System.out.println("\nRemoving node at index 3:");
        linkedList.removeAt(3);
        linkedList.printForward();

        // Step 10: Remove node at index 0
        System.out.println("\nRemoving node at index 0:");
        linkedList.removeAt(0);
        linkedList.printForward();
        
        
   //////////////////////////////////////////////////////////////////
        System.out.println("Creating empty List:");
        // Step 1: Create an instance of DHDLLL
        DHDLLL linkedList2 = new DHDLLL();
        int[] arr1 = {};
        linkedList2.createDoublyLinearLL(arr1);

        // Step 2: Get the size of LL
        System.out.println("Size of the empty linked list: " + linkedList2.getSize());  // Expected output: 0
        System.out.println();


        // Step 3: Print the original list
        System.out.println("Original empty List:");
        linkedList2.printForward();
        linkedList2.printBackward();
        linkedList2.getTail(linkedList2.head);
    }
}
