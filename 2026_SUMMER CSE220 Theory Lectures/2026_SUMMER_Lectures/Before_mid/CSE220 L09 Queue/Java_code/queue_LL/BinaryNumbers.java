// Class to generate binary numbers
public class BinaryNumbers {

    public static void generateBinaryNumbers(int n) {
        Queue_nonDHSLL queue = new Queue_nonDHSLL();
        queue.enqueue(1);

        for (int i = 0; i < n; i++) {
            int front = queue.dequeue();
            System.out.print(front + " ");
            queue.enqueue(front * 10);
            queue.enqueue(front * 10 + 1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;  // Generate the first 10 binary numbers
        System.out.println("First " + n + " binary numbers:");
        generateBinaryNumbers(n);

        n = 20;  // Generate the first 20 binary numbers
        System.out.println("First " + n + " binary numbers:");
        generateBinaryNumbers(n);
    }
}