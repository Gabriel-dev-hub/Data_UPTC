package main;

public class NumberSimpleList {

    private Node head;

    public NumberSimpleList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
    }

    public boolean exists(int data) {
        boolean exists = false;
        Node aux = head;
        while (aux != null) {
            if (aux.getValue() == data) {
                exists = true;
            }
            aux = aux.getNext();
        }
        return exists;
    }

    public void delete(int data) {
        if (!isEmpty()) {
            if (head.getValue() == data) {
                head = head.getNext();
            } else {
                Node aux = head;
                while (aux.getNext() != null) {
                    if (aux.getNext().getValue() == data) {
                        aux.setNext(aux.getNext().getNext());
                    }
                    aux = aux.getNext();
                }
            }
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String show() {
        return head.toString();
    }

}
