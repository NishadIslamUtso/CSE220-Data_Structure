public class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new int[capacity + 1]; // 1-based indexing
        size = 0;
    }

    private int getLeftChildIndex(int idx) {
        return 2 * idx;
    }

    private int getRightChildIndex(int idx) {
        return 2 * idx + 1;
    }

    private int getParentIndex(int idx) {
        return idx / 2;
    }

    private void minHeapify(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        int smallest = index;

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }

    public void heapDecreaseKey(int idx, int key) {
        if (key > heap[idx]) {
            System.out.println("New key is larger than current key. Cannot insert.");
            return;
        }

        heap[idx] = key;
        while (idx > 1 && heap[getParentIndex(idx)] > heap[idx]) {
            int parentIdx = getParentIndex(idx);
            int temp = heap[idx];
            heap[idx] = heap[parentIdx];
            heap[parentIdx] = temp;
            idx = parentIdx;
        }
    }

    public void minHeapInsert(int key) {
        if (size >= heap.length - 1) {
            System.out.println("No Space Left for " + key);
            return;
        }

        size++;
        heap[size] = Integer.MAX_VALUE; // Initially +infinity
        heapDecreaseKey(size, key);
    }

    public Integer deleteMin() {
        if (size < 1) {
            return null;
        }
        int minValue = heap[1];
        heap[1] = heap[size];
        size--;
        minHeapify(1);
        return minValue;
    }

    public void buildMinHeap() {
        for (int i = size / 2; i >= 1; i--) {
            minHeapify(i);
        }
    }

    public void printHeap() {
        System.out.print("Heap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        Object[][] operations = {
            {"insert", 30},
            {"insert", 20},
            {"insert", 40},
            {"insert", 10},
            {"delete"},
            {"insert", 5},
            {"delete"},
            {"build"}
        };

        for (int i = 0; i < operations.length; i++) {
            Object[] operation = operations[i];
            String opType = operation[0].toString();
        
            if (opType.equals("insert")) {
                int val = (int) operation[1];
                minHeap.minHeapInsert(val);
                System.out.print("Inserted " + val + ": ");
                minHeap.printHeap();
            } else if (opType.equals("delete")) {
                Integer minVal = minHeap.deleteMin();
                System.out.print("Deleted min value " + minVal + ": ");
                minHeap.printHeap();
            } else if (opType.equals("build")) {
                minHeap.buildMinHeap();
                System.out.print("Built min heap: ");
                minHeap.printHeap();
            } else {
                System.out.println("Unknown operation!");
            }
        }

    }
}
