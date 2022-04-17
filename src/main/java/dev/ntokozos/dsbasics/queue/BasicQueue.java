package dev.ntokozos.dsbasics.queue;

public interface BasicQueue<E> {
    /**
     * Inserts an element at the end of this queue.
     */
    void add(E element);

    /**
     * Retrieves and removes the first element of this queue.
     */
    E remove();

    /**
     * Retrieves the first element of this queue.
     * 
     * @throws EmptyQueueException if queue is empty.
     */
    E peek();
}
