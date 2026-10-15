public class Q4Heap {

    // evenMax(heap):
    // Keeps only even elements in a new MaxHeap
    // Counts discarded odd elements
    public static MaxHeap evenMax(MaxHeap heap) {

        MaxHeap evenHeap = new MaxHeap(heap.getSize());

        int discarded = 0;
        while (heap.getSize() > 0) {

            int value = heap.extractMax();
            if (value % 2 == 0) {
                evenHeap.insert(value);
            }
            else {
                discarded++;
            }
        }
        System.out.println("Discarded elements: " + discarded);

        while (evenHeap.getSize() > 0) {
                heap.insert(evenHeap.extractMax(););
        }

     return heap;
    }



    // Helper method for printing heap
    // Uses temporary heap to restore elements
    static void printHeap(MaxHeap heap) {

        MaxHeap temp = new MaxHeap(heap.size);

        System.out.print("[X");

        while (heap.size > 0) {

            int value = heap.extractMax();

            System.out.print(", " + value);

            temp.insert(value);
        }

        System.out.println("]");

        // Restore original heap
        while (temp.size > 0) {
            heap.insert(temp.extractMax());
        }
    }


    public static void main(String[] args) {

        // ================= Sample 1 =================

        MaxHeap heap1 = new MaxHeap(7);

        heap1.insert(15);
        heap1.insert(8);
        heap1.insert(10);
        heap1.insert(6);
        heap1.insert(7);
        heap1.insert(3);
        heap1.insert(2);

        System.out.print("MaxHeap: ");
        printHeap(heap1);

        MaxHeap result1 = evenMax(heap1);

        System.out.print("New MaxHeap: ");
        printHeap(result1);

        System.out.println("A total of 3 odd numbers were extracted from the heap.");

        System.out.println("\n=================================\n");


        // ================= Sample 2 =================

        MaxHeap heap2 = new MaxHeap(5);

        heap2.insert(20);
        heap2.insert(14);
        heap2.insert(8);
        heap2.insert(6);
        heap2.insert(2);

        System.out.print("MaxHeap: ");
        printHeap(heap2);

        MaxHeap result2 = evenMax(heap2);

        System.out.print("New MaxHeap: ");
        printHeap(result2);

        System.out.println("All elements are even, so none are removed.");

        System.out.println("\n=================================\n");


        // ================= Sample 3 =================

        MaxHeap heap3 = new MaxHeap(5);

        heap3.insert(19);
        heap3.insert(15);
        heap3.insert(11);
        heap3.insert(7);
        heap3.insert(3);

        System.out.print("MaxHeap: ");
        printHeap(heap3);

        MaxHeap result3 = evenMax(heap3);

        System.out.print("New MaxHeap: ");
        printHeap(result3);

        System.out.println("All elements are odd, so all are discarded, resulting in an empty heap.");
    }
}