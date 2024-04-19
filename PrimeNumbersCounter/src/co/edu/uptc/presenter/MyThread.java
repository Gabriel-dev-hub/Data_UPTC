package co.edu.uptc.presenter;

public class MyThread extends Thread {
    private int start;
    private int end;
    private int count;

    public MyThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.count = 0;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getCount() {
        return count;
    }
    
}
