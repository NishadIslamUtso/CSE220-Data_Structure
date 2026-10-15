// Function to check if the given string is a palindrome using stack and queue
public class PalindromeCheck {

    public static boolean isPalindrome(String data) {
        ListStack stack = new ListStack();  // Create an empty stack
        Queue_nonDHSLL queue = new Queue_nonDHSLL();  // Create an empty queue

        // Process each character: convert to lowercase and ignore non-alphabetic characters
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (Character.isLetterOrDigit(ch)) {  // Ignore spaces and special characters
                ch = Character.toLowerCase(ch);
                stack.push(ch);
                queue.enqueue(ch);
            }
        }

        // Compare elements from stack and queue
        while (!queue.isEmpty()) {
            if (queue.dequeue() != stack.pop()) {
                return false;  // Not a palindrome
            }
        }

        return true;  // It's a palindrome
    }

    public static boolean isQueuePalindrome(Queue_nonDHSLL queue) {
        ListStack stack = new ListStack();  // Create an empty stack
        Queue_nonDHSLL tempQueue = new Queue_nonDHSLL();  // Create a temporary queue

        // Move elements from queue to stack and tempQueue
        while (!queue.isEmpty()) {
            int elem = queue.dequeue();
            stack.push(elem);
            tempQueue.enqueue(elem);
        }

        // Compare elements from stack and tempQueue
        while (!tempQueue.isEmpty()) {
            if (tempQueue.dequeue() != stack.pop()) {
                return false;  // Not a palindrome
            }
        }

        return true;  // It's a palindrome
    }

    public static void main(String[] args) {
        String[] words = {"radar", "hello", "Able was I ere I saw Elba", "A man, a plan, a canal - Panama"};

        // Check if words are palindromes
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                System.out.println("\"" + words[i] + "\" is a palindrome.");
            } else {
                System.out.println("\"" + words[i] + "\" is not a palindrome.");
            }
        }
        
        //////////////////////////////////////////////////////////////////////////////////////////////////

        // Testing with a queue representing a palindrome
        Queue_nonDHSLL queue = new Queue_nonDHSLL();

        // Enqueue characters of a palindrome word using regular for loop
        String palindromeWord = "radar";
        for (int i = 0; i < palindromeWord.length(); i++) {
            queue.enqueue(palindromeWord.charAt(i));
        }

        // Display original queue
        queue.displayQueue();

        // Check if the queue is a palindrome
        if (isQueuePalindrome(queue)) {
            System.out.println("The queue represents a palindrome.");
        } else {
            System.out.println("The queue does not represent a palindrome.");
        }
        
        //////////////////////////////////////////////////////////////////////////////////////////////////

        // Testing with a non-palindrome queue
        Queue_nonDHSLL queue2 = new Queue_nonDHSLL();
        String nonPalindromeWord = "hello";

        // Enqueue characters of a non-palindrome word using regular for loop
        for (int i = 0; i < nonPalindromeWord.length(); i++) {
            queue2.enqueue(nonPalindromeWord.charAt(i));
        }

        queue2.displayQueue();

        if (isQueuePalindrome(queue2)) {
            System.out.println("The queue represents a palindrome.");
        } else {
            System.out.println("The queue does not represent a palindrome.");
        }
    }
}