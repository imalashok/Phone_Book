import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("add")) {
                dynamicArray.add(Integer.parseInt(command.split(" ")[1]));
            } else if (command.startsWith("remove")) {
                dynamicArray.removeLast();
            } else if (command.startsWith("size")) {
                System.out.println(dynamicArray.size());
            }
        }
    }
}

class DynamicArray<E> {
    private Object[] arr;
    private int size;

    private final int DEFAULT_CAPACITY = 10;
    private final double SCALING_FACTOR = 1.5;

    public DynamicArray() {
        this.arr = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity) {
        this.arr = new Object[initialCapacity > 0 ? initialCapacity : DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void tryIncrease() {
        if (arr.length == size) {
            arr = Arrays.copyOf(arr, (int) (arr.length * SCALING_FACTOR));
        }
    }

    public void add(E value) {
        tryIncrease();
        arr[size++] = value;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        tryIncrease();
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) arr[index];
        int moveCount = size - index - 1;
        if (moveCount > 0) {
            System.arraycopy(arr, index + 1, arr, index, moveCount);
        }
        arr[--size] = null;
        return oldValue;
    }

    public E removeLast() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        E oldValue = (E) arr[size - 1];
        arr[--size] = null;
        return oldValue;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) arr[index];
    }

    public int size() {
        return size;
    }
}