package co.edu.uptc.structures;

public class MyQueue<E> {

    private MyList<E> list;

    public MyQueue() {
        list = new MyList<>();
    }

    public void push(E data) {
        list.add(list.size(), data);
    }

    public E pull() {
        if (isEmpty()) {
            return null;
        }
        E data = peek();
        list.remove(0);
        return data;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean exists(E data) {
        return list.contains(data);
    }
}
