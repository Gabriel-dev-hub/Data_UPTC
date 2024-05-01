package co.edu.uptc.presenter;

import co.edu.uptc.model.SimpleThread;

public class ThreadGroupTest {
    public static void main(String[] args) {
        new SimpleThread("Boston").start();
        new SimpleThread("New York").start();
        new SimpleThread("Seoul").start();
        new SimpleThread("Bogotá").start();

        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println("Numero de hilos activos en el grupo = " + group.activeCount());

        Thread[] tArray = new Thread[10];
        int actualSize = group.enumerate(tArray);
        for (int i=0; i<actualSize;i++){
            System.out.println("Hilo " + tArray[i].getName() + " en el grupo de hilos " + group.getName());
        }
    }
}