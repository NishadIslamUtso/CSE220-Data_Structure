// DHDLLL class definition
class DHDLLL {
    Node head;  // Dummy head node--should be kept private

    // Constructor to initialize the list with a dummy head node
    public DHDLLL() {
        this.head = new Node(-1); // Dummy head node with a placeholder value
    }

    // Method to create a doubly linked list from an array
    public Node createDoublyLinearLL(int[] arr) {
        Node currentNode = this.head;
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            currentNode.next = newNode;
            newNode.prev = currentNode;
            currentNode = newNode;
        }
        return this.head; // Return the head of the newly created linked list
    }

    // Method to print the linked list in the forward direction
    public void printForward() {
        System.out.print("Forward Printing: ");
        Node currentNode = this.head.next; // Start from the first real element
        while (currentNode != null) {
            System.out.print(currentNode.elem + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("END");
    }
    
    public Node getTail(Node head) {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    // Method to print the linked list in the backward direction
    public void printBackward() {
        System.out.print("Backward Printing: ");
        Node currentNode = this.head;

        Node tempTail = getTail(head);

        // Now traverse backwards
        while (tempTail.prev != null) {
            System.out.print(tempTail.elem + " <- ");
            tempTail = tempTail.prev;
        }
        System.out.println("HEAD");
    }

    // Method to get the size of the list
    public int getSize() {
        if (this.head.next == null) {
            return 0;  // If the list is empty
        }

        Node currentNode = this.head.next;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    // Method to get the node at a specific index
    public Node getNode(int idx) {
        Node currentNode = this.head.next;  // Start from the first real element
        int count = 0;
        while (currentNode != null) {
            if (count == idx) {
                return currentNode;  // Return the node at the given index
            }
            count++;
            currentNode = currentNode.next;
        }
        return null;  // Return null if index is out of bounds
    }

    // Method to insert a value at a specific index
    public Node insertAt(int givenVal, int idx) {
        int size = this.getSize();
        if (idx < 0 || idx > size) {
            System.out.println("Wrong Index. Insertion Failed!");
            return null;
        }

        Node newNode = new Node(givenVal);

        // Special case for inserting at the beginning (head as predecessor)
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

        // Connecting rest of links
        predecessor.next = newNode;
        if (successor != null) {
            successor.prev = newNode;
        }
        return newNode;
    }

    // Method to remove a node at a specific index
    public void removeAt(int idx) {
        int size = this.getSize();
        if (idx < 0 || idx >= size) {
            System.out.println("Wrong Index. Deletion Failed!");
            return;
        }

        Node remNode = this.getNode(idx);
        Node predecessor = remNode.prev;
        Node successor = remNode.next;

        // Connecting the rest of the links
        predecessor.next = successor;
        if (successor != null) {
            successor.prev = predecessor;
        }

        // Removing the connections of remNode
        remNode.next = remNode.prev = null;
    }
}
