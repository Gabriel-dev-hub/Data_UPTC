package co.edu.uptc.test;

public class Test {
    MyThread t1 = new MyThread("Hilo 1");
    MyThread t2 = new MyThread("Hilo 2");
    Thread t3 = new Thread(new MyRunnable("Runnable"));

    public void test() {
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        new Test().test();
    }
}
