// ============================================================
// Stack Class (Linked List Based)
// ============================================================
class Stack {

    private Node top;
    private int size;

    Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }

        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Empty");
        }

        return top.data;
    }
}


