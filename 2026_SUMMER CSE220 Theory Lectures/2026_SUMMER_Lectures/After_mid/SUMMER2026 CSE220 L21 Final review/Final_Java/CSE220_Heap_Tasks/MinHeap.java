class MinHeap {
    int[] heap;
    int size;

    public MinHeap(int capacity) {
        heap = new int[capacity + 1]; // 1-based index
        size = 0;
    }

    private int left(int i) { return 2 * i; }
    private int right(int i) { return 2 * i + 1; }
    private int parent(int i) { return i / 2; }

    public void insert(int key) {
        if (size >= heap.length - 1) return;
        heap[++size] = Integer.MAX_VALUE;
        decreaseKey(size, key);
    }
    
    public int getSize() { return size; } 

    public void decreaseKey(int i, int key) {
        if (key > heap[i]) return;
        heap[i] = key;
        while (i > 1 && heap[parent(i)] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    public int extractMin() {
        if (size < 1) return -1;
        int min = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return min;
    }

    private void minHeapify(int i) {
        int l = left(i), r = right(i), smallest = i;
        if (l <= size && heap[l] < heap[smallest]) smallest = l;
        if (r <= size && heap[r] < heap[smallest]) smallest = r;
        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }
}