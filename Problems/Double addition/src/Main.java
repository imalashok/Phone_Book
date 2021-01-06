import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();


        int n = scanner.nextInt();
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                dll.addLast(scanner.nextInt());
            }
        } else {
            dll.addLast(scanner.nextInt());
            dll.addLast(scanner.nextInt());

            for (int i = 0; i < n - 2; i++) {
                int nextElement = scanner.nextInt();
                if (Math.abs(nextElement - dll.getHead().getValue()) < Math.abs(nextElement - dll.getTail().getValue())) {
                    dll.addFirst(nextElement);
                } else {
                    dll.addLast(nextElement);
                }
            }
        }

        System.out.println(dll.toString());
    }
}

class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
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

        while (tmp != null) {
            result.append(tmp.value).append(" ");
            tmp = tmp.next;
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

        if (tail != null) {
            tail.next = tmp;
        }

        tail = tmp;

        if (head == null) {
            head = tmp;
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
        tail.next = null;
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


    static class Node<E> {

        private E value;
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

        E getValue() {
            return value;
        }
    }
}