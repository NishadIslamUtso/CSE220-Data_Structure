public class QueueDHCLL {
    private DNode head; // Dummy head node
    private int size;   // Track the size of the queue

    // Initializes an empty queue with a dummy-headed doubly circular linked list.
    public QueueDHCLL() {
        head = new DNode(-1);             // Dummy head node
        head.next = head.prev = head;    // Points to itself (circular)
        size = 0;
    }

    // Returns true if the queue is empty, otherwise false.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }

    // Adds an element to the rear of the queue.
    public void enqueue(int elem) {
        // -------------append code()-----------------------------    
        DNode newNode = new DNode(elem);
        DNode predecessor = head.prev;     // The predecessor is the tail (current last node (rear))
        DNode successor = predecessor.next; // successor = head

        newNode.prev = predecessor;  // The new node's previous pointer points to the current last node (predecessor)
        newNode.next = successor;    // The new node's next pointer points to the head (successor)

        predecessor.next = newNode;  // The current last node (predecessor) points to the new node
        successor.prev = newNode;    // The dummy head (successor) points back to the new node
        // --------------------------------------------------------

        size++; // After adding the element, increment the queue size
    }

    // Removes and returns the element from the front of the queue.
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: Queue is empty");
        }

        // ---------removal at index=0 (Node after DH)------------------
        DNode predecessor = head;        // The predecessor of rem_node is always the head (dummy node)
        DNode remNode = head.next;       // This is the node to be removed
        DNode successor = remNode.next;  // Node after the node to be removed

        predecessor.next = successor;    // The head's next pointer now points to the successor node
        successor.prev = predecessor;    // The successor's previous pointer now points to the dummy head

        remNode.next = remNode.prev = null; // Set both next and prev pointers of the removed node to null
        // -------------------------------------------------------------

        size--; // After removing the element, decrease the size of the queue by 1
        return remNode.elem; // Return the element that was removed from the front of the queue
    }

    // Returns the element at the front of the queue without removing it.
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: Queue is empty");
        }
        return head.next.elem;
    }

    // Returns a string representation of the queue.
    //Optional---not needed for exam
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        String result = "[";
        DNode current = head.next;
        while (current != head) {
            result += current.elem + " ";
            current = current.next;
        }
        result = result.trim() + "]";
        return result;
    }

    // Converts the queue to an array and returns it.
    //Optional---not needed for exam
    public int[] toArray() {
        int[] arr = new int[size];
        DNode current = head.next;
        for (int i = 0; i < size; i++) {
            arr[i] = current.elem;
            current = current.next;
        }
        return arr;
    }

    // Searches for an element in the queue and returns its index, or -1 if not found.
    //Optional---not needed for exam
    public int search(int obj) {
        DNode current = head.next;
        int index = 0;
        while (current != head) {
            if (current.elem == obj) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1; // Not found
    }

    // Displays the queue from front to rear.
    //Optional---not needed for exam
    public void displayQueue() {
        DNode current = head.next;
        System.out.print("Queue (front to rear): ");
        while (current != head) {
            System.out.print(current.elem + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String[] args) {
        QueueDHCLL queue = new QueueDHCLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        System.out.println("Original Queue:");
        queue.displayQueue();
        
        System.out.println("Size of queue: " + queue.size());
        System.out.println("Peek at front element: " + queue.peek());
        System.out.println("Search for 20 in the queue: " + queue.search(20));
        System.out.println("Search for 40 in the queue: " + queue.search(40));
        System.out.println("Search for 60 in the queue: " + queue.search(60));
        System.out.println("Queue as string: " + queue.toString());
        
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        
        System.out.println("Queue after dequeue:");
        queue.displayQueue();
        
        System.out.println("Size of queue after dequeue: " + queue.size());
        
        System.out.println("\nEmptying the queue...");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }
        
        
        System.out.println("Trying to peek() from empty LL");
        try {
            System.out.println("Peek at front element: " + queue.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Trying to dequeue() from empty LL");
        try {
            System.out.println("Dequeued element: " + queue.dequeue());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}