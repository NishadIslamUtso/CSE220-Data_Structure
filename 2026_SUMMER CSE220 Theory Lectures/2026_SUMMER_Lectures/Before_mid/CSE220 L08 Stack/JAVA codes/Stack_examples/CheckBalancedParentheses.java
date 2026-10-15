public class CheckBalancedParentheses {

    public static void checkBalancedParentheses(String expression) {
        ListStack stack = new ListStack(); // Initialize a stack to hold opening brackets

        // Use a regular for loop instead of enhanced for loop
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // Push opening brackets onto the stack
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            }
            // Check matching pairs for closing brackets
            else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Error: Extra closing bracket found");
                    return;
                }
                char lastOpening = (char) stack.pop();
                if ((lastOpening == '(' && currentChar != ')') ||
                    (lastOpening == '{' && currentChar != '}') ||
                    (lastOpening == '[' && currentChar != ']')) {
                    System.out.println("Error: Mismatched brackets");
                    return;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        if (stack.isEmpty()) {
            System.out.println("Ok 👍: Expression is balanced");
        } else {
            System.out.println("Error: Extra opening brackets left");
        }
    }

    public static void main(String[] args) {
        
        // Example 0: Incorrectly balanced expression
        String expression_0 = "2 * (3 + 4)}]";
        System.out.println("Checking: " + expression_0);
        checkBalancedParentheses(expression_0);
        System.out.println("-".repeat(50));

        // Example 1: Correctly balanced expression
        String expression1 = "[3 + {2 * (3 + 4)}]";
        System.out.println("Checking: " + expression1);
        checkBalancedParentheses(expression1);
        System.out.println("-".repeat(50));

        // Example 2: Incorrectly balanced expression
        String expression2 = "[3 + {2 * (3 + 4)]}";
        System.out.println("\nChecking: " + expression2);
        checkBalancedParentheses(expression2);
        System.out.println("-".repeat(50));
    }
}
