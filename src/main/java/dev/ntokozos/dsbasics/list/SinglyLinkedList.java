package dev.ntokozos.dsbasics.list;

import dev.ntokozos.dsbasics.common.BasicNode;

public class SinglyLinkedList<T> implements BasicList<T> {
    private BasicNode<T> head;
    private BasicNode<T> tail;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T seed) {
        if (seed != null) {
            BasicNode<T> seedNode = new BasicNode<T>(seed);
            tail = seedNode;
            head = seedNode;
            size++;
        }
    }

    @Override
    public void insertFront(T data) {
        BasicNode<T> newNode = new BasicNode<T>(data);
        newNode.setNext(head);

        if (isEmpty()) {
            tail = newNode;
        }

        head = newNode;
        size++;
    }

    @Override
    public void insertBack(T data) {
        BasicNode<T> newNode = new BasicNode<T>(data);

        if (isEmpty()) {
            head = newNode;
        } else {
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

        T deleted = head.getData();
        head = head.getNext();
        size--;

        return deleted;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        if (size == 1) {
            T deleted = head.getData();
            head = null;
            tail = null;
            size--;

            return deleted;
        }

        BasicNode<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        T deleted = current.getNext().getData();
        current.setNext(null);
        tail = current;
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

        BasicNode<T> current = head.getNext();
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    /**
     * A naive print it will only work with primitive types
     */
    public void printPrimitiveDataTypes() {
        BasicNode<T> current = head;
        System.out.print("Head -> ");

        while (current != null) {
            System.out.print(current.getData());
            System.out.print(" -> ");
            current = current.getNext();
        }

        System.out.println("null");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
