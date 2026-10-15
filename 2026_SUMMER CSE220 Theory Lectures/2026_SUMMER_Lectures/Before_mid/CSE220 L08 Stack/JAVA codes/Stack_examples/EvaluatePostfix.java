public class EvaluatePostfix {

    // Function to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        ListStack stack = new ListStack(); // Use ListStack to manage operands
        String currentNumber = ""; // String to build the current number

        // Loop through each character in the postfix expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch >= '0' && ch <= '9') { // If the character is a digit
                currentNumber += ch; // Append the digit to the current number
            } else if (ch == ' ') { // Check for space
                if (!currentNumber.isEmpty()) { // If there's a number, push it to the stack
                    stack.push(Integer.parseInt(currentNumber));
                    currentNumber = ""; // Reset the current number
                }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') { // Operator (+, -, *, /)

                // Pop the two operands
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // Perform the operation using if-else
                int result;
                if (ch == '+') {
                    result = operand1 + operand2;
                } else if (ch == '-') {
                    result = operand1 - operand2;
                } else if (ch == '*') {
                    result = operand1 * operand2;
                } else { // ch == '/'
                    result = operand1 / operand2;
                }

                // Push the result back onto the stack
                stack.push(result);
            }
        }

        // If there's a number left, push it to the stack
        // Special Case, when the given expression does not have any operator
        if (!currentNumber.isEmpty()) {
            stack.push(Integer.parseInt(currentNumber));
        }

        // The result is the last item remaining in the stack
        return stack.pop();
    }

    public static void main(String[] args) {

        // Example 0
        String postfixExpression2 = "3 5 9 * +";
        int infixExpression2 = 3 + 5 * 9;
        System.out.println("Postfix Expression: " + postfixExpression2);
        System.out.println("Postfix Evaluation Result: " + evaluatePostfix(postfixExpression2));
        System.out.println("Infix Evaluation Result: " + infixExpression2);
        System.out.println("-".repeat(20));

        // Example 1
        String postfixExpression22 = "30 10 9 * +";
        int infixExpression22 = 30 + 10 * 9;
        int result22 = evaluatePostfix(postfixExpression22);
        System.out.println("Postfix Evaluation Result: " + result22);
        System.out.println("Infix Evaluation Result: " + infixExpression22);
        System.out.println("-".repeat(20));

        // Example 2
        String postfixExpression1 = "3 2 + 4 * 5 1 - /";
        int infixExpression1 = ((3 + 2) * 4) / (5 - 1);
        System.out.println("Postfix Expression: " + postfixExpression1);
        System.out.println("Postfix Evaluation Result: " + evaluatePostfix(postfixExpression1));
        System.out.println("Infix Evaluation Result: " + infixExpression1);
        System.out.println("-".repeat(20));

        
        // Example 5
        String postfixExpression5 = "422";
        int infixExpression5 = 422;
        System.out.println("Postfix Expression: " + postfixExpression5);
        System.out.println("Postfix Evaluation Result: " + evaluatePostfix(postfixExpression5));
        System.out.println("Infix Evaluation Result: " + infixExpression5);
        System.out.println("-".repeat(20));
    }
}
