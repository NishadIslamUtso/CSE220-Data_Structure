// ============================================================
// Queue Class (Linked List Based)
// ============================================================
class Queue {

    private Node front;
    private Node rear;
    private int size;

    Queue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
        } 
        else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public int dequeue() {

        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int val = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return val;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }

        return front.data;
    }

    public void printQueue() {

        Node temp = front;

        System.out.print("(front) ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println("(rear)");
    }
}
