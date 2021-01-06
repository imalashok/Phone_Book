import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        MinHeap minHeap = new MinHeap(array);
        minHeap.minHeap();


        for (int j = 0; j < size; j++) {
            System.out.println(minHeap.toString());
            array[j] = minHeap.extractMin();
        }

        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }
    }
}

class MinHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    public MinHeap(int[] array) {
        this.maxsize = array.length;
        this.size = maxsize;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
        System.arraycopy(array, 0, heap, 1, array.length);
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (2 * pos == size) {
            if (heap[pos] > heap[2 * pos]) {
                swap(pos, 2 * pos);
                minHeapify(2 * pos);
            }
            return;
        }

        if (2 * pos <= size) {
            if (heap[pos] > heap[2 * pos] || heap[pos] > heap[2 * pos + 1]) {
                if (heap[2 * pos] < heap[2 * pos + 1]) {
                    swap(pos, 2 * pos);
                    minHeapify(2 * pos);
                }
                else {
                    swap(pos, 2 * pos + 1);
                    minHeapify(2 * pos + 1);
                }
            }
        }
    }

    public void insert(int element) {
        heap[++size] = element;
        int current = size;

        while (heap[current] < heap[current / 2]) {
            swap(current, current / 2);
            current = current / 2;
        }
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int extractMin() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int popped = heap[1];
        heap[1] = heap[size--];
        minHeapify(1);
        return popped;
    }

    public int getHeapDepth() {

        return (int)(Math.log(size) / Math.log(2));
    }


    public int[] getHeap() {
        return heap;
    }

    @Override
    public String toString() {

        StringBuilder elements = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            elements.append(" ").append(heap[i]);
        }

        return elements.toString().trim();
    }
}