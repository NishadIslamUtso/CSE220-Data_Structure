public class ReverseWord {

    // Function to reverse a word using ListStack without StringBuilder
    public static String reverseWord(String word) {
        ListStack stack = new ListStack();

        // Push each character of the word onto the stack
        for (int i = 0; i < word.length(); i++) {
            stack.push((int) word.charAt(i)); // Cast char to int for ListStack
        }

        // Pop characters from the stack and build the reversed string using concatenation
        String reversedWord = "";
        while (!stack.isEmpty()) {
            reversedWord += (char) stack.pop(); // Cast int back to char and concatenate
        }

        return reversedWord;
    }

    public static void main(String[] args) {
        // Example 1
        String word1 = "hello";
        System.out.println("Original word: " + word1);
        System.out.println("Reversed word: " + reverseWord(word1));
        System.out.println("-".repeat(20));

        // Example 2
        String word2 = "CSE220";
        System.out.println("Original word: " + word2);
        System.out.println("Reversed word: " + reverseWord(word2));
    }
}
