package co.edu.uptc.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree<T> {
    private DoubleNode<T> root;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            insert(value, root);
        }
    }

    private void insert(T value, DoubleNode<T> node) {
        if (comparator.compare(node.getData(), value) == 0) {
            return;
        }
    
        if (comparator.compare(node.getData(), value) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new DoubleNode<>(value));
            } else {
                insert(value, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new DoubleNode<>(value));
            } else {
                insert(value, node.getRight());
            }
        }
    }

    public boolean exist(T value) {
        return exist(value, root);
    }

    public boolean exist(T value, DoubleNode<T> node) {
        if (node == null) {
            return false;
        }

        if (comparator.compare(node.getData(), value) == 0) {
            return true;
        }

        if (comparator.compare(node.getData(), value) > 0) {
            return exist(value, node.getLeft());
        } else {
            return exist(value, node.getRight());
        }
    }

    public T search(T value) {
        return search(value, root);
    }

    public T search(T value, DoubleNode<T> node) {
        if (node == null) {
            return null;
        }

        if (comparator.compare(node.getData(), value) == 0) {
            return node.getData();
        }

        if (comparator.compare(node.getData(), value) > 0) {
            return search(value, node.getLeft());
        } else {
            return search(value, node.getRight());
        }
    }

    public List<T> preOrder() {
        return preOrder(root);
    }

    public List<T> preOrder(DoubleNode<T> node) {
        List<T> list = new ArrayList<>();
        if (node != null) {
            list.add(node.getData());
            list.addAll(preOrder(node.getLeft()));
            list.addAll(preOrder(node.getRight()));
        }
        return list;
    }

    public List<T> inOrder() {
        return inOrder(root);
    }

    public List<T> inOrder(DoubleNode<T> node) {
        List<T> list = new ArrayList<>();
        if (node != null) {
            list.addAll(inOrder(node.getLeft()));
            list.add(node.getData());
            list.addAll(inOrder(node.getRight()));
        }
        return list;
    }

    public List<T> postOrder() {
        return postOrder(root);
    }

    public List<T> postOrder(DoubleNode<T> node) {
        List<T> list = new ArrayList<>();
        if (node != null) {
            list.addAll(postOrder(node.getLeft()));
            list.addAll(postOrder(node.getRight()));
            list.add(node.getData());
        }
        return list;
    }

    public void remove(T value) {
        root = remove(value, root);
    }

    public DoubleNode<T> remove(T value, DoubleNode<T> node) {
        DoubleNode<T> aux = node;
        if (node == null) {
            throw new IllegalArgumentException("El valor no exíste en el arbol");
        }

        if (comparator.compare(node.getData(), value) == 0) {
            if (node.getLeft() == null && node.getRight() == null) {
                aux = null;
            } else if (node.getLeft() == null) {
                aux = node.getRight();
            } else if (node.getRight() == null) {
                aux = node.getLeft();
            } else {
                T smallestValue = findSmallestValue(node.getRight());
                node.setData(smallestValue);
                node.setRight(remove(smallestValue, node.getRight()));
            }
            
        } else if (comparator.compare(node.getData(), value) > 0) {
            DoubleNode<T> left = remove(value, node.getLeft());
            node.setLeft(left);
        } else {
            DoubleNode<T> right = remove(value, node.getRight());
            node.setRight(right);
        }
        return aux;
    }
    

    private T findSmallestValue(DoubleNode<T> node) {
        T smallestValue = node.getData();
        if (node.getLeft() != null) {
            smallestValue = findSmallestValue(node.getLeft());
        }
        return smallestValue;
    }
}
