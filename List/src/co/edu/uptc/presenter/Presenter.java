package co.edu.uptc.presenter;

import co.edu.uptc.model.*;
import co.edu.uptc.view.*;
import co.edu.uptc.structures.*;

public class Presenter {

    private View view;
    private Hospital hospital;

    public Presenter() {
        view = new View();
        hospital = new Hospital();
    }

    public void run() {
        int option;
        do {
            showMenu();
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    addTurn();
                    break;
                case 2:
                    view.showMessage("Paciente atendido: " + hospital.attendTurn().toString());
                    break;
                case 3:
                    view.showMessage("Gracias por usar el sistema de turnos");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 3);
    }

    public void showMenu() {
        view.showMessage("Bienvenido al sistema de turnos del hospital");
        view.showMessage("1. Agregar turno");
        view.showMessage("2. Atender turno");
        view.showMessage("3. Salir");
    }

    public void addTurn() {
        String name = view.readString("Ingrese el nombre del paciente");
        showCategory();
        char type = view.readChar("Ingrese el tipo de turno (G, L, X)");
        Turn turn = new Turn(name, type);
        hospital.addTurn(turn);
        showTurn(turn);
    }

    public void showCategory() {
        view.showMessage("General (G)");
        view.showMessage("Laboratorio (L)");
        view.showMessage("Rayos X (X)");
    }

    public void showTurn(Turn turn) {
        view.showMessage("turno agregado para: " + turn.toString());
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}