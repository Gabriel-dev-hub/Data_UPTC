package co.edu.uptc.structures;

public class MyQueue<T> {
    private MyList<T> myList;

    public MyQueue() {
        myList = new MyList<T>();
    }

    public void push(T t) {
        myList.addFirst(t);
    }

    public T poll() {
        T data = myList.getLast();
        myList.removeLast();
        return data;
    }

    public T peek() {
        return myList.getLast();
    }
    public void clear(){
        myList.clear();
    }   

    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public int size() {
        return myList.size();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "myList=" + myList +
                '}';
    }
}