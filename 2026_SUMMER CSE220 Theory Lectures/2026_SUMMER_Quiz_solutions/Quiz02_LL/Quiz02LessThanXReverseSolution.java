public class Quiz02LessThanXReverseSolution {

    public static Node lessThanXReverse(Node head, int x) {
        Node newHead = null;
        Node current = head;

        while (current != null) {
            // Save the next node before changing current.next
            Node nextNode = current.next;

            if (current.elem < x) {
                // Prepend the existing node to reverse the order
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
        Node head1 = createList(new int[]{15, 3, 22, 8, 11});

        System.out.println("Example 1");
        System.out.print("Input:    ");
        printList(head1);

        Node result1 = lessThanXReverse(head1, 10);

        System.out.print("Returned: ");
        printList(result1);
        // 8 → 3 → NULL

        System.out.println("------------------------------");


        // Example 2
        Node head2 = createList(new int[]{50, 5, 30, 2});

        System.out.println("Example 2");
        System.out.print("Input:    ");
        printList(head2);

        Node result2 = lessThanXReverse(head2, 10);

        System.out.print("Returned: ");
        printList(result2);
        // 2 → 5 → NULL

        System.out.println("------------------------------");


        // Example 3
        Node head3 = createList(new int[]{5, 3, 2});

        System.out.println("Example 3");
        System.out.print("Input:    ");
        printList(head3);

        Node result3 = lessThanXReverse(head3, 10);

        System.out.print("Returned: ");
        printList(result3);
        // 2 → 3 → 5 → NULL

        System.out.println("------------------------------");


        // Example 4
        Node head4 = createList(new int[]{50, 53, 30, 20});

        System.out.println("Example 4");
        System.out.print("Input:    ");
        printList(head4);

        Node result4 = lessThanXReverse(head4, 10);

        System.out.print("Returned: ");
        printList(result4);
        // NULL
    }
}