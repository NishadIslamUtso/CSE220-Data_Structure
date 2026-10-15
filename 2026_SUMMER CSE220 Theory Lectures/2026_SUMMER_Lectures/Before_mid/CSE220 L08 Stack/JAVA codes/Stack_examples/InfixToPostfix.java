// Infix to Postfix conversion
public class InfixToPostfix {

    // Precedence check
    public static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        if (op == '^') return 3;
        return 0;
    }

    public static boolean isAlnumAscii(char ch) {
        int v = ch;
        if (v >= '0' && v <= '9') return true;
        if (v >= 'A' && v <= 'Z') return true;
        if (v >= 'a' && v <= 'z') return true;
        return false;
    }

    // Convert infix to postfix
    public static String infixToPostfix(String expression) {
        ListStack stack = new ListStack();

        String postfix = ""; 

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If operand → add to postfix
            if (isAlnumAscii(ch)) {
                postfix = postfix + ch;
            }
            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && (char) stack.peek() != '(') {
                    postfix = postfix + (char) stack.pop();
                }
                stack.pop(); // remove '('
            }
            // Operator
            else {
                while (!stack.isEmpty() &&
                       precedence((char) stack.peek()) >= precedence(ch)) {
                    postfix = postfix + (char) stack.pop();
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix = postfix + (char) stack.pop();
        }

        return postfix;
    }

    public static void main(String[] args) {
        String e1 = "A*(B+C+D)";
        System.out.println("Infix: " + e1 + " → Postfix: " + infixToPostfix(e1));

        String e2 = "A*(B+C-(D+E/F))";
        System.out.println("Infix: " + e2 + " → Postfix: " + infixToPostfix(e2));

        String e3 = "((A+B)-C*(D/E))+F";
        System.out.println("Infix: " + e3 + " → Postfix: " + infixToPostfix(e3));

        String e4 = "A+B*C";
        System.out.println("Infix: " + e4 + " → Postfix: " + infixToPostfix(e4));

        String e5 = "(A+B)*C";
        System.out.println("Infix: " + e5 + " → Postfix: " + infixToPostfix(e5));

        String e6 = "2+3*4";
        System.out.println("Infix: " + e6 + " → Postfix: " + infixToPostfix(e6));

        String e7 = "(5+6)*7";
        System.out.println("Infix: " + e7 + " → Postfix: " + infixToPostfix(e7));
    }
}
