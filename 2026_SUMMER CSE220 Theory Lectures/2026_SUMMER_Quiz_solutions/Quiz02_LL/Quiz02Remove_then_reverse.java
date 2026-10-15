public class Quiz02Remove_then_reverse {

    /*
     * Reverses a non-dummy-headed singly linked list in place.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node reverseInPlace(Node head) {

        // STEP 01
        Node prev = null;       // For changing the direction of the link
        Node current = head;    // To traverse the linked list

        while (current != null) {

            Node nextNode = current.next;  // Store the next node
            current.next = prev;           // Reverse the link

            prev = current;                // Move prev forward
            current = nextNode;            // Move current forward
        }

        return prev;  // New head of the reversed linked list
    }


    /*
     * Removes all even nodes and reverses
     * the remaining odd nodes.
     */
    public static Node oddReverse(Node head) {

        Node pred = null;  // Previous retained node
        Node rem = head;   // Node being examined or removed

        while (rem != null) {

            // Store the successor before modifying any link
            Node succ = rem.next;

            // Remove rem if it contains an even value
            if (rem.elem % 2 == 0) {

                // Special case: rem is the head
                if (pred == null) {
                    head = succ;
                }

                // General case: rem is after pred
                else {
                    pred.next = succ;
                }

                // Disconnect the removed node
                rem.next = null;
            }

            // Retain rem if it contains an odd value
            else {
                pred = rem;
            }

            // Move rem forward
            rem = succ;
        }

        // Reverse the remaining odd nodes
        return reverseInPlace(head);
    }


    /*
     * Removes all odd nodes and reverses
     * the remaining even nodes.
     */
    public static Node evenReverse(Node head) {

        Node pred = null;  // Previous retained node
        Node rem = head;   // Node being examined or removed

        while (rem != null) {

            // Store the successor before modifying any link
            Node succ = rem.next;

            // Remove rem if it contains an odd value
            if (rem.elem % 2 != 0) {

                // Special case: rem is the head
                if (pred == null) {
                    head = succ;
                }

                // General case: rem is after pred
                else {
                    pred.next = succ;
                }

                // Disconnect the removed node
                rem.next = null;
            }

            // Retain rem if it contains an even value
            else {
                pred = rem;
            }

            // Move rem forward
            rem = succ;
        }

        // Reverse the remaining even nodes
        return reverseInPlace(head);
    }


    /*
     * Removes all nodes containing values greater than
     * or equal to X and reverses the remaining nodes.
     */
    public static Node lessThanXReverse(Node head, int X) {

        Node pred = null;  // Previous retained node
        Node rem = head;   // Node being examined or removed

        while (rem != null) {

            // Store the successor before modifying any link
            Node succ = rem.next;

            // Remove rem if its value is not less than X
            if (rem.elem >= X) {

                // Special case: rem is the head
                if (pred == null) {
                    head = succ;
                }

                // General case: rem is after pred
                else {
                    pred.next = succ;
                }

                // Disconnect the removed node
                rem.next = null;
            }

            // Retain rem if its value is less than X
            else {
                pred = rem;
            }

            // Move rem forward
            rem = succ;
        }

        // Reverse the remaining nodes
        return reverseInPlace(head);
    }


    /*
     * Removes all nodes containing values less than
     * or equal to X and reverses the remaining nodes.
     */
    public static Node greaterThanXReverse(Node head, int X) {

        Node pred = null;  // Previous retained node
        Node rem = head;   // Node being examined or removed

        while (rem != null) {

            // Store the successor before modifying any link
            Node succ = rem.next;

            // Remove rem if its value is not greater than X
            if (rem.elem <= X) {

                // Special case: rem is the head
                if (pred == null) {
                    head = succ;
                }

                // General case: rem is after pred
                else {
                    pred.next = succ;
                }

                // Disconnect the removed node
                rem.next = null;
            }

            // Retain rem if its value is greater than X
            else {
                pred = rem;
            }

            // Move rem forward
            rem = succ;
        }

        // Reverse the remaining nodes
        return reverseInPlace(head);
    }


    /*
     * Creates a linked list for testing.
     *
     * New nodes are created only by the driver.
     * The four required methods do not create new nodes.
     */
    public static Node createList(int[] values) {

        if (values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node tail = head;

        for (int i = 1; i < values.length; i++) {
            tail.next = new Node(values[i]);
            tail = tail.next;
        }

        return head;
    }


    // Prints the linked list
    public static void printList(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.elem + " → ");
            current = current.next;
        }

        System.out.println("NULL");
    }


    /*
     * Tests all four methods using one sample.
     *
     * A fresh linked list is created for each method because
     * every method modifies the original node links.
     */
    public static void testSample(int sampleNumber, int[] values, int X) {

        System.out.println("Sample " + sampleNumber);
        System.out.println("X = " + X);

        System.out.print("Original list:            ");
        printList(createList(values));

        Node oddResult = oddReverse(createList(values));
        System.out.print("oddReverse:               ");
        printList(oddResult);

        Node evenResult = evenReverse(createList(values));
        System.out.print("evenReverse:              ");
        printList(evenResult);

        Node lessResult = lessThanXReverse(createList(values), X);
        System.out.print("lessThanXReverse:         ");
        printList(lessResult);

        Node greaterResult = greaterThanXReverse(createList(values), X);
        System.out.print("greaterThanXReverse:      ");
        printList(greaterResult);

        System.out.println("----------------------------------------");
    }


    public static void main(String[] args) {

        // Sample 1
        testSample(
                1,
                new int[]{8, 13, 4, 7, 10},
                10
        );

        // Sample 2
        testSample(
                2,
                new int[]{20, 33, 44, 77},
                50
        );

        // Sample 3
        testSample(
                3,
                new int[]{13, 7},
                10
        );

        // Sample 4
        testSample(
                4,
                new int[]{20, 44},
                10
        );
    }
}