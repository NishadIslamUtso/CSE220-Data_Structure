public class Quiz02GreaterThanXReverseSolution {

    public static Node greaterThanXReverse(Node head, int x) {
        Node newHead = null;
        Node current = head;

        while (current != null) {
            // Save the next node before changing current.next
            Node nextNode = current.next;

            if (current.elem > x) {
                // Reuse and prepend the existing node
                current.next = newHead;
                newHead = current;
            }

            current = nextNode;
        }

        return newHead;
    }


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


    public static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.elem + " → ");
            current = current.next;
        }

        System.out.println("NULL");
    }


    public static void main(String[] args) {

        // Example 1
        Node head1 = createList(new int[]{5, 12, 3, 20, 8});

        System.out.println("Example 1");
        System.out.print("Input:    ");
        printList(head1);

        Node result1 = greaterThanXReverse(head1, 10);

        System.out.print("Returned: ");
        printList(result1);
        // 20 → 12 → NULL

        System.out.println("------------------------------");


        // Example 2
        Node head2 = createList(new int[]{100, 45, 60, 10});

        System.out.println("Example 2");
        System.out.print("Input:    ");
        printList(head2);

        Node result2 = greaterThanXReverse(head2, 50);

        System.out.print("Returned: ");
        printList(result2);
        // 60 → 100 → NULL

        System.out.println("------------------------------");


        // Example 3
        Node head3 = createList(new int[]{50, 12, 20});

        System.out.println("Example 3");
        System.out.print("Input:    ");
        printList(head3);

        Node result3 = greaterThanXReverse(head3, 10);

        System.out.print("Returned: ");
        printList(result3);
        // 20 → 12 → 50 → NULL

        System.out.println("------------------------------");


        // Example 4
        Node head4 = createList(new int[]{45, 6, 10});

        System.out.println("Example 4");
        System.out.print("Input:    ");
        printList(head4);

        Node result4 = greaterThanXReverse(head4, 50);

        System.out.print("Returned: ");
        printList(result4);
        // NULL
    }
}