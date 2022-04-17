package dev.ntokozos.backtobasics.list;

public class DoublyLinkedList<T> implements BasicList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
    private int size = 0;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(T seed) {
        if (seed != null) {
            DoublyNode<T> seedNode = new DoublyNode<T>(seed);
            tail = seedNode;
            head = seedNode;
            size++;
        }
    }

    @Override
    public void insertFront(T data) {
        DoublyNode<T> newNode = new DoublyNode<T>(data);
        newNode.setNext(head);

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrevious(newNode);
        }

        head = newNode;
        size++;
    }

    @Override
    public void insertBack(T data) {
        DoublyNode<T> newNode = new DoublyNode<T>(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
        }

        tail = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (head.getNext() == null) {
            T deleted = head.getData();
            head = null;
            tail = null;
            size--;

            return deleted;
        }

        T deleted = head.getData();
        head = head.getNext();
        head.setPrevious(null);
        size--;

        return deleted;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (head.getNext() == null) {
            T deleted = head.getData();
            head = null;
            tail = null;
            size--;

            return deleted;
        }

        T deleted = tail.getData();
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;

        return deleted;
    }

    @Override
    public T peekFirst() {
        if (isEmpty()) {
            return null;
        }

        return head.getData();
    }

    @Override
    public T peekLast() {
        if (isEmpty()) {
            return null;
        }

        return tail.getData();
    }

    @Override
    public T peekAt(int index) {
        if (isEmpty()) {
            return null;
        }

        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            return head.getData();
        }

        if (index == size - 1) {
            return tail.getData();
        }

        DoublyNode<T> current = head.getNext();
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    /**
     * A naive print it will only work with primitive types
     */
    public void printPrimitiveDataTypes() {
        DoublyNode<T> current = head;
        System.out.print("Head -> ");

        while (current != null) {
            System.out.print(current.getData());
            System.out.print(" <=> ");
            current = current.getNext();
        }

        System.out.println("null");
    }

    public void printReverse() {
        DoublyNode<T> current = head;
        System.out.print("null");

        printRecursive(current);

        System.out.println(" <- Head");
    }

    private void printRecursive(DoublyNode<T> node) {
        if (node == null) {
            return;
        }

        printRecursive(node.getNext());

        System.out.print(" <=> ");
        System.out.print(node.getData());
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
