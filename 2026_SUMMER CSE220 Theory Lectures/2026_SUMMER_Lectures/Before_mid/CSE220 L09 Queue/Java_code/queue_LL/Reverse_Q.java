// Function to reverse the queue using a stack
public class Reverse_Q {
    public static Queue_nonDHSLL reverseQueue(Queue_nonDHSLL queue) {
        ListStack stack = new ListStack();

        // Move all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        System.out.println(stack.toString());

        // Move all elements from stack back to queue
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue_nonDHSLL queue = new Queue_nonDHSLL();

        // Enqueue some elements to the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("Original Queue:");
        queue.displayQueue();  // Output: Queue: 10 -> 20 -> 30 -> 40 -> None

        // Reverse the queue
        queue = reverseQueue(queue);

        System.out.println("Reversed Queue:");
        queue.displayQueue();  // Output: Queue: 40 -> 30 -> 20 -> 10 -> None
    }
}