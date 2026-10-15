class Queue_nonDHSLL {
    private Node front, rear;
    private int size;

    public Queue_nonDHSLL() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(int elem) {
        Node newNode = new Node(elem);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: Queue is empty");
        }
        int removedElem = front.elem;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removedElem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: Queue is empty");
        }
        return front.elem;
    }

    //Optional---not needed for exam
    public int search(int obj) {
        Node current = front;
        int index = 0;
        while (current != null) {
            if (current.elem == obj) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //Optional---not needed for exam
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
    
        String result = "[";
        Node current = front;
        while (current != null) {
            result += current.elem + " ";
            current = current.next;
        }
        result = result.trim() + "]";
        return result;
    }


    //Optional---not needed for exam
    public int[] toArray() {
        int[] arr = new int[size];
        Node current = front;
        int i = 0;
        while (current != null) {
            arr[i++] = current.elem;
            current = current.next;
        }
        return arr;
    }

    //Optional---not needed for exam
    public void displayQueue() {
        Node current = front;
        System.out.print("Queue (front to rear): ");
        while (current != null) {
            System.out.print(current.elem + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String[] args) {
        Queue_nonDHSLL queue = new Queue_nonDHSLL();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Original Queue:");
        queue.displayQueue(); // Queue (front to rear): 10 -> 20 -> 30 -> 40 -> NULL

        System.out.println("Size of queue: " + queue.size());
        System.out.println("Peek at front element: " + queue.peek());
        System.out.println("Search for 20 in the queue: " + queue.search(20));
        System.out.println("Search for 40 in the queue: " + queue.search(40));
        System.out.println("Search for 60 in the queue: " + queue.search(60));

        System.out.println("Queue as string: " + queue.toString());
        System.out.print("Queue as array: ");
        for (int num : queue.toArray()) {
            System.out.print(num + " ");
        }
        System.out.println();

        queue.dequeue(); // Removes 10
        queue.dequeue(); // Removes 20
        System.out.println("Queue after dequeue:");
        queue.displayQueue(); // Expected Output: Queue (front to rear): 30 -> 40 -> NULL

        System.out.println("Size of queue after dequeue: " + queue.size());

        System.out.println("\nEmptying the queue...");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        // Try to peek when empty
        System.out.println("\nEmptying the queue...");
        try {
            System.out.println("Peek at front element: " + queue.peek());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Try to dequeue when empty
        System.out.println("Trying to peek() from empty LL");
        try {
            System.out.println("Dequeued element: " + queue.dequeue());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}