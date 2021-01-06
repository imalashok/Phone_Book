import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        MinHeap minHeap = new MinHeap(size);

        for (int i = 0; i < size; i++) {
            minHeap.insert(scanner.nextInt());
        }

        System.out.println(minHeap.getNumberOfSwaps());
    }
}

class MinHeap {
    private int[] heap;
    private int size;
    private int maxsize;
    private Map<Integer, Integer> numberOfSwaps = new HashMap<>();

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize + 1];
        heap[0] = Integer.MIN_VALUE;
    }

    private void swap(int fpos, int spos) {
        if (heap[fpos] != Integer.MIN_VALUE || heap[spos] != Integer.MIN_VALUE) {
            numberOfSwaps.replace(heap[fpos], numberOfSwaps.get(heap[fpos]) + 1);
            numberOfSwaps.replace(heap[spos], numberOfSwaps.get(heap[spos]) + 1);
        }
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
        numberOfSwaps.put(element, 0);
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

    public StringBuilder getNumberOfSwaps() {
        StringBuilder stringBuilder = new StringBuilder();

        for (var value : numberOfSwaps.values()) {
            stringBuilder.append(value).append(" ");
        }

        return stringBuilder;
    }
}