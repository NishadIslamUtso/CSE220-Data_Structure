// ============================================================
// Driver Class
// ============================================================
public class Queue_driver {

    public static Queue queueGroupReverse(Queue q, int k) {

        if (q.isEmpty() || k <= 1) {
            return q;
        }

        Stack s = new Stack();
        Queue result = new Queue();

        while (!q.isEmpty()) {

            Queue tempQ = new Queue();
            int count = 0;

            while (!q.isEmpty() && count < k) {
                tempQ.enqueue(q.dequeue());
                count++;
            }

            if (count == k) {

                while (!tempQ.isEmpty()) {
                    s.push(tempQ.dequeue());
                }

                while (!s.isEmpty()) {
                    result.enqueue(s.pop());
                }
            }

            else {

                while (!tempQ.isEmpty()) {
                    result.enqueue(tempQ.dequeue());
                }
            }
        }

        while (!result.isEmpty()) {
            q.enqueue(result.dequeue());
        }

        return q;
    }


    // ========================================================
    // MAIN DRIVER
    // ========================================================
    public static void main(String[] args) {

        // ---------------- Case 1 ----------------
        Queue q1 = new Queue();

        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.enqueue(6);
        q1.enqueue(7);
        q1.enqueue(8);

        System.out.print("Queue: ");
        q1.printQueue();

        int k1 = 3;
        System.out.println("k = " + k1);

        queueGroupReverse(q1, k1);
        q1.printQueue();

        System.out.println();


        // ---------------- Case 2 ----------------
        Queue q2 = new Queue();

        q2.enqueue(10);
        q2.enqueue(20);
        q2.enqueue(30);
        q2.enqueue(40);
        q2.enqueue(50);
        q2.enqueue(60);

        System.out.print("Queue: ");
        q2.printQueue();

        int k2 = 2;
        System.out.println("k = " + k2);

        queueGroupReverse(q2, k2);
        q2.printQueue();

        System.out.println();


        // ---------------- Case 3 ----------------
        Queue q3 = new Queue();

        q3.enqueue(5);
        q3.enqueue(8);
        q3.enqueue(11);
        q3.enqueue(14);
        q3.enqueue(17);

        System.out.print("Queue: ");
        q3.printQueue();

        int k3 = 4;
        System.out.println("k = " + k3);

        queueGroupReverse(q3, k3);
        q3.printQueue();
    }
}