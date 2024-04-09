package co.edu.uptc.presenter;

import java.util.Scanner;
import co.edu.uptc.model.*;
import co.edu.uptc.persistence.Persistence;

public class Presenter {

    Scanner scanner;

    public Presenter() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        String numbers = new Persistence().fileToString("src/co/edu/uptc/resources/hola.txt");
        Calculator ad = new Calculator(numbers);
        Calculator ad1 = new Calculator("12 12 12 12");

        System.out.println(ad.add());
        System.out.println(ad1.add());

    }

}
