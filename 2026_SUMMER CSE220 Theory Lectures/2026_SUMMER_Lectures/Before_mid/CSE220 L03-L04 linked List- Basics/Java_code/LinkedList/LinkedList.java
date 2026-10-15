public class LinkedList {
    public Node head;

    // Method to create a linked list from an array
    public void createList(int[] arr) {
        if (arr.length == 0) {  // Check if the array is empty
            return;  // Return if the array is empty (no list to create)
        }
        
        head = new Node(arr[0]); // Create the head node
        Node tail = head; // Start with the head as the tail
        
        for (int i = 1; i < arr.length; i++) {
            //--------------Append code--------------------
            Node newNode = new Node(arr[i]); // Create a new node
            tail.next = newNode; // Attach the new node to the tail
            tail = newNode; // Move the tail to the new node
            //--------------------------------------------
        }
    }

    // Method to print the linked list
    public void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.elem + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Method to get the size of the linked list
    public int get_size() {
        if (head == null) {  // If the list is empty, return 0
            return 0;
        }

        Node currentNode = head;  // Temporary variable to traverse the list
        int count = 0;

        while (currentNode != null) {  // While the current node is not null
            currentNode = currentNode.next;  // Move to the next node
            count++;  // Increment the count
        }

        return count;  // Return the total number of nodes
    }

    // Method to get the tail of the linked list
    public Node getTail() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    
    // Method to append a node to the linked list
    public void appendLL(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // If the list is empty
            head = newNode;
            return;
        }
        Node tail = getTail();
        tail.next = newNode;
        
    /*tail = newNode  # OR tail = tail.next
    # This change only affects the local variable 'tail' and will not be saved
    # outside this function. Therefore, if the updated tail needs to be used
    # elsewhere, we must return the new tail (or store it separately).
    # In this implementation, the tail can always be found by traversing
    # from the head using getTail(head), so returning the updated tail is not necessary.
    # However, we could return the new tail if desired.*/
    }

    // Method to prepend a node to the linked list
    public void prependLL(int elem) {
        // STEP 1: Create a new node
        Node newNode = new Node(elem);
    
        // STEP 2: Link the new node to the current head
        newNode.next = head;
    
        // Update the head to the new node.
        // Since head is an instance variable, updating it
        // directly modifies the original linked list.
        head = newNode;
    }
    
    
    // Method to find the index of a specific value
    public int indexOf(int target) {
        Node current_node = head;              // Start traversal from the head
        int index = 0;                         // Index of the current node
    
        while (current_node != null) {         // Traverse until the end of the list
            if (current_node.elem == target) { // Check if the target value is found
                return index;                  // Return the index of the target
            }
            current_node = current_node.next;  // Move to the next node
            index++;                           // Increment the index
        }
    
        return -1;                             // Target value not found
    }
    
    
    // Method to check if a node with a specific value exists
    public boolean contains(int target) {
        Node current_node = head;              // Start traversal from the head
    
        while (current_node != null) {         // Traverse until the end of the list
            if (current_node.elem == target) { // Check if the target value is found
                return true;                   // Target exists in the list
            }
            current_node = current_node.next;  // Move to the next node
        }
    
        return false;                          // Target value not found
    }



    // Method to get an element at a specific index
    // Return type is int because node elements are of type int
    public int getElem(int idx) {
        int current_index = 0;                     // Index of the current node
        Node current_node = head;                  // Start traversal from the head
    
        while (current_node != null) {             // Traverse until the end of the list
            if (current_index == idx) {            // Check if the desired index is reached
                return current_node.elem;          // Return the element at the given index
            }
            current_index++;                       // Move to the next index
            current_node = current_node.next;      // Move to the next node
        }
    
        return -1;                                 // Invalid index (element not found)
    }
    
    
    // Method to get a node at a specific index
    public Node getNode(int idx) {
        int current_index = 0;                     // Index of the current node
        Node current_node = head;                  // Start traversal from the head
    
        while (current_node != null) {             // Traverse until the end of the list
            if (current_index == idx) {            // Check if the desired index is reached
                return current_node;               // Return the node at the given index
            }
            current_index++;                       // Move to the next index
            current_node = current_node.next;      // Move to the next node
        }
    
        return null;                               // Invalid index (node not found)
    }
    
    // Method to set a node's element at a specific index (using getNode())
    public void setNode1(int index, int newElem) {
        Node current_node = getNode(index);            // Get the node at the given index
    
        if (current_node != null) {                    // Check if the index is valid
            current_node.elem = newElem;               // Update the node's element
            System.out.println("Successfully updated"); // Display success message
        } else {
            System.out.println("Invalid Index");       // Index is out of bounds
        }
    }
    
    // Method to set a node's element at a specific index (using first approach)
    // Updates the element at a given index by traversing the list
    public void setNode2(int index, int newElem) {
        Node currentNode = head; // Start from head
        int current_index = 0;   // Tracks current index
        boolean isUpdated = false; // Indicates whether update was successful
    
        while (currentNode != null) {
            if (current_index == index) { // Target index found
                currentNode.elem = newElem; // Update element
                isUpdated = true;
                break; // Stop searching
            }
    
            currentNode = currentNode.next; // Move to next node
            current_index++;
        }
    
        if (isUpdated) {
            System.out.println("Successfully updated");
        } else {
            System.out.println("Invalid Index");
        }
    }

    // Method to insert a node at a specific index
    public void insertAt(int idx, int elem) {
        int size = get_size();

        if (idx < 0 || idx > size) { // Invalid index
            System.out.println("Insertion Failed, Not valid index");
            return;
        } else if (idx == 0) {  // Insertion at head
            Node newNode = new Node(elem);
            newNode.next = head;
            head = newNode;
        } else { // Insertion in middle or end
            Node newNode = new Node(elem);
            Node predecessor = getNode(idx - 1);
            Node successor = predecessor.next;

            newNode.next = successor;
            predecessor.next = newNode;
        }
    }

    // Method to remove a node at a specific index
    public void removeAt(int idx) {
        int size = get_size();
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid Index");
            return;
        }

        // If removing the head node
        if (idx == 0) {
            head = head.next;
            return;
        }

        // Find the predecessor (node at idx-1)
        Node predecessor = getNode(idx - 1);
        Node remNode = predecessor.next;
        Node successor = remNode.next;

        // Link predecessor to successor, effectively removing remNode
        predecessor.next = successor;

        // Optional: Help garbage collector by clearing remNode's next
        remNode.next = null;
    }




    // Method to copy the linked list
    public Node copyList() {
        if (head == null) {  // If the list is empty, return null
            return null;
        }
    
        Node copy_head = new Node(head.elem);  // Create the head node of the copied list
        Node copy_tail = copy_head;            // Tail pointer for appending new nodes
    
        Node temp = head.next;  // Start from the second node of the original list
    
        while (temp != null) {  // Traverse the original list
            //-------Appened code-----------------
            Node newNode = new Node(temp.elem); // Create a new node with the current element
            copy_tail.next = newNode;           // Link it to the tail of the copied list
            copy_tail = newNode;                // Move the tail pointer forward
            //------------------------
            
            temp = temp.next;                   // Move to the next node in the original list
        }
    
        return copy_head;  // Return the head of the copied list
    }


    // Method to reverse the linked list out of place
    public Node reverseOutOfPlace() {
        if (head == null) {  // If the list is empty, return null
            return null;
        }

        Node revHead = new Node(head.elem);  // Create the new head for the reversed list
        Node temp = head.next;

        // Traverse the original list and add each element to the front of the reversed list
        while (temp != null) {
        //-------Prepend code-----------------    
            Node newNode = new Node(temp.elem);  // Create a new node with the current element
            newNode.next = revHead;  // Link the new node to the front of the reversed list
            revHead = newNode;  // Update the head of the reversed list
        //------------------------   
            temp = temp.next;  // Move to the next node in the original list
        }

        return revHead;  // Return the head of the reversed list
    }

    // Method to reverse the linked list in place
    public Node reverseInPlace() {
        Node prev = null;  // Previous node starts as null
        Node current = head;  // Current node starts as the head of the list

        while (current != null) {  // Traverse until the end of the list
            Node nextNode = current.next;  // Store the next node
            current.next = prev;  // Reverse the current node's link
            prev = current;  // Move prev forward
            current = nextNode;  // Move current forward
        }

        return prev;  // New head of the reversed list
    }

    
    
    // Method to rotate the linked list left
    public void rotateLeft() {
        if (head == null || head.next == null) {  // Check for empty or single-node list
            return;
        }

        Node oldHead = head; // Keep a copy of the original head to be the new tail
        head = head.next;    // Move head to the next node (new head)

        Node tail = getNode(get_size() - 1); // Find the last node in the list 
        // Node tail = getTail(); // Find the last node in the list
        tail.next = oldHead;    // Link the last node to the original head
        oldHead.next = null;    // Make the old head the new tail by setting next to null
    }
    
        // ----- Rotate Left by 1 -----
    // Moves the original head to the end: [10,20,30,40,50] -> [20,30,40,50,10]
    public void rotateLeft2() {
        // Check for empty or single-node list
        if (head == null || head.next == null) return;

        Node oldHead = head;    // keep original head; it will become the new tail
        head = head.next;       // new head is the second node

        // find current tail (starting from new head)
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // append old head at the end; make it the new tail
        tail.next = oldHead;
        oldHead.next = null;

    }

    
    // Method to rotate the linked list right
    public void rotateRight() {
        if (head == null || head.next == null) {  // Check for empty or single-node list
            return;
        }

        int size = get_size();
        Node newTail = getNode(size - 2); // Find the second-to-last node, which becomes the new tail
        Node oldTail = newTail.next;     // The last node, which will be the new head

        oldTail.next = head;     // Link the last node to the original head
        newTail.next = null;     // Set the new tail’s next to null
        head = oldTail;          // Update head to the old tail (new head)
    }
    
        // ----- Rotate Right by 1 -----
    // Moves the original tail to the front: [10,20,30,40,50] -> [50,10,20,30,40]
    public void rotateRight2() {
        // Check for empty or single-node list
        if (head == null || head.next == null) return;

        Node newTail = head;        // will stop at second-last node
        Node oldTail = head.next;   // will stop at last node
        while (oldTail.next != null) {
            newTail = newTail.next;
            oldTail = oldTail.next;
        }

        // Link last node to the current head
        oldTail.next = head;
        // Second-last becomes the new tail
        newTail.next = null;
        // Last node becomes the new head
        head = oldTail;
    }
    
    
    
    // Rotates the linked list left by k positions using rotateLeft()
    public void rotateLeftMul1(int k) {
        int size = get_size(); // Total number of nodes
        k = k % size;          // Avoid unnecessary full rotations
    
        if (head == null || k <= 0) return;
    
        for (int i = 0; i < k; i++) {
            rotateLeft(); // Rotate left by one position
        }
    }
    
    // Rotates the linked list right by k positions using rotateRight()
    public void rotateRightMul1(int k) {
        int size = get_size(); // Total number of nodes
        k = k % size;          // Avoid unnecessary full rotations
    
        if (head == null || k <= 0) return;
    
        for (int i = 0; i < k; i++) {
            rotateRight(); // Rotate right by one position
        }
    }
    
    // Method 3: rotateLeftMul2 — optimized version
    public void rotateLeftMul2(int k) {
        if (head == null || k <= 0) return;
    
        int size = get_size();
        k = k % size;
        if (k == 0) return;
    
        // Traverse to the (k-1)th node
        Node current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
    
        Node newHead = current.next;
        current.next = null;
    
        Node tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
    
        tail.next = head;
        head = newHead;
    }
    
    // Optimized right rotation by k positions using left rotation
    public void rotateRightMul2(int k) {
        if (head == null || k <= 0) return; // Invalid case
    
        int size = get_size(); // Total number of nodes
        k = k % size;          // Avoid unnecessary full rotations
    
        if (k == 0) return;    // No rotation needed
    
        rotateLeftMul2(size - k); // Right rotation = Left rotation by (size - k)
    }
    
    
}
