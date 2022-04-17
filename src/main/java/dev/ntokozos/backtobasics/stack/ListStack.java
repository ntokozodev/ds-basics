package dev.ntokozos.backtobasics.stack;

import java.util.EmptyStackException;

import dev.ntokozos.backtobasics.common.BasicNode;

public class ListStack<T> implements BasicStack<T> {
    private BasicNode<T> top;
    private int size = 0;

    public ListStack() {
    }

    public ListStack(T seed) {
        if (seed != null) {
            push(seed);
        }
    }

    @Override
    public void push(T element) {
        BasicNode<T> newElement = new BasicNode<>(element);
        if (isEmpty()) {
            top = newElement;
            size++;
            return;
        }

        newElement.setNext(top);
        top = newElement;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        BasicNode<T> pop = top;
        top = pop.getNext();
        pop.setNext(null);
        size--;

        return pop.getData();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.getData();
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return top == null;
    }

}
