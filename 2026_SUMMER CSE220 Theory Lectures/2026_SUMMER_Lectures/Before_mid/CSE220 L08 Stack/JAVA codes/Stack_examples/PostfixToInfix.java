// ================= Postfix to Infix Converter =================
public class PostfixToInfix {

    //  check if a character is an operator
    private static boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' ||
               symbol == '*' || symbol == '/' ||
               symbol == '^';
    }

    //  check if character is letter or digit
    private static boolean isLetterOrDigit(char ch) {
        return (ch >= 'A' && ch <= 'Z') ||
               (ch >= 'a' && ch <= 'z') ||
               (ch >= '0' && ch <= '9');
    }

    private static String charToString(char ch) {
        return "" + ch;   
    }

    // Convert postfix expression to infix expression
    public static String postfixToInfix(String postfix) {

        ListStackString stack = new ListStackString();

        for (int i = 0; i < postfix.length(); i++) {
            char symbol = postfix.charAt(i);

            // skip spaces
            if (symbol == ' ') continue;

            // operand (letter or digit)
            if (isLetterOrDigit(symbol)) {
                stack.push(charToString(symbol));
            }

            // operator
            else if (isOperator(symbol)) {
                String operand1 = stack.pop(); // right operand
                String operand2 = stack.pop(); // left operand

                String expression =
                        "(" + operand2 + " " + symbol + " " + operand1 + ")";

                stack.push(expression);
            }
        }

        return stack.pop();
    }

    // ================= Test Main =================
    public static void main(String[] args) {

        String postfixExpr;
        String infixExpr;

        postfixExpr = "ABC/-AD/E-*"; 
        infixExpr = postfixToInfix(postfixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
        System.out.println("Infix Expression:   " + infixExpr);
        System.out.println("--------------------");

        postfixExpr = "ABC*+DE/-";
        infixExpr = postfixToInfix(postfixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
        System.out.println("Infix Expression:   " + infixExpr);
        System.out.println("--------------------");

        postfixExpr = "AB+CDE/*-F+"; 
        infixExpr = postfixToInfix(postfixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
        System.out.println("Infix Expression:   " + infixExpr);
        System.out.println("--------------------");

        postfixExpr = "ABCDE/-*+"; 
        infixExpr = postfixToInfix(postfixExpr);
        System.out.println("Postfix Expression: " + postfixExpr);
        System.out.println("Infix Expression:   " + infixExpr);
        System.out.println("--------------------");
    }
}
