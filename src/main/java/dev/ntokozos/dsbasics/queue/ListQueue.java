package dev.ntokozos.dsbasics.queue;

import java.util.NoSuchElementException;

import dev.ntokozos.dsbasics.common.BasicNode;

public class ListQueue<T> implements BasicQueue<T> {

    private BasicNode<T> first;
    private BasicNode<T> last;
    private int size = 0;

    public ListQueue() {
    }

    public ListQueue(T seed) {
        if (seed != null) {
            BasicNode<T> newElementNode = new BasicNode<>(seed);
            first = newElementNode;
            last = newElementNode;
            size++;
        }
    }

    @Override
    public void add(T element) {
        BasicNode<T> newElementNode = new BasicNode<>(element);

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

        BasicNode<T> remove = first;
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
