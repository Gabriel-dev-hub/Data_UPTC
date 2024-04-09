package co.edu.uptc.structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E> {

    public Node<E> head;

    public MyList() {
        head = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> aux = head;
        while (aux != null) {
            aux = aux.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public static <E> boolean isInstanceOf(Class<E> clazz, Object o) {
        return clazz.isInstance(o);
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        Iterator<E> iterator = iterator();
        if (!isInstanceOf(o.getClass(), head.getData())) {
            throw new ClassCastException();
        }
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                contains = true;
            }
        }
        return contains;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> aux = head;

            @Override
            public boolean hasNext() {
                return aux != null;
            }

            @Override
            public E next() {
                E data = aux.getData();
                aux = aux.getNext();
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        int i = 0;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            array[i] = iterator.next();
            i++;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        int i = 0;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext() && i < a.length) {
            a[i] = (T) iterator.next();
            i++;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<E>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        if (!isEmpty()) {
            Node<E> aux = head;
            while (aux != null) {
                if (aux.getData().equals(o)) {
                    if (aux == head) {
                        head = head.getNext();
                    } else {
                        Node<E> prev = head;
                        while (prev.getNext() != aux) {
                            prev = prev.getNext();
                        }
                        prev.setNext(aux.getNext());
                    }
                    removed = true;
                }
                aux = aux.getNext();
            }
        }
        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = true;
        for (Object element : c) {
            if (!contains(element)) {
                containsAll = false;
            }
        }
        return containsAll;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        boolean modified = false;
        for (E element : c) {
            if (add(element)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean modified = false;
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        for (E element : c) {
            add(index++, element);
            modified = true;
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux.getData();
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> aux = head;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        E oldData = aux.getData();
        aux.setData(element);
        return oldData;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<E>(element);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node<E> aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            newNode.setNext(aux.getNext());
            aux.setNext(newNode);
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        E removedData;
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
        } else {
            Node<E> aux = head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            removedData = aux.getNext().getData();
            aux.setNext(aux.getNext().getNext());
        }
        return removedData;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> aux = head;
        int index = 0;
        int result = -1;
        boolean found = false;
        while (aux != null && !found) {
            if (o == null) {
                if (aux.getData() == null) {
                    result = index;
                    found = true;
                }
            } else {
                if (o.equals(aux.getData())) {
                    result = index;
                    found = true;
                }
            }
            aux = aux.getNext();
            index++;
        }
        return result;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> aux = head;
        int index = -1;
        int auxIndex = 0;
        if (o == null) {
            while (aux != null) {
                if (aux.getData() == null) {
                    index = auxIndex;
                }
                aux = aux.getNext();
                auxIndex++;
            }
        } else {
            while (aux != null) {
                if (o.equals(aux.getData())) {
                    index = auxIndex;
                }
                aux = aux.getNext();
                auxIndex++;
            }
        }
        return index;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        List<E> sublist = new ArrayList<>();
        Iterator<E> iterator = iterator();
        for (int i = 0; i < fromIndex; i++) {
            iterator.next();
        }
        for (int i = fromIndex; i < toIndex; i++) {
            sublist.add(iterator.next());
        }
        return sublist;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }
}
