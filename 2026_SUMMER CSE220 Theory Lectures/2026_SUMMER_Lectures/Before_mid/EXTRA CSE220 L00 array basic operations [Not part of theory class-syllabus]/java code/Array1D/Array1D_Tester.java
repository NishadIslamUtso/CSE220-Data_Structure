public class Array1D_Tester {
    public static void main(String[] args) {
        int[] initialArray = {10, 20, 30, 40, 50, 0, 0, 0};
        Array1D_Necessary_Methods arrOps = new Array1D_Necessary_Methods(initialArray);

        System.out.println("Original Array:");
        arrOps.printForLoop();

        System.out.println("\nShift Left:");
        arrOps.shiftLeft();
        arrOps.printForLoop();

        System.out.println("\nRotate Left:");
        arrOps.rotateLeft();
        arrOps.printForLoop();

        System.out.println("\nShift Right:");
        arrOps.shiftRight();
        arrOps.printForLoop();

        System.out.println("\nRotate Right:");
        arrOps.rotateRight();
        arrOps.printForLoop();

        System.out.println("\nReverse Out of Place:");
        int[] reversed = arrOps.reverseOutOfPlace();
        for (int val : reversed) System.out.print(val + " ");
        System.out.println();

        System.out.println("\nReverse In Place:");
        arrOps.reverseInPlace();
        arrOps.printForLoop();

        System.out.println("\nResize with constant increment (+2):");
        arrOps.resizeArrayWithConstantIncrement(2);
        arrOps.printForLoop();

        System.out.println("\nInsert 99 at index 2:");
        int size = arrOps.getSize();
        arrOps.insertAnywhere(size, 2, 99);
        arrOps.printForLoop();

        System.out.println("\nDelete element at index 3:");
        size = arrOps.getSize();
        arrOps.deleteAnyElement(size, 3);
        arrOps.printForLoop();

        System.out.println("\nShift Left by 2:");
        arrOps.shiftLeftMultiple(2);
        arrOps.printForLoop();

        System.out.println("\nShift Right by 2:");
        arrOps.shiftRightMultiple(2);
        arrOps.printForLoop();

        System.out.println("\nPrint non-dummy values (size):");
        size = arrOps.getSize();
        arrOps.printNonDummies(size);

        System.out.println("\nCopy Array:");
        int[] copied = arrOps.copyArray();
        for (int val : copied) System.out.print(val + " ");
        System.out.println();
    }
}
