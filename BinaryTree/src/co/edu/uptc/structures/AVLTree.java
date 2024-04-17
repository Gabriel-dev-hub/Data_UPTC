package co.edu.uptc.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AVLTree<T> {
    private DoubleNode<T> root;
    private Comparator<T> comparator;

    public AVLTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T value) throws Exception {
        Logical logical = new Logical(false);
        root = insert(value, root, logical);
    }

    private DoubleNode<T> insert(T value, DoubleNode<T> node, Logical logical) throws Exception{
        DoubleNode<T> n1;

        if (node == null) {
            node = new DoubleNode<>(value);
            logical.setValue(true);;
        } else

        if (comparator.compare(node.getData(), value) == 0) {
            throw new Exception("El valor ya existe en el arbol");
        }

        if (comparator.compare(node.getData(), value) > 0) {
            DoubleNode<T> left;
            left = insert(value, node.getLeft(), logical);
            node.setLeft(left);
            if (logical.booleanValue()) {
                switch (node.getBalanceFactor()) {
                    case 1:
                        node.setBalanceFactor(0);
                        logical.setValue(false);
                        break;
                    case 0:
                        node.setBalanceFactor(-1);
                        break;
                    case -1:
                        n1 = node.getLeft();
                        if (n1.getBalanceFactor() == -1) {
                            node = rotateLeftInLeft(node, n1);
                        } else {
                            node = rotateRightInLeft(node, n1);
                        }
                        logical.setValue(false);
                        break;
                }
            }
        } else if (comparator.compare(node.getData(), value) < 0) {
            DoubleNode<T> right;
            right = insert(value, node.getRight(), logical);
            node.setRight(right);
            if (logical.booleanValue()) {
                switch (node.getBalanceFactor()) {
                    case 1:
                        n1 = node.getRight();
                        if (n1.getBalanceFactor() == 1) {
                            node = rotateRightInRight(node, n1);
                        } else {
                            node = rotateLeftInRight(node, n1);
                        }
                        logical.setValue(false);
                        break;
                    case 0:
                        node.setBalanceFactor(1);
                        break;
                    case -1:
                        node.setBalanceFactor(0);
                        logical.setValue(false);
                        break;
                }
            }
        }
        return node;
    }

    private DoubleNode<T> rotateLeftInLeft(DoubleNode<T> node, DoubleNode<T> node1) {
        node.setLeft(node1.getRight());
        node1.setRight(node);
        if (node1.getBalanceFactor() == -1) {
            node.setBalanceFactor(0);
            node1.setBalanceFactor(0);
        } else {
            node.setBalanceFactor(-1);
            node1.setBalanceFactor(1);
        }
        return node1;
    }

    private DoubleNode<T> rotateRightInLeft(DoubleNode<T> node, DoubleNode<T> node1) {
        DoubleNode<T> node2 = node1.getRight();
        node.setLeft(node2.getRight());
        node2.setRight(node);
        node1.setRight(node2.getLeft());
        node2.setLeft(node1);
        if (node2.getBalanceFactor() == 1) {
            node1.setBalanceFactor(-1);
        } else {
            node1.setBalanceFactor(0);
        }
        if (node2.getBalanceFactor() == -1) {
            node.setBalanceFactor(1);
        } else {
            node.setBalanceFactor(0);
        }
        node2.setBalanceFactor(0);
        return node2;
    }

    private DoubleNode<T> rotateRightInRight(DoubleNode<T> node, DoubleNode<T> node1) {
        node.setRight(node1.getLeft());
        node1.setLeft(node);
        if (node1.getBalanceFactor() == 1) {
            node.setBalanceFactor(0);
            node1.setBalanceFactor(0);
        } else {
            node.setBalanceFactor(1);
            node1.setBalanceFactor(-1);
        }
        return node1;
    }

    private DoubleNode<T> rotateLeftInRight(DoubleNode<T> node, DoubleNode<T> node1) {
        DoubleNode<T> node2 = node1.getLeft();
        node.setRight(node2.getLeft());
        node2.setLeft(node);
        node1.setLeft(node2.getRight());
        node2.setRight(node1);
        if (node2.getBalanceFactor() == 1) {
            node.setBalanceFactor(-1);
        } else {
            node.setBalanceFactor(0);
        }
        if (node2.getBalanceFactor() == -1) {
            node1.setBalanceFactor(1);
        } else {
            node1.setBalanceFactor(0);
        }
        node2.setBalanceFactor(0);
        return node2;
    }

    public boolean exist(T value) {
        return exist(value, root);
    }

    private boolean exist(T value, DoubleNode<T> node) {
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

    private T search(T value, DoubleNode<T> node) {
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

    private List<T> preOrder(DoubleNode<T> node) {
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

    private List<T> inOrder(DoubleNode<T> node) {
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

    private List<T> postOrder(DoubleNode<T> node) {
        List<T> list = new ArrayList<>();
        if (node != null) {
            list.addAll(postOrder(node.getLeft()));
            list.addAll(postOrder(node.getRight()));
            list.add(node.getData());
        }
        return list;
    }

    public void remove(T value) throws Exception{
        Logical logical = new Logical(false);
        root = remove(value, root, logical);
    }

    private DoubleNode<T> remove(T value, DoubleNode<T> node, Logical changeHeigh) throws Exception{
        if (node == null) {
            throw new Exception("El valor no exíste en el arbol");
        }
        else if (comparator.compare(node.getData(), value) > 0) {
            DoubleNode<T> left = remove(value, node.getLeft(), changeHeigh);
            node.setLeft(left);
            if (changeHeigh.booleanValue()) {
                node = balanceRight(node, changeHeigh);
            }
        } 
        else if (comparator.compare(node.getData(), value) < 0) {
            DoubleNode<T> right = remove(value, node.getRight(), changeHeigh);
            node.setRight(right);
            if (changeHeigh.booleanValue()) {
                node = balanceLeft(node, changeHeigh);
            }
        }

        else {
            DoubleNode<T> aux = node.getLeft();
            aux = node;
            if (aux.getLeft() == null) {
                node = aux.getRight();
                changeHeigh.setValue(true);
            } else if (aux.getRight() == null) {
                node = aux.getLeft();
                changeHeigh.setValue(true);
            } else {
                DoubleNode<T> left = replace(node, node.getLeft(), changeHeigh);
                node.setLeft(left);
                if (changeHeigh.booleanValue()) {
                    node = balanceRight(node, changeHeigh);
                }
            }
            aux = null;
        }
        return node;
    }

    private DoubleNode<T> balanceRight(DoubleNode<T> node, Logical changeHeigh) {
        DoubleNode<T> n1;
        switch (node.getBalanceFactor()) {
            case -1:
                node.setBalanceFactor(0);
                break;
            case 0:
                node.setBalanceFactor(1);
                changeHeigh.setValue(false);
                break;
            case 1:
                n1 = node.getRight();
                if (n1.getBalanceFactor() >= 0) {
                    if (n1.getBalanceFactor() == 0) {
                        changeHeigh.setValue(false);
                    }
                    node = rotateRightInRight(node, n1);
                } else {
                    node = rotateLeftInRight(node, n1);
                }
                break;
        }
        return node;
    }

    private DoubleNode<T> balanceLeft(DoubleNode<T> node, Logical changeHeigh) {
        DoubleNode<T> n1;
        switch (node.getBalanceFactor()) {
            case -1:
                n1 = node.getLeft();
                if (n1.getBalanceFactor() <= 0) {
                    if (n1.getBalanceFactor() == 0) {
                        changeHeigh.setValue(false);
                    }
                    node = rotateLeftInLeft(node, n1);
                } else {
                    node = rotateRightInLeft(node, n1);
                }
                break;
            case 0:
                node.setBalanceFactor(-1);
                changeHeigh.setValue(false);
                break;
            case 1:
                node.setBalanceFactor(0);
                break;
        }
        return node;
    }

    private DoubleNode<T> replace(DoubleNode<T> node, DoubleNode<T> actual, Logical changeHeigh) {
        if (actual.getRight() != null) {
            DoubleNode<T> right = replace(node, actual.getRight(), changeHeigh);
            actual.setRight(right);
            if (changeHeigh.booleanValue()) {
                actual = balanceLeft(actual, changeHeigh);
            }
        }
        else {
            node.setData(actual.getData());
            node = actual;
            actual = actual.getLeft();
            node = null;
            changeHeigh.setValue(true);
        }
        return actual;
    }
}
