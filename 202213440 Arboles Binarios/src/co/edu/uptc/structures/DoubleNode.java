package co.edu.uptc.structures;

public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> left;
    private DoubleNode<T> right;
    private int balanceFactor;

    public DoubleNode(T data) {
        this.data = data;
        this.balanceFactor = 0;
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

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public String toString() {
        return data + " -> " + left;
    }

}
