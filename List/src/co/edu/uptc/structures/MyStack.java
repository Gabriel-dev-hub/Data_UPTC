package co.edu.uptc.structures;

public class MyStack<E> {
    
    private MyList<E> list;

    public MyStack() {
        list = new MyList<>();
    }

    public void push(E data) {
        list.add(data);
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        E data = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return data;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean exists(E data) {
        return list.contains(data);
    }

}
