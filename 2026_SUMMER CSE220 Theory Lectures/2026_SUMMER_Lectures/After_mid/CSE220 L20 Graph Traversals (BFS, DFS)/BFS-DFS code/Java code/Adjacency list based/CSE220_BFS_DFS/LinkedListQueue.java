class LinkedListQueue {
    private Node front, rear;
    private int size;

    public LinkedListQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
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
            throw new RuntimeException("Queue is empty");
        }
        return front.elem;
    }

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

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = front;
        while (current != null) {
            sb.append(current.elem).append(" ");
            current = current.next;
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

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

    public void displayQueue() {
        Node current = front;
        System.out.print("Queue (front to rear): ");
        while (current != null) {
            System.out.print(current.elem + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}