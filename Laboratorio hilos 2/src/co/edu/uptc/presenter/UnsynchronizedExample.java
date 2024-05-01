package co.edu.uptc.presenter;

import co.edu.uptc.model.PrintStringsThread;

public class UnsynchronizedExample {
    public static void main(String[] args) {
        new PrintStringsThread("Hello ", "there.");
        new PrintStringsThread("How are ", "you?");
        new PrintStringsThread("Thank you ", "very much!");
    }
}
