class MaxHeap {
    int[] heap;
    int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity + 1]; // 1-based index
        size = 0;
    }

    private int left(int i) { return 2 * i; }
    private int right(int i) { return 2 * i + 1; }
    private int parent(int i) { return i / 2; }

    public void insert(int key) {
        if (size >= heap.length - 1) return;
        heap[++size] = Integer.MIN_VALUE;
        increaseKey(size, key);
    }

    public void increaseKey(int i, int key) {
        if (key < heap[i]) return;
        heap[i] = key;
        while (i > 1 && heap[parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    public int extractMax() {
        if (size < 1) return -1;
        int max = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return max;
    }

    private void maxHeapify(int i) {
        int l = left(i), r = right(i), largest = i;
        if (l <= size && heap[l] > heap[largest]) largest = l;
        if (r <= size && heap[r] > heap[largest]) largest = r;
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }
}