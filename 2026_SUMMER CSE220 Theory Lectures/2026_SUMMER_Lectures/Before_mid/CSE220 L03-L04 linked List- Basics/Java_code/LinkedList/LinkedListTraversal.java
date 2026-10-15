public class LinkedListTraversal {

    Node head;

    // Method 1: Traverse using temp != null
    public void traverseAll() {
        int cnt = 0;
        Node temp = head;
        System.out.println("Traversal (temp != null):");

        while (temp != null) { // visits all nodes
            System.out.print(temp.elem + " ");
            temp = temp.next;
            cnt = cnt + 1;
        }

        System.out.println("\nTotal loop run: " + cnt);
        System.out.println("Total comparison in while: " + (cnt + 1));
        System.out.println("Stopped at: " + temp);
        System.out.println("-------------------------------------");
    }

    // Method 2: Traverse using temp.next != null
    public void traverseUntilLast() {
        int cnt = 0;
        Node temp = head;
        System.out.println("Traversal (temp.next != null):");

        while (temp.next != null) { // stops at second last node
            System.out.print(temp.elem + " ");
            temp = temp.next;
            cnt = cnt + 1;
        }

        // After loop ends, temp is the last node
        System.out.println("\nTotal loop run: " + cnt);
        System.out.println("Total comparison in while: " + (cnt + 1));
        System.out.println("Stopped at last node: " + temp.elem);
        System.out.println("-------------------------------------");
    }

    // Method to create a linked list from an array
    public void createList(int[] arr) {
        if (arr.length == 0) {  // Check if the array is empty
            return;  // Return if the array is empty (no list to create)
        }
        
        head = new Node(arr[0]); // Create the head node
        Node tail = head; // Start with the head as the tail
        
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // Create a new node
            tail.next = newNode; // Attach the new node to the tail
            tail = newNode; // Move the tail to the new node
        }
    }

    // Driver method
    public static void main(String[] args) {
        LinkedListTraversal list = new LinkedListTraversal();

        // Creating a linked list from an array
        int[] elements = {1, 2, 3};
        list.createList(elements);

        System.out.println("---------------Till Null------------");
        list.traverseAll();          // shows all nodes
        System.out.println("---------------Before Null (excluding null)------------");
        list.traverseUntilLast();    // stops before last node, prints last separately
    }
}
