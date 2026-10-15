// Node class for the stack
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class implemented using singly linked list
class Stack {
    private Node top;  // top of the stack
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Push element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop the top element
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: Pop from empty stack");
        }
        int poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }

    // Peek at the top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow: Peek from empty stack");
        }
        return top.data;
    }
}

public class Summer2025_depositSUm {

    // Prints stack from top to bottom without permanently changing it
    public static String stackToStringWithTop(Stack st) {
        Stack temp = new Stack();
        String result = "TOP -> [";

        boolean first = true;

        while (!st.isEmpty()) {
            int val = st.pop();

            if (!first) {
                result += ", ";
            }

            result += val;
            first = false;

            temp.push(val);
        }

        // Restore original stack
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        result += "]";
        return result;
    }

    public static Stack depositSum(Stack st, int window) {
        System.out.println("Given stack: " + stackToStringWithTop(st));

        Stack result = new Stack();

        // Process each window from the top of the stack
        while (!st.isEmpty()) {
            int depositSum = 0;
            int count = 0;

            // Process at most 'window' elements
            while (count < window && !st.isEmpty()) {
                int val = st.pop();

                // Add only deposits
                if (val > 0) {
                    depositSum += val;
                }

                count++;
            }

            // Store sum of current window
            result.push(depositSum);
        }

        // Put results back into the original stack
        while (!result.isEmpty()) {
            st.push(result.pop());
        }

        System.out.println("Returned stack: " + stackToStringWithTop(st));
        return st;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // 12 will be at the TOP
        int[] values = {14, 9, -2, -6, -20, -7, 15, 8, -3, 12};

        for (int value : values) {
            stack.push(value);
        }

        depositSum(stack, 4);
    }
}