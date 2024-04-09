package co.edu.uptc.structures;

import java.util.Iterator;

public class DoubleList<T> implements Iterable<T>{
    private DoubleNode<T> head;

    public DoubleList() {
        head = null;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public void insert(T data) {
        DoubleNode<T> newNode = new DoubleNode<T>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            DoubleNode<T> aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
            newNode.setPrevious(aux);
        }
    }

    public boolean exists(T data) {
        boolean found = false;
        DoubleNode<T> aux = head;
        while (aux != null) {
            if (aux.getData().equals(data)) {
                found = true;
            }
            aux = aux.getNext();
        }
        return found;
    }

    public void remove(T data) {
        if (!isEmpty()) {
            if (head.getData().equals(data)) {
                head = head.getNext();
                if (head != null) {
                    head.setPrevious(null);
                }
            } else {
                DoubleNode<T> aux = head;
                while (aux.getNext() != null && !aux.getNext().getData().equals(data)) {
                    aux = aux.getNext();
                }
                if (aux.getNext() != null) {
                    aux.setNext(aux.getNext().getNext());
                    if (aux.getNext() != null) {
                        aux.getNext().setPrevious(aux);
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private DoubleNode<T> actual = head;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T data = actual.getData();
                actual = actual.getNext();
                return data;
            }
        };
        return iterator;
    }
    
}
