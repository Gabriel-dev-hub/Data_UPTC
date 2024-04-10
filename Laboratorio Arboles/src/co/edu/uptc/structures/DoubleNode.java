package co.edu.uptc.structures;

public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> left;
    private DoubleNode<T> right;

    public DoubleNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getLeft() {
        return left;
    }

    public void setLeft(DoubleNode<T> left) {
        this.left = left;
    }

    public DoubleNode<T> getRight() {
        return right;
    }

    public void setRight(DoubleNode<T> right) {
        this.right = right;
    }

    public String toString() {
        return data + " -> " + left;
    }

}
