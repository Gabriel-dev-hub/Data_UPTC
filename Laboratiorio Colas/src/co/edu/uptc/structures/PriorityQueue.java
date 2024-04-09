package co.edu.uptc.structures;

public class PriorityQueue<E> {
    private MyQueue<E>[] queues;

    public PriorityQueue(int priorityLevels) {
        createQueues(priorityLevels);
    }

    public void createQueues(int priorityLevels) {
        queues = new MyQueue[priorityLevels];
        for (int i = 0; i < priorityLevels; i++) {
            queues[i] = new MyQueue<>();
        }
    }

    public void push(E data, int priority) {
        queues[priority].push(data);
    }

    public E pull() {
        E data = null;
        boolean found = false;
        for (int i = 0; i < queues.length && !found; i++) {
            if (!queues[i].isEmpty()) {
                data = queues[i].pull();
                found = true;
            }
        }
        return data;
    }

    public E peek() {
        E data = null;
        boolean found = false;
        for (int i = 0; i < queues.length && !found; i++) {
            if (!queues[i].isEmpty()) {
                data = queues[i].peek();
                found = true;
            }
        }
        return data;
    }

    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < queues.length; i++) {
            if (!queues[i].isEmpty()) {
                empty = false;
            }
        }
        return empty;
    }
}
