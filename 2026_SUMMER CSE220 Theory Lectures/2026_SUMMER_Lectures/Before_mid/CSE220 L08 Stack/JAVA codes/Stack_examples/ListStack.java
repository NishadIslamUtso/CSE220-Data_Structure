class ListStack {
    private Node top; // Represents the top of the stack (head node)
    private int size; // Tracks the size of the stack

    // Constructor
    public ListStack() {
        this.top = null; // Initially, the stack is empty
        this.size = 0;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Pushes an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // Link the new node to the current top
        top = newNode;      // Update top to the new node
        size++;
    }

    // Pops the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Pop from empty stack");
        }
        int poppedData = top.data; // Retrieve data of the top node
        top = top.next;            // Update top to the next node
        size--;
        return poppedData;
    }

    // Peeks at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Peek from empty stack");
        }
        return top.data;
    }

    // Returns the size of the stack
    public int getSize() {
        return size;
    }

    // Converts the stack to an array representation (from top to bottom)
    public int[] toArray() {
        int[] elements = new int[size];
        Node current = top;
        int index = 0;
        while (current != null) {
            elements[index++] = current.data; // Collect data from top to bottom
            current = current.next;
        }
        return elements;
    }

    public void printStack() {
        Node current = top;
        System.out.print("Stack (top -> bottom): [");

        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }

        System.out.println("]");
    }

 
    public static void main(String[] args) {
        ListStack stack = new ListStack();

        // Pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.printStack(); // custom print instead of Arrays.toString
        System.out.println("Size: " + stack.getSize());

        // Peeking
        System.out.println("Peek: " + stack.peek());

        // Popping elements
        System.out.println("Popped: " + stack.pop());
        stack.printStack(); // print again after pop
        System.out.println("Size: " + stack.getSize());
        System.out.println("Is empty: " + stack.isEmpty());

        // Clearing stack
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.getSize());
    }
}
