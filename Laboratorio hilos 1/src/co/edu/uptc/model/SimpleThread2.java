package co.edu.uptc.model;

public class SimpleThread2 extends Thread{
    public SimpleThread2(String str) {
        super(str);
    }
   
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName()
                                 + " Priority = " + getPriority());
        }
        System.out.println("Done! " + getName());
    }
}
