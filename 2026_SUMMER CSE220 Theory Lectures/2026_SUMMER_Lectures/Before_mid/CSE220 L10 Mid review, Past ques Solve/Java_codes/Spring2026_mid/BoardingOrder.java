public class BoardingOrder {

    public static Queue queueGroupReverse(Queue q, int k) {

        // Edge case: if queue is empty or k <= 1, no reversal is needed
        if (q.isEmpty() || k <= 1) {
            return q;
        }

        // Stack to help reverse elements
        Stack s = new Stack();

        // Temporary queue to store processed elements
        Queue result = new Queue();

        // Continue until the original queue becomes empty
        while (!q.isEmpty()) {

            // Temporary queue to hold the current group
            Queue tempQ = new Queue();

            int count = 0;

            // Remove up to k elements from original queue
            while (!q.isEmpty() && count < k) {
                int val = q.dequeue();   // remove from original queue
                tempQ.enqueue(val);      // store temporarily
                count++;
            }

            // Case 1: If exactly k elements were collected → reverse them
            if (count == k) {

                // Move elements from tempQ to stack
                while (!tempQ.isEmpty()) {
                    s.push(tempQ.dequeue());
                }

                // Pop elements from stack and enqueue into result queue
                while (!s.isEmpty()) {
                    result.enqueue(s.pop());
                }

            } 
            // Case 2: If fewer than k elements remain → keep order unchanged
            else {

                while (!tempQ.isEmpty()) {
                    result.enqueue(tempQ.dequeue());
                }
            }
        }

        // Move all elements back into the original queue
        while (!result.isEmpty()) {
            q.enqueue(result.dequeue());
        }

        return q;
    }
}