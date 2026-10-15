public class Q3MergeStacks{

    // ============================================================
    // mergeStacks1
    // Merges two stacks sorted in non-decreasing order (top -> bottom)
    // into one stack sorted in non-decreasing order (top -> bottom).
    // ============================================================
    public static Stack mergeStacks1(Stack stack1, Stack stack2) {
        // Step 1: Reverse stack1 into temp1 (largest ends up on top)
        Stack temp1 = new Stack();
        while (!stack1.isEmpty()) {
            temp1.push(stack1.pop());
        }

        // Step 2: Reverse stack2 into temp2
        Stack temp2 = new Stack();
        while (!stack2.isEmpty()) {
            temp2.push(stack2.pop());
        }

        // Step 3: Merge into final stack (merged)
        Stack merged = new Stack();

        while (!temp1.isEmpty() || !temp2.isEmpty()) {
            if (temp1.isEmpty()) {
                merged.push(temp2.pop());
            } else if (temp2.isEmpty()) {
                merged.push(temp1.pop());
            } else {
                if (temp1.peek() >= temp2.peek()) {
                    merged.push(temp1.pop());
                } else {
                    merged.push(temp2.pop());
                }
            }
        }

        return merged;
    }

    // ============================================================
    // mergeStacks2 
    // ============================================================
    public static Stack mergeStacks2(Stack stack1, Stack stack2) {
        // temp will store merged elements temporarily (in reverse order)
        Stack temp = new Stack();

        // Merge both stacks while both have elements
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() < stack2.peek()) {
                temp.push(stack1.pop());
            } else {
                temp.push(stack2.pop());
            }
        }

        // Push remaining elements from stack1
        while (!stack1.isEmpty()) {
            temp.push(stack1.pop());
        }

        // Push remaining elements from stack2
        while (!stack2.isEmpty()) {
            temp.push(stack2.pop());
        }

        // Reverse temp into result to restore top-smallest order
        Stack result = new Stack();
        while (!temp.isEmpty()) {
            result.push(temp.pop());
        }

        return result;
    }

    // ============================================================
    // mergeStacks3 
    // ============================================================
    public static Stack mergeStacks3(Stack stack1, Stack stack2) {
        Stack temp = new Stack();     // temporary reversed output
        Stack result = new Stack();   // final merged stack

        // Merge while both stacks have data
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() < stack2.peek()) {
                temp.push(stack1.pop());   // pop ONLY the smaller one
            } else {
                temp.push(stack2.pop());
            }
        }

        // Add remaining elements from stack1
        while (!stack1.isEmpty()) {
            temp.push(stack1.pop());
        }

        // Add remaining elements from stack2
        while (!stack2.isEmpty()) {
            temp.push(stack2.pop());
        }

        // Reverse temp into result to restore top-smallest order
        while (!temp.isEmpty()) {
            result.push(temp.pop());
        }

        return result;
    }

    // ============================================================
    // Helper to build initial stacks like in Python code
    // ============================================================
    private static Stack buildStackFromArray(int[] values) {
        Stack s = new Stack();
        // Same order as Python: push in reverse so that last element
        // in the array becomes the TOP of the stack.
        for (int i = 0; i < values.length; i++) {
            s.push(values[i]);
        }
        return s;
    }

    // ============================================================
    // Test one merge function
    // ============================================================
    private static void testMergeFunction(String name) {
        System.out.println("===== SAMPLE MERGE TEST: " + name + " =====");

        // stack1 should represent: top → bottom: -2, 3, 6, 6, 10
        // Python: for v in [10, 6, 6, 3, -2] push(v)
        int[] arr1 = {10, 6, 6, 3, -2};
        Stack stack1 = buildStackFromArray(arr1);

        // stack2 should represent: top → bottom: 0, 4, 6, 8
        int[] arr2 = {8, 6, 4, 0};
        Stack stack2 = buildStackFromArray(arr2);

        System.out.print("Stack 1 (top → bottom): ");
        stack1.printStack();
        System.out.print("Stack 2 (top → bottom): ");
        stack2.printStack();

        Stack merged;
        if (name.equals("mergeStacks1")) {
            merged = mergeStacks1(stack1, stack2);
        } else if (name.equals("mergeStacks2")) {
            merged = mergeStacks2(stack1, stack2);
        } else { // mergeStacks3
            merged = mergeStacks3(stack1, stack2);
        }

        System.out.print("Merged Stack (top → bottom): ");
        merged.printStack();
        System.out.println();
    }

    // ============================================================
    // MAIN (driver)
    // ============================================================
    public static void main(String[] args) {
        testMergeFunction("mergeStacks1");
        testMergeFunction("mergeStacks2");
        testMergeFunction("mergeStacks3");
    }
}
