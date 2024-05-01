package co.edu.uptc.presenter;

import co.edu.uptc.model.SimpleThread;

public class DisplayAllThreads {
    public static void main(String[] args) {
        new SimpleThread("Boston").start();
        new SimpleThread("New York").start();
        new SimpleThread("Seoul").start();

        Thread[] tArray = findAllThreads();

        for (int i=0; i<tArray.length;i++){
            System.out.println("Hilo " + tArray[i].getName()
            + " el el grupo de hilos " + tArray[i].getThreadGroup().getName());
        }
    }

    public static Thread[] findAllThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
       
        ThreadGroup topGroup = group;
       
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
       
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slackList = new Thread[estimatedSize];
       
        int actualSize = topGroup.enumerate(slackList);
       
        Thread[] list = new Thread[actualSize];
        System.arraycopy(slackList, 0, list, 0, actualSize);
       
        return list;
    }
}
