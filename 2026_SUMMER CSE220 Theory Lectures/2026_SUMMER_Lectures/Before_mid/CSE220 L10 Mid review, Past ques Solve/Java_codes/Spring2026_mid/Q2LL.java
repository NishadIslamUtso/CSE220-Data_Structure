public class Q2LL {

    public static CellNode sendPulse(CellNode head) {
        CellNode current = head; // start from head

        while (current != null) {
            if (current.pulse_radius > 0) { // if current node emits pulse
                int r = current.pulse_radius;

                // move left r steps to find left boundary
                CellNode left_bound = current;
                int steps = r;
                while (steps > 0 && left_bound.prev != null) {
                    left_bound = left_bound.prev;
                    steps--;
                }

                // move right r steps to find right boundary
                CellNode right_bound = current;
                steps = r;
                while (steps > 0 && right_bound.next != null) {
                    right_bound = right_bound.next;
                    steps--;
                }

                // identify surviving neighbors
                CellNode left_survivor = left_bound.prev;
                CellNode right_survivor = right_bound.next;

                // reconnect surviving parts
                if (left_survivor != null) {
                    left_survivor.next = right_survivor;
                } else {
                    head = right_survivor; // update head if needed
                }

                if (right_survivor != null) {
                    right_survivor.prev = left_survivor;
                }

                current = right_survivor; // move to next valid node
            } else {
                current = current.next; // move forward if no pulse
            }
        }

        return head; // return final head
    }

    public static CellNode buildDLL(int[][] data) {
        if (data.length == 0) {
            return null;
        }

        CellNode head = new CellNode(data[0][0], data[0][1]);
        CellNode tail = head;

        for (int i = 1; i < data.length; i++) {
            CellNode node = new CellNode(data[i][0], data[i][1]);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        return head;
    }

    public static void printDLL(CellNode head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        CellNode current = head;
        while (current != null) {
            System.out.print("(" + current.val + ", " + current.pulse_radius + ")");
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Test Case 1
        CellNode head1 = buildDLL(new int[][]{
            {5, 0}, {10, 1}, {15, 0}, {20, 0}
        });
        System.out.println("Original List 1:");
        printDLL(head1);
        head1 = sendPulse(head1);
        System.out.println("Final List 1:");
        printDLL(head1);
        System.out.println("--------------------------------------------------");

        // Test Case 2
        CellNode head2 = buildDLL(new int[][]{
            {5, 0}, {10, 0}, {15, 1}, {20, 1}, {25, 0}
        });
        System.out.println("Original List 2:");
        printDLL(head2);
        head2 = sendPulse(head2);
        System.out.println("Final List 2:");
        printDLL(head2);
        System.out.println("--------------------------------------------------");

        // Test Case 3 (radius = 2)
        CellNode head3 = buildDLL(new int[][]{
            {5, 0}, {10, 0}, {15, 2}, {20, 0}, {25, 0}, {30, 0}
        });
        System.out.println("Original List 3:");
        printDLL(head3);
        head3 = sendPulse(head3);
        System.out.println("Final List 3:");
        printDLL(head3);
        System.out.println("--------------------------------------------------");

        // Test Case 4
        CellNode head4 = buildDLL(new int[][]{
            {1, 0}, {2, 2}, {3, 0}, {4, 0}, {5, 1}, {6, 0}, {7, 0}
        });
        System.out.println("Original List 4:");
        printDLL(head4);
        head4 = sendPulse(head4);
        System.out.println("Final List 4:");
        printDLL(head4);
    }
}