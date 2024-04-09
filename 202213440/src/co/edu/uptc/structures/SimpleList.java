package co.edu.uptc.structures;

import java.util.Iterator;

public class SimpleList<T> implements Iterable<T> {

    private Node<T> head;

    public SimpleList() {
        head = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void remove(T data) {
        if (!isEmpty()) {
            Node<T> temp = head;
            while (temp != null) {
                if (temp.getData().equals(data)) {
                    break;
                }
                temp = temp.getNext();
            }
        }
    }

    public boolean exists(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getData().equals(data)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
    
            @Override
            public boolean hasNext() {
                return current != null;
            }
    
            @Override
            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
