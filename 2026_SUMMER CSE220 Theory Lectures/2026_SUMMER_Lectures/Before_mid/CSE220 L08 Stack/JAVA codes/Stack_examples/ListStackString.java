// ================= Stack Class (String-based) =================
class ListStackString {

    private StringNode top;  // Top of the stack
    private int size;        // Number of elements

    // Constructor
    public ListStackString() {
        this.top = null;
        this.size = 0;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Push a String onto the stack
    public void push(String data) {
        StringNode newNode = new StringNode(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop a String from the stack
    public String pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Pop from empty stack");
        }
        String val = top.data;
        top = top.next;
        size--;
        return val;
    }

    // Peek at the top element
    public String peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Underflow: Peek from empty stack");
        }
        return top.data;
    }

    // Return stack size
    public int getSize() {
        return size;
    }

    // Custom print method (Top → Bottom) — optional
    public void printStack() {
        StringNode current = top;
        System.out.print("Stack (top -> bottom): ");

        if (current == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(", ");
            current = current.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {

        ListStackString stack = new ListStackString();
    
        // Pushing elements
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
    
        stack.printStack(); // custom print
        System.out.println("Size: " + stack.getSize());
    
        // Peeking
        System.out.println("Peek: " + stack.peek());
    
        // Popping one element
        System.out.println("Popped: " + stack.pop());
        stack.printStack();   // print again after pop
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