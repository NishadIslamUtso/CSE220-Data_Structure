public class MergeByIntersection {

    public static NodeInt mergeLL(NodeInt headA, NodeInt headB) {
        if (headA == null || headB == null)
            return null;

        // Step 1: Find intersection node by comparing each node of A with B
        NodeInt intersectionNode = null;
        NodeInt currentA = headA;
        while (currentA != null && intersectionNode == null) {
            NodeInt currentB = headB;
            while (currentB != null) {
                if (currentA == currentB) {  // Reference equality
                    intersectionNode = currentA;
                    break;
                }
                currentB = currentB.next;
            }
            if (intersectionNode == null)
                currentA = currentA.next;
        }

        // Step 2: If no intersection found, return null
        if (intersectionNode == null)
            return null;

        // Step 3: Attach the unique part of headB before intersection to headA’s tail
        NodeInt tailA = headA;
        while (tailA.next != intersectionNode) {
            tailA = tailA.next;
        }

        // Connect tail of A to head of B
        tailA.next = headB;

        return headA;
    }

    // Utility: create linked list from int array
    public static NodeInt createList(int[] values) {
        if (values == null || values.length == 0)
            return null;
        NodeInt head = new NodeInt(values[0]);
        NodeInt current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new NodeInt(values[i]);
            current = current.next;
        }
        return head;
    }

    // Utility: get tail node
    public static NodeInt tailOf(NodeInt head) {
        if (head == null)
            return null;
        NodeInt temp = head;
        while (temp.next != null)
            temp = temp.next;
        return temp;
    }

    // Utility: force intersection (connect tail of A to given node in B)
    public static void makeIntersect(NodeInt headA, NodeInt nodeInB) {
        NodeInt tailA = tailOf(headA);
        if (tailA != null)
            tailA.next = nodeInB;
    }

    // Utility: print linked list
    public static void printList(NodeInt head) {
        NodeInt temp = head;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.value);
            temp = temp.next;
            if (temp != null)
                sb.append(" → ");
        }
        System.out.println(sb.toString());
    }

    // ===================== MAIN TEST =====================
    public static void main(String[] args) {
        // Create common tail: 62 → 17 → 89 → 24
        NodeInt commonTail = createList(new int[]{62, 17, 89, 24});

        // Create headA: 56 → 78 → 91 → commonTail
        NodeInt headA = createList(new int[]{56, 78, 91});
        makeIntersect(headA, commonTail);

        // Create headB: 43 → 33 → commonTail
        NodeInt headB = createList(new int[]{43, 33});
        makeIntersect(headB, commonTail);

        System.out.println("Before merge (intersecting):");
        System.out.print("List A: "); printList(headA);
        System.out.print("List B: "); printList(headB);

        NodeInt merged = mergeLL(headA, headB);
        System.out.println("\nAfter merge:");
        System.out.print("Merged : "); printList(merged);

        System.out.println("\n" + "-".repeat(50));

        // Non-intersecting example
        NodeInt headC = createList(new int[]{56, 78, 91, 17, 89, 24});
        NodeInt headD = createList(new int[]{43, 33, 36, 29});

        System.out.println("Non-intersecting lists:");
        System.out.print("List C: "); printList(headC);
        System.out.print("List D: "); printList(headD);

        NodeInt mergedNone = mergeLL(headC, headD);
        System.out.println("\nAfter merge (should be null): " + mergedNone);
    }
}
