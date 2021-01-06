import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList<Character> dll = new DoublyLinkedList<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            dll.addLast(text.charAt(i));
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < n; j ++) {
            String[] command = scanner.nextLine().split(" ");

            if ("split".equals(command[0])) {
                dll.split(Integer.parseInt(command[1]));
            }

            if ("reverse".equals(command[0])) {
                dll.reverse();
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
            result.append(tmp.value);
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
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
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

    public void split(int index) {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        for (int i = 0; i < index; i++) {
            addLast(head.value);
            head = head.next;
            head.prev = null;
        }


    }

    public void reverse() {
        if (head == null) {
            throw new NoSuchElementException();
        }

        if (head != tail && tail != null) {
            Node<E> tmp = head;

            head = tail;
            head.next = head.prev;
            head.prev = null;

            tail = tmp;
            tail.prev = tail.next;
            tail.next = null;


            tmp = head;

            while (tmp.next.next != null) {
                tmp = tmp.next;

                Node<E> temp = tmp.next;
                tmp.next = tmp.prev;
                tmp.prev = temp;
            }
        }
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