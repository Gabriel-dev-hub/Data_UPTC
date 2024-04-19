package co.edu.uptc.presenter;

public class Main {
    public static void main(String[] args) {
        PrimeNumbersCounter primeNumbersCounter = new PrimeNumbersCounter();
        Long tiempoInicio = System.currentTimeMillis();
        System.out.println(primeNumbersCounter.countPrimes(500000));
        Long tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + (tiempoFinal - tiempoInicio) + " milisegundos");

        MyThread thread1 = new MyThread(2, 100000);
        MyThread thread2 = new MyThread(100000, 200000); 
        MyThread thread3 = new MyThread(200000, 300000);
        MyThread thread4 = new MyThread(300000, 400000);
        MyThread thread5 = new MyThread(400000, 500000);   
        tiempoInicio = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive() || thread5.isAlive()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(thread1.getCount() + thread2.getCount() + thread3.getCount() + thread4.getCount() + thread5.getCount());
        tiempoFinal = System.currentTimeMillis();
        System.out.println("Tiempo de ejecución: " + (tiempoFinal - tiempoInicio) + " milisegundos");

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
