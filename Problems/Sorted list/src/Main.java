import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");

            switch (command[0]) {
                case "add":
                    dynamicArray.add(Integer.parseInt(command[1]));
                    break;
                case "remove":
                    dynamicArray.remove(Integer.parseInt(command[1]));
                    break;
                case "size":
                    System.out.println(dynamicArray.size());
                    break;
                case "isempty":
                    System.out.println(dynamicArray.isEmpty());
                    break;
                case "contains":
                    System.out.println(dynamicArray.contains(Integer.parseInt(command[1])));
                    break;
                case "indexof":
                    System.out.println(dynamicArray.indexOf(Integer.parseInt(command[1])));
                    break;
                case "clear":
                    dynamicArray.clear();
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
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

        if (size == 0) {
            arr[size++] = value;
            return;
        }

        for (int i = 0; i < size; i++) {
            if ((Integer) arr[i] >= (Integer) value) {
                add(i, value);
                return;
            }
        }
        add(size, value);
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

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        for (Object elem : arr) {
            if (element.equals((E) elem)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (((E) element).equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int tmp = size;
        for (int i = 0; i < tmp; i++) {
            removeLast();
        }
    }
}