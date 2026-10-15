// ===== Doubly Headed Doubly Circular Linked List (with DUMMY head) =====
public class DHDCLL {
    private Node head; // dummy head

    public static Node createDoublyCircularLL(int[] arr) {
        // State 1 of the image above
        Node head = new Node(-1);  // Dummy head node
        Node tail = head; 

        for (int i = 0; i < arr.length; i++) {
            // ---- Code of append ----
            Node newNode = new Node(arr[i]);

            tail.next = newNode;  // Link current node to new node
            newNode.prev = tail;  // Link new node back to current node --- extra

            tail = newNode;       // tail = tail.next Move to the new node
            // ------------------------
        }

        // Making it circular by connecting the last node back to the head -- extra
        tail.next = head;
        head.prev = tail;

        return head;  // Returning the head of the newly created linked list
    }

    // Method to create the doubly circular linked list from an array (in-place)
    public void createDoublyCircularLL_inPlace(int[] arr) {
        this.head = createDoublyCircularLL(arr);
    }

    // Method to print the linked list in forward direction
    public void printLLForward() {
        System.out.print("Forward Printing: ");
        Node currentNode = head.next; // Start from the first real element
        if (currentNode == head) {
            System.out.println("(empty)");
            return;
        }
        while (currentNode != head) {
            System.out.print(currentNode.elem + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("HEAD");
    }

    // Method to print the linked list in backward direction
    public void printLLBackward() {
        System.out.print("Backward Printing: ");
        Node currentNode = head.prev; // Start from the last element
        if (currentNode == head) {
            System.out.println("(empty)");
            return;
        }
        while (currentNode != head) {
            System.out.print(currentNode.elem + " <- ");
            currentNode = currentNode.prev;
        }
        System.out.println("HEAD");
    }

    // Method to get the size of the list
    public int getSize() {
        int count = 0;
        Node currentNode = head.next;
        while (currentNode != head) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    // Method to get the node at a specific index
    public Node getNode(int idx) {
        Node currentNode = head.next;
        int count = 0;
        while (currentNode != head) {
            if (count == idx) {
                return currentNode;
            }
            count++;
            currentNode = currentNode.next;
        }
        return null;  // Return null if index is out of bounds
    }

    // Method to insert a value at a specific index
    public void insertAt(int givenVal, int idx) {
        int size = getSize();
        if (idx < 0 || idx > size) {
            System.out.println("Wrong Index. Insertion Failed!");
            return;
        }

        Node newNode = new Node(givenVal);
        Node predecessor;
        if (idx == 0) {
            predecessor = head;
        } else {
            predecessor = getNode(idx - 1);
        }

        Node successor = predecessor.next;

        // Establishing the connection of newNode
        newNode.next = successor;
        newNode.prev = predecessor;

        //Connecting rest of links
        predecessor.next = newNode;
        successor.prev = newNode;
    }

    // Method to remove a node at a specific index
    public void removeAt(int idx) {
        int size = getSize();
        if (idx < 0 || idx >= size) {
            System.out.println("Wrong Index. Deletion Failed!");
            return;
        }

        Node remNode = getNode(idx);
        Node predecessor = remNode.prev;
        Node successor = remNode.next;

        //Connecting rest of links
        predecessor.next = successor;
        successor.prev = predecessor;

        //Removing the connections of remNode
        remNode.next = remNode.prev = null;  // Isolate the removed node
    }

    // Method to reverse the list (in-place)
    public void reverseLL() {
        if (head.next == head) {
            System.out.println("List is empty. Nothing to reverse.");
            return;
        }

        Node current = head;
        do {
            Node temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.prev;
        } while (current != head);
        System.out.println("List reversed successfully.");
    }

    // Method to reverse the list (out-of-place)
    public void reverseLL_out_of_place() {
        if (head.next == head) {
            System.out.println("List is empty. Nothing to reverse.");
            return;
        }

        Node tempTail = head.prev; // Getting the tail

        Node revHead = new Node(-1);
        Node revTail = revHead;

        while (tempTail != head) {
            //----append after tail-------
            Node newNode = new Node(tempTail.elem);
            revTail.next = newNode;
            newNode.prev = revTail;
            revTail = newNode;
            //--------------
            tempTail = tempTail.prev;
        }

        // Making it circular
        revTail.next = revHead;
        revHead.prev = revTail;

        head = revHead;
        System.out.println("List reversed successfully.");
    }

}
