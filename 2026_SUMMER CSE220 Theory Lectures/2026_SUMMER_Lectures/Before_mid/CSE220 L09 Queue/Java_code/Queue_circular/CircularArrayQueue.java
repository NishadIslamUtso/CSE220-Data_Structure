// Circular Array Queue Implementation
public class CircularArrayQueue {
    private Object[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    // Returns the number of items in the queue
    public int size() {
        return size;
    }

    // Returns true if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Adds an item to the back of the queue
    public void enqueue(Object item) throws QueueOverflowException {
        if (size == capacity) {
            throw new QueueOverflowException("Queue is full");
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        queue[rear] = item;
        size++;
    }

    // Removes and returns the front item of the queue
    public Object dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty");
        }

        Object item = queue[front];
        queue[front] = null; // Optional: clear reference

        if (front == rear) {
            // Last element removed
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return item;
    }

    // Returns the front item without removing it
    public Object peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty");
        }
        return queue[front];
    }

    // OPTIONAL---NOT NEEDED FOR EXAM
    // Returns a string representation of the queue
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            int index = front;
            for (int count = 0; count < size; count++) {
                result += String.valueOf(queue[index]);
                if (count < size - 1) {
                    result += " ";
                }
                index = (index + 1) % capacity;
            }
        }
        result += "]";
        return result;
    }

    // Returns an array representation of the queue
    // OPTIONAL---NOT NEEDED FOR EXAM
    public Object[] toArray() {
        Object[] result = new Object[size];
        if (!isEmpty()) {
            int index = front;
            for (int i = 0; i < size; i++) {
                result[i] = queue[index];
                index = (index + 1) % capacity;
            }
        }
        return result;
    }

    // Returns offset from the front if found; else -1
    // OPTIONAL---NOT NEEDED FOR EXAM
    public int search(Object item) {
        if (isEmpty()) return -1;
        int index = front;
        for (int offset = 0; offset < size; offset++) {
            if ((queue[index] == null && item == null) || 
                (queue[index] != null && queue[index].equals(item))) {
                return offset;
            }
            index = (index + 1) % capacity;
        }
        return -1;
    }
}
