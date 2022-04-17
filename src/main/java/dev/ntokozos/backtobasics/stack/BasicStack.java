package dev.ntokozos.backtobasics.stack;

public interface BasicStack<E> {
    /**
     * Inserts an element as the top element of this stack.
     */
    void push(E element);

    /**
     * Retrieves and removes the top element of this stack.
     * 
     * @throws EmptyStackException if stack is empty.
     */
    E pop();

    /**
     * Retrieves the top element of this stack.
     * 
     * @throws EmptyStackException if stack is empty.
     */
    E peek();
}
