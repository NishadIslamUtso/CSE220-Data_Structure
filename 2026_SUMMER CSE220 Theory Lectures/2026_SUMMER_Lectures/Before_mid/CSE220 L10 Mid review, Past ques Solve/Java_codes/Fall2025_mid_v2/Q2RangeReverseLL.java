public class Q2RangeReverseLL {

    // =========================================
    // reverseInPlace (helper)
    // =========================================
    public static Node reverseInPlace(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;  // new head of reversed part
    }

    // =========================================
    // rangeReverse2 - in-place range reverse
    // (no extra helpers, no move-to-front)
    // =========================================
    public static void rangeReverse2(Node dHead, int start, int end) {
        // Move beforeNode to node just BEFORE 'start'
        Node beforeNode = dHead;
        for (int i = 1; i < start; i++) {
            if (beforeNode.next == null) {
                return; // start beyond length
            }
            beforeNode = beforeNode.next;
        }

        Node startNode = beforeNode.next;
        if (startNode == null) {
            return; // nothing to reverse
        }

        Node prev = null;
        Node curr = startNode;

        int i = start;
        // Reverse segment [start..end], or until list ends
        while (curr != null && i <= end) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            i++;
        }

        // Reconnect
        beforeNode.next = prev;   // new head of reversed segment
        startNode.next = curr;    // tail of reversed -> remainder
    }

    // =========================================
    // rangeReverse1 - reverse [start..end],
    // move reversed block to FRONT of list,
    // then append remaining nodes
    // =========================================
    public static void rangeReverse1(Node dHead, int start, int end) {
        if (dHead.next == null) {
            return; // empty list
        }

        Node originalHead = dHead.next;  // first real node

        // 1. Find beforeNode (node BEFORE start)
        Node beforeNode = dHead;
        int idx = 0;
        while (idx < start && beforeNode.next != null) {
            beforeNode = beforeNode.next;
            idx++;
        }

        if (beforeNode.next == null) {
            return; // start beyond length
        }

        // 2. Identify startNode and endNode
        Node startNode = beforeNode.next;
        Node endNode = startNode;

        for (int k = 0; k < (end - start); k++) {
            if (endNode.next != null) {
                endNode = endNode.next;
            } else {
                break;
            }
        }

        // 3. afterEnd, detach [startNode..endNode]
        Node afterEnd = endNode.next;
        endNode.next = null;

        // 4. Reverse detached block
        Node reversedHead = reverseInPlace(startNode);
        Node tail = startNode;  // startNode is now tail of reversed block

        // 5. Reconnect: reversed block -> prefix -> suffix
        if (start == 0) {
            // No prefix, just [reversed] + suffix
            dHead.next = reversedHead;
            tail.next = afterEnd;
        } else {
            Node prefixHead = originalHead;
            Node prefixTail = beforeNode;

            dHead.next = reversedHead;  // dummy -> reversed
            tail.next = prefixHead;     // tail of reversed -> prefix
            prefixTail.next = afterEnd; // prefix tail -> suffix
        }
    }

    // =========================================
    // getNode(head, idx) - 0-based among real nodes
    // head is dummy; head.next = index 0
    // =========================================
    public static Node getNode(Node head, int idx) {
        Node current = head.next; // index 0
        int pos = 0;
        while (current != null && pos < idx) {
            current = current.next;
            pos++;
        }
        return current; // may be null if idx invalid
    }

    // =========================================
    // rangeReverse3 - uses getNode + in-place reverse
    // =========================================
    public static void rangeReverse3(Node dHead, int start, int end) {

        Node beforeNode;
        if (start == 0) {
            beforeNode = dHead;
        } else {
            beforeNode = getNode(dHead, start - 1);
        }

        if (beforeNode == null) {
            return; // invalid start
        }

        Node startNode = beforeNode.next;
        if (startNode == null) {
            return; // start beyond list
        }

        Node prev = null;
        Node curr = startNode;
        int i = start;

        while (curr != null && i <= end) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            i++;
        }

        // prev = head of reversed sublist
        // curr = node after reversed
        // startNode = tail of reversed
        beforeNode.next = prev;
        startNode.next = curr;
    }

    // =========================================
    // get_size(head) - count real nodes (exclude dummy)
    // =========================================
    public static int getSize(Node head) {
        if (head.next == null) {
            return 0;
        }
        int count = 0;
        Node current = head.next; // first real node
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // =========================================
    // rangeReverse4 - uses getNode + getSize,
    // reversal via for loop with known length
    // =========================================
    public static void rangeReverse4(Node dHead, int start, int end) {
        int size = getSize(dHead);

        if (start >= size) {
            return; // nothing to reverse
        }

        if (end >= size) {
            end = size - 1;
        }

        if (start >= end) {
            return;
        }

        Node beforeNode;
        if (start == 0) {
            beforeNode = dHead;
        } else {
            beforeNode = getNode(dHead, start - 1);
        }

        Node startNode = beforeNode.next;

        Node prev = null;
        Node curr = startNode;

        int steps = end - start + 1;
        for (int k = 0; k < steps; k++) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        // Reconnect
        beforeNode.next = prev;   // prefix -> reversed
        startNode.next = curr;    // tail -> suffix
    }

    // =========================================
    // rangeReverse5 - uses getNode, getSize, reverseInPlace
    // =========================================
    public static void rangeReverse5(Node dHead, int start, int end) {
        int size = getSize(dHead);

        if (start >= size) {
            return;
        }

        if (end >= size) {
            end = size - 1;
        }

        if (start >= end) {
            return;
        }

        Node beforeStart;
        if (start == 0) {
            beforeStart = dHead;
        } else {
            beforeStart = getNode(dHead, start - 1);
        }

        Node startNode = beforeStart.next;

        Node endNode = getNode(dHead, end);
        Node afterEnd = endNode.next;

        // Detach segment
        endNode.next = null;

        // Reverse isolated [startNode..endNode]
        Node reversedHead = reverseInPlace(startNode);

        // Reattach: prefix -> reversed -> suffix
        beforeStart.next = reversedHead;
        startNode.next = afterEnd;
    }
    
    
        // =========================================
    // rangeReverse6 - prepend logic
    // keep pulling n.next and inserting after dHead
    // =========================================
    public static void rangeReverse6(Node dHead, int start, int end) {
        Node n = dHead;
        int i = 0;

        // Move n so that it is the node BEFORE index 'start'
        while (i != start && n.next != null) {
            n = n.next;
            i++;
        }

        // Now repeatedly move n.next right after dHead
        while (i != end + 1 && n.next != null) {
            Node temp = n.next.next;   // node after the one we move

            // Insert n.next right after dummy head
            n.next.next = dHead.next;
            dHead.next = n.next;

            // Fix link after n
            n.next = temp;

            i++;
        }
    }

    
    

    // =========================================
    // createList from array (no dummy here)
    // =========================================
    public static Node createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    // =========================================
    // printList
    // =========================================
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.elem + " -> ");
            } else {
                System.out.print(temp.elem);
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // =========================================
    // Test helper 
    // =========================================
    public static void testRangeReverse(int version, String name) {
        System.out.println("\n==============================");
        System.out.println("Testing " + name);
        System.out.println("==============================");

        // EXAMPLE 1
        System.out.println("===== EXAMPLE 1 =====");
        int[] arr1 = {3, 5, 8, 7, 2, 1, 6, 4, 2};
        Node dHead1 = new Node(-999);
        dHead1.next = createList(arr1);

        System.out.println("Original:");
        printList(dHead1.next);

        if (version == 1) {
            rangeReverse1(dHead1, 2, 5);
        } else if (version == 2) {
            rangeReverse2(dHead1, 2, 5);
        } else if (version == 3) {
            rangeReverse3(dHead1, 2, 5);
        } else if (version == 4) {
            rangeReverse4(dHead1, 2, 5);
        } else if (version == 5) {
            rangeReverse5(dHead1, 2, 5);
        } else if (version == 6) {
            rangeReverse6(dHead1, 2, 5);
        }

        System.out.println("Modified:");
        printList(dHead1.next);

        // EXAMPLE 2
        System.out.println("\n===== EXAMPLE 2 =====");
        int[] arr2 = {3, 5, 8, 7, 2, 1, 6, 4, 5};
        Node dHead2 = new Node(-999);
        dHead2.next = createList(arr2);

        System.out.println("Original:");
        printList(dHead2.next);

        if (version == 1) {
            rangeReverse1(dHead2, 4, 12);
        } else if (version == 2) {
            rangeReverse2(dHead2, 4, 12);
        } else if (version == 3) {
            rangeReverse3(dHead2, 4, 12);
        } else if (version == 4) {
            rangeReverse4(dHead2, 4, 12);
        } else if (version == 5) {
            rangeReverse5(dHead2, 4, 12);
        } else if (version == 6) {
            rangeReverse6(dHead2, 4, 12);
        }

        System.out.println("Modified:");
        printList(dHead2.next);
    }

    // =========================================
    // main - run all versions 
    // =========================================
    public static void main(String[] args) {
        testRangeReverse(1, "rangeReverse1 (ReverseInPlace + move-to-front)");
        testRangeReverse(2, "rangeReverse2 (basic in-place reverse)");
        testRangeReverse(3, "rangeReverse3 (using getNode)");
        testRangeReverse(4, "rangeReverse4 (using getNode + getSize)");
        testRangeReverse(5, "rangeReverse5 (getNode + getSize + reverseInPlace)");
        testRangeReverse(6, "rangeReverse6 (prepend/move-to-front logic)");
    }
}