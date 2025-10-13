import java.util.*;

public class MinHeapImplementation {
    public static void main(String args[]) {
        MinHeapImplementation minHeap = new MinHeapImplementation(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.printHeap();
        System.out.println("Extracted Min: " + minHeap.extractMin());
        minHeap.printHeap();
    }

    private int[] heap;
    private int size;
    private int capacity;

    public MinHeapImplementation(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return (2 * i + 1);
    }

    private int right(int i) {
        return (2 * i + 2);
    }

    public void insert(int x) {
        if (size == capacity) {
            System.out.println("Heap is full..");
            return;
        }
        heap[size] = x;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)]) {
            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;
        if (size == 1)
            return heap[--size];

        int root = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return root;
    }

    public void heapifyDown(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);
        if (l < size && heap[l] < heap[smallest])
            smallest = l;
        if (r < size && heap[r] < heap[smallest])
            smallest = r;

        if (smallest != i) {
            int temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(smallest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}