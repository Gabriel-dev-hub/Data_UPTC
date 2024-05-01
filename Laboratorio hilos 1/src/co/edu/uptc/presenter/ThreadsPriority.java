package co.edu.uptc.presenter;

import co.edu.uptc.model.SimpleThread2;

public class ThreadsPriority {
    public static void main(String[] args) {
       
        Thread t1 = new SimpleThread2("Boston");
        t1.start();
        t1.setPriority(10);
       
        Thread t2 = new SimpleThread2("New York");
        t2.start();
        t2.setPriority(5);
       
        Thread t3 = new SimpleThread2("Seoul");
        t3.start();
        t3.setPriority(1);
       
    }
}
