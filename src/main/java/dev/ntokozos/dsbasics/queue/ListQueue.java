package dev.ntokozos.dsbasics.queue;

import java.util.NoSuchElementException;

import dev.ntokozos.dsbasics.common.SinglyNode;

public class ListQueue<T> implements BasicQueue<T> {

    private SinglyNode<T> first;
    private SinglyNode<T> last;
    private int size = 0;

    public ListQueue() {
    }

    public ListQueue(T seed) {
        if (seed != null) {
            SinglyNode<T> newElementNode = new SinglyNode<>(seed);
            first = newElementNode;
            last = newElementNode;
            size++;
        }
    }

    @Override
    public void add(T element) {
        SinglyNode<T> newElementNode = new SinglyNode<>(element);

        if (isEmpty()) {
            first = newElementNode;
            last = newElementNode;
            size++;
            return;
        }

        last.setNext(newElementNode);
        last = newElementNode;
        size++;

    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        SinglyNode<T> remove = first;
        first = first.getNext();
        remove.setNext(null);
        size--;

        return remove.getData();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return first.getData();
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

}
