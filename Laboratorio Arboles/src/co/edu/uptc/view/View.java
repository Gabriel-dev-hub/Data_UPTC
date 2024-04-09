package co.edu.uptc.view;

import java.util.Scanner;

public class View {

    private Scanner sc;

    public View() {
    }

    public String readString(String message) {
        System.out.println(message);
        try {
            sc = new Scanner(System.in);
            String input = sc.nextLine();
            return input;
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getMessage() + " porfavor ingrese una cadena de caracteres valida.");
            return this.readString(message);
        }
    }

    public double readDouble(String message) {
        System.out.println(message);
        try {
            sc = new Scanner(System.in);
            double input = sc.nextDouble();
            return input;
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getMessage() + " porfavor ingrese una número decimal valido.");
            return this.readDouble(message);
        }
    }

    public int readInt(String message) {
        System.out.println(message);
        try {
            sc = new Scanner(System.in);
            int input = sc.nextInt();
            return input;
        } catch (Exception e) {
            System.out.println("Error de tipo: " + e.getMessage() + " porfavor ingrese una número valido.");
            return this.readInt(message);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
