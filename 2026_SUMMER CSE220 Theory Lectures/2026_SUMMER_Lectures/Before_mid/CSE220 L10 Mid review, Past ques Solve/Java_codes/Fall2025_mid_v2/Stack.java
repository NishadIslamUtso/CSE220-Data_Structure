public class Stack {

    private Node top;   // top of the stack (head)
    private int size;   // number of elements

    // Constructor
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Pushes an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;  // link new node to current top
        top = newNode;       // update top
        size++;
    }

    // Pops the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Pop from empty stack");
        }

        int poppedElem = top.elem;   // get element
        top = top.next;              // move downward
        size--;
        return poppedElem;
    }

    // Peeks at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Peek from empty stack");
        }
        return top.elem;
    }

    // Returns the size of the stack
    public int getSize() {
        return size;
    }

    // Converts stack to an array (top → bottom)
    public int[] toArray() {
        int[] elements = new int[size];
        Node current = top;
        int index = 0;

        while (current != null) {
            elements[index++] = current.elem;
            current = current.next;
        }
        return elements;
    }

    // Prints stack from top to bottom
    public void printStack() {
        Node current = top;
        System.out.print("[");

        while (current != null) {
            System.out.print(current.elem);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }

        System.out.println("]");
    }
}
