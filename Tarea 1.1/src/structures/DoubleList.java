package structures;

import java.util.Iterator;

public class DoubleList<T> implements Iterable<T>{
    private DoubleNode<T> head;

    public DoubleList() {
        head = null;
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
                head.setPrevious(null);
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

    public T getPrevious(T data) {
        DoubleNode<T> aux = head;
        while (aux != null && !aux.getData().equals(data)) {
            aux = aux.getNext();
        }
        if (aux != null) {
            return aux.getPrevious().getData();
        }
        return null;
    }

    public String bothShow() {
        return head.toStringBoth();
    }

    public String invertedShow() {
        if (isEmpty()) {
            return "Empty list";
        }
    
        DoubleNode<T> lastNode = head;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append(lastNode.getData());
    
        while (lastNode.getPrevious() != null) {
            sb.append(" -> ");
            lastNode = lastNode.getPrevious();
            sb.append(lastNode.getData());
        }
    
        return sb.toString();
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
