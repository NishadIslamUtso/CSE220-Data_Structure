import java.util.Arrays;

public class ArrayStack {
    private Object[] stack; // Array to hold stack elements
    private int size;       // Tracks the number of elements in the stack

    public ArrayStack(int capacity) {
        stack = new Object[capacity]; // Initialize the stack with the given capacity
        size = 0; // Start with an empty stack
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if the stack is full
    public boolean isFull() {
        return size == stack.length;
    }

    // Pushes an element onto the stack
    public void push(Object data) {
        if (isFull()) {
            throw new StackOverflowError("Stack overflow: Cannot push onto a full stack");
        }
        stack[size] = data;
        size++;
    }

    // Pops the top element from the stack
    public Object pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack underflow: Cannot pop from an empty stack");
        }
        Object data = stack[size - 1];
        size--;
        return data;
    }

    // Peeks at the top element of the stack
    public Object peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack underflow: Cannot peek into an empty stack");
        }
        return stack[size - 1];
    }

    // Returns the current size of the stack
    public int getSize() {
        return size;
    }

    // Converts the stack to a string representation
    @Override
    public String toString() {
        String ans = "Stack (bottom -> top):";
        for (int i = 0; i < size; i++) {
            ans += stack[i] + " "; // Concatenate each element to the string
        }
        return ans;
    }

    // Converts the stack to an array (from top to bottom)
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            result[j] = stack[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        // Pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.toString()); // Stack (bottom -> top): 10 20 30 
        System.out.println("Size: " + stack.getSize()); // Size: 3

        // Converting stack to array
        System.out.println("Stack as Array: " + Arrays.toString(stack.toArray())); // Stack as Array: [30, 20, 10]

        // Peeking
        System.out.println("Peek: " + stack.peek()); // Peek: 30

        // Popping elements
        System.out.println("Popped: " + stack.pop()); // Popped: 30
        System.out.println(stack.toString());         // Stack (bottom -> top): 10 20 
        System.out.println("Size: " + stack.getSize()); // Size: 2

        try {
            stack.push(40);
            System.out.println("Pushed 40");
            System.out.println("Size: " + stack.getSize());

            stack.push(50);
            System.out.println("Pushed 50");
            System.out.println("Size: " + stack.getSize());

            stack.push(60);
            System.out.println("Pushed 60");
            System.out.println("Size: " + stack.getSize());

            System.out.println("Trying to push 70:");
            stack.push(70); // This will cause a StackOverflowError
            System.out.println("Size: " + stack.getSize());
        } catch (StackOverflowError e) {
            System.out.println(e.getMessage());
        }

        while (!stack.isEmpty()) {
            System.out.println("Popped element from top: " + stack.pop());
        }

        try {
            stack.pop(); // This will cause an IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
