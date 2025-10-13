import java.util.*;

public class MaxHeapImplementation {
    public static void main(String args[]) {
        MaxHeapImplementation maxHeap = new MaxHeapImplementation(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.printHeap();
        System.out.println("Extracted Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }

    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeapImplementation(int capacity) {
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

        while (current > 0 && heap[current] >heap[parent(current)]) {
            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;
            current = parent(current);
        }
    }

    public int extractMax() {
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
        int largest = i;
        int l = left(i);
        int r = right(i);
        if (l < size && heap[l] > heap[largest])
            largest = l;
        if (r < size && heap[r] > heap[largest])
            largest = r;

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapifyDown(largest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}