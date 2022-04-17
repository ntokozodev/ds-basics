package dev.ntokozos.dsbasics.list;

public interface BasicList<E> {
    /**
     * Inserts the specified element at the beginning of this list.
     */
    void insertFront(E data);

    /**
     * Appends the specified element to the end of this list.
     */
    void insertBack(E data);

    /**
     * Retrieves and removes the first element of this list.
     */
    E removeFirst();

    /**
     * Retrieves and removes the last element of this list.
     */
    E removeLast();

    /**
     * Retrieves the first element of this list.
     */
    E peekFirst();

    /**
     * Retrieves the last element of this list.
     */
    E peekLast();

    /**
     * Retrieves the element at the specified position in this list.
     */
    E peekAt(int index);
}
