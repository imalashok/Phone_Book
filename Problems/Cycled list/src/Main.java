import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        int n = scanner.nextInt();
        int k = Integer.parseInt(scanner.nextLine().trim());

        String[] numbers = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            dll.addLast(Integer.parseInt(numbers[i]));
        }

        for (int j = 0; j < k; j++) {
            String[] command = scanner.nextLine().split(" ");
            dll.remove(command[0], Integer.parseInt(command[1]));
        }

        System.out.println(dll.toString());
    }
}


class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private Node<E> pointer;

    private int size;

    DoublyLinkedList() {
        size = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {

        Node<E> tmp = head;
        StringBuilder result = new StringBuilder();

        int i = size;

        while (i != 0) {
            result.append(tmp.value).append(" ");
            tmp = tmp.next;
            i--;
        }

        return result.toString();
    }

    void addFirst(E elem) {

        Node<E> tmp = new Node<>(elem, head, null);

        if (head != null) {
            head.prev = tmp;
        }

        head = tmp;

        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    void addLast(E elem) {

        Node<E> tmp = new Node<>(elem, null, tail);

        if (head == null) {
            head = tmp;
            tail = tmp;
            head.prev = head;
            head.next = head;
            pointer = head;
        }

        if (size > 0) {
            tail.next = tmp;
            tail = tmp;
            tail.next = head;
            head.prev = tail;
        }
        size++;
    }

    void add(E elem, Node<E> curr) {

        if (curr == null) {
            throw new NoSuchElementException();
        }

        Node<E> tmp = new Node<>(elem, curr, null);

        if (curr.prev != null) {
            curr.prev.next = tmp;
            tmp.prev = curr.prev;
            curr.prev = tmp;
        } else {
            curr.prev = tmp;
            tmp.next = curr;
            head = tmp;
        }
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
    }

    public void remove(Node<E> curr) {
        if (curr == null) {
            throw new NoSuchElementException();
        }

        if (curr.prev == null) {
            removeFirst();
            return;
        }
        if (curr.next == null) {
            removeLast();
            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }

    public void remove(String command, int step) {

        Node<E> curr = pointer;

        if (curr == null) {
            throw new NoSuchElementException();
        }

        if ("r".equals(command)) {
            for (int i = 0; i < step; i++) {
                curr = curr.next;
                pointer = curr.next;
                pointer.prev = curr.next.prev;
                pointer.next = curr.next.next;
            }
            pointer.prev = pointer.prev.prev;
        }

        if ("l".equals(command)) {
            for (int i = 0; i < step; i++) {
                curr = curr.prev;
                pointer = curr.prev;
                pointer.next = curr.prev.next;
                pointer.prev = curr.prev.prev;
            }
            pointer.next = pointer.next.next;
        }


        if (curr.equals(head)) {
            head = curr.next;
        }

        if (curr.equals(tail)) {
            tail = curr.prev;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;


        if (size == 0) {
            pointer = null;
        }
    }

    static class Node<E> {

        private final E value;
        private Node<E> next;
        private Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }

        Node<E> getNext() {
            return next;
        }

        Node<E> getPrev() {
            return prev;
        }
    }
}