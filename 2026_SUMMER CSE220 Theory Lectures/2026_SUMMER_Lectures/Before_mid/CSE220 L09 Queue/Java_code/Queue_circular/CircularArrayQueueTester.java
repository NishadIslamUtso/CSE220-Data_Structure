public class CircularArrayQueueTester {
    public static void main(String[] args) {
        CircularArrayQueue q = new CircularArrayQueue(3);
        try {
            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);
            q.enqueue(40); // Will throw QueueOverflowException
        } catch (QueueOverflowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Dequeued: " + q.dequeue());
            System.out.println("Peek: " + q.peek());
            System.out.println("Dequeued: " + q.dequeue());
            System.out.println("Dequeued: " + q.dequeue());
            System.out.println("Dequeued: " + q.dequeue()); // Will throw QueueUnderflowException
        } catch (QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Queue: " + q.toString());
    }
}
