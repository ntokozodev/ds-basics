package dev.ntokozos.dsbasics.stack;

import java.util.EmptyStackException;

import dev.ntokozos.dsbasics.common.SinglyNode;

public class ListStack<T> implements BasicStack<T> {
    private SinglyNode<T> top;
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
        SinglyNode<T> newElement = new SinglyNode<>(element);
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

        SinglyNode<T> pop = top;
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
