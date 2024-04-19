package co.edu.uptc.test;

public class MyRunnable implements Runnable{

    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Contador de segundos" + name);
        int count = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println("Iteración " + i + " del hilo " + name);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
