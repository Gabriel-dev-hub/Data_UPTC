package co.edu.uptc.presenter;

/*
 * @autor: Gabriel Santiago Cely
 * @version: 1.0
 */

import java.util.List;
import co.edu.uptc.model.*;
import co.edu.uptc.view.View;

public class Presenter {

    private RootSort rootSort;
    private View view;

    public Presenter() {
        rootSort = new RootSort();
        view = new View();
    }

    public void run() {
        List<Integer> numeros = List.of(320, 123, 234, 512, 451, 135, 540, 431, 453, 313);
        view.showMessage("Unidades ordenadas: " + rootSort.organizeByPlace(numeros, 0));
        view.showMessage("Decenas ordenadas: " + rootSort.organizeByPlace(numeros, 1));
        view.showMessage("Centenas ordenadas: " + rootSort.organizeByPlace(numeros, 2));
        view.showMessage("Lista ordenada: " + rootSort.ordenate(numeros));
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}