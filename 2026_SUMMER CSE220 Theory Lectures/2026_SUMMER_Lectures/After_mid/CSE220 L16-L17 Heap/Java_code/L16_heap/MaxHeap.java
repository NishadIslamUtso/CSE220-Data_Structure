public class MaxHeap {
    private int[] heap;
    private int size;

    // Constructor
    public MaxHeap(int capacity) {
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

    private void maxHeapify(int index) {
        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);
        int largest = index;

        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void heapIncreaseKey(int idx, int key) {
        if (key < heap[idx]) {
            System.out.println("New key is smaller than current key. Cannot insert.");
            return;
        }

        heap[idx] = key;
        while (idx > 1 && heap[getParentIndex(idx)] < heap[idx]) {
            int parentIdx = getParentIndex(idx);
            int temp = heap[idx];
            heap[idx] = heap[parentIdx];
            heap[parentIdx] = temp;
            idx = parentIdx;
        }
    }

    public void maxHeapInsert(int key) {
        if (size >= heap.length - 1) {
            System.out.println("No Space Left for " + key);
            return;
        }

        size++;
        heap[size] = Integer.MIN_VALUE; // Initially -infinity
        heapIncreaseKey(size, key);
    }

    public Integer deleteMax() {
        if (size < 1) {
            return null;
        }
        int maxValue = heap[1];
        heap[1] = heap[size];
        size--;
        maxHeapify(1);
        return maxValue;
    }

    public void buildMaxHeap() {
        for (int i = size / 2; i >= 1; i--) {
            maxHeapify(i);
        }
    }

    public void printHeap() {
        System.out.print("Heap: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        Object[][] operations = {
            {"insert", 10},
            {"insert", 20},
            {"insert", 5},
            {"insert", 30},
            {"delete"},
            {"insert", 25},
            {"delete"},
            {"build"}
        };

        for (int i = 0; i < operations.length; i++) {
            Object[] operation = operations[i];
            String opType = operation[0].toString();

            if (opType.equals("insert")) {
                int value = (int) operation[1];
                maxHeap.maxHeapInsert(value);
                System.out.print("Inserted " + value + ": ");
                maxHeap.printHeap();
            } else if (opType.equals("delete")) {
                Integer maxVal = maxHeap.deleteMax();
                System.out.print("Deleted max value " + maxVal + ": ");
                maxHeap.printHeap();
            } else if (opType.equals("build")) {
                maxHeap.buildMaxHeap();
                System.out.print("Built max heap: ");
                maxHeap.printHeap();
            } else {
                System.out.println("Unknown operation!");
            }
        }
    }
}
