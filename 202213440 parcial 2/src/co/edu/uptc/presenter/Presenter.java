package co.edu.uptc.presenter;

//@Author: Gabriel Santiago Cely Forero. 202213440

import co.edu.uptc.model.*;
import co.edu.uptc.persistence.Persistence;

public class Presenter {

    private BinaryCalculator binaryCalculator;
    private String fileNumbers;
    private Persistence persistence;

    public Presenter() {
        persistence = new Persistence();
    }

    public void run() {
        // Modificar archivo de configuración para cambiar los valores
        fileNumbers = persistence.convertFileToString("data\\NumerosEntrada.prop");
        binaryCalculator = new BinaryCalculator(fileNumbers);

        System.out.println("Resultado: " + binaryCalculator.calculate());
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}
