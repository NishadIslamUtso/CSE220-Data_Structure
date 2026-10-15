public class Quiz02AoddReverse {

    public static Node oddReverse(Node head) {
        Node newHead = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;

            if (current.elem % 2 != 0) {
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
        Node head1 = createList(new int[]{8, 13, 4, 7, 11});

        System.out.println("Example 1");
        System.out.print("Input:    ");
        printList(head1);

        Node result1 = oddReverse(head1);

        System.out.print("Returned: ");
        printList(result1);
        // 11 → 7 → 13 → NULL

        System.out.println("------------------------------");

        // Example 2
        Node head2 = createList(new int[]{20, 33, 44, 77});

        System.out.println("Example 2");
        System.out.print("Input:    ");
        printList(head2);

        Node result2 = oddReverse(head2);

        System.out.print("Returned: ");
        printList(result2);
        // 77 → 33 → NULL

        System.out.println("------------------------------");

        // Example 3
        Node head3 = createList(new int[]{8, 4});

        System.out.println("Example 3");
        System.out.print("Input:    ");
        printList(head3);

        Node result3 = oddReverse(head3);

        System.out.print("Returned: ");
        printList(result3);
        // NULL

        System.out.println("------------------------------");

        // Example 4
        Node head4 = createList(new int[]{21, 33});

        System.out.println("Example 4");
        System.out.print("Input:    ");
        printList(head4);

        Node result4 = oddReverse(head4);

        System.out.print("Returned: ");
        printList(result4);
        // 33 → 21 → NULL
    }
}