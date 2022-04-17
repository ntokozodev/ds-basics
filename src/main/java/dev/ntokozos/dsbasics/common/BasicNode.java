package dev.ntokozos.dsbasics.common;

public class BasicNode<T> {
    private T data;
    private BasicNode<T> next;

    public BasicNode(T data) {
        this.setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BasicNode<T> getNext() {
        return next;
    }

    public void setNext(BasicNode<T> next) {
        this.next = next;
    }
}
