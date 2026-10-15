// Stack class using LinkedList
class ListStack {
    private Node top;
    private int size;

    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int elem) {
        Node newNode = new Node(elem);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Pop from empty stack");
        }
        int poppedElem = top.elem;
        top = top.next;
        size--;
        return poppedElem;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Peek from empty stack");
        }
        return top.elem;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        Node current = top;
        StringBuilder ans = new StringBuilder("Stack (bottom -> top):");
        while (current != null) {
            ans.append(" ").append(current.elem);
            current = current.next;
        }
        return ans.toString();
    }
}