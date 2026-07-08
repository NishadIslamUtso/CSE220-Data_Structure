public class AssignmentTask7 {

    //SUBMIT ONLY THIS METHOD
    public static void rangeMove(DNode dh, int start, int end) {

        DNode curr=dh.next;
        DNode oldTail=dh.prev;
        
        while(curr!=oldTail){

            DNode x=curr;
            curr=curr.next;

            if((Integer)x.elem>=start && (Integer)x.elem<=end){
                DNode pre=x.prev;
                DNode suc=x.next;
                pre.next=suc;
                suc.prev=pre;
                x.prev=dh.prev;
                x.next=dh;
                dh.prev.next=x;
                dh.prev=x;
            }
        }

        if((Integer)curr.elem>=start && (Integer)curr.elem<=end){
            DNode pre=curr.prev;
            DNode suc=curr.next;
            pre.next=suc;
            suc.prev=pre;
            curr.prev=dh.prev;
            curr.next=dh;
            dh.prev.next=curr;
            dh.prev=curr;
        }

    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);
        
        //Running the Range Move with [5,7] range 
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
