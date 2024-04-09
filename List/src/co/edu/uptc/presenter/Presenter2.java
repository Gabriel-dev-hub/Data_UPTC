package co.edu.uptc.presenter;

import co.edu.uptc.model.*;
import co.edu.uptc.view.*;

public class Presenter2 {

    private View view;
    private Printer printer;

    public Presenter2() {
        view = new View();
        printer = new Printer(4);
    }

    public void run() {
        int option;
        do {
            showMenu();
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    view.showMessage("Impresión: " + printer.printDocument().toString() + " realizada");
                    break;
                case 3:
                    view.showMessage("Gracias por usar el sistema de impresión");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 3);
    }

    //Archivo de configuracion
    public void showMenu() {
        view.showMessage("Impresora de documentos");
        view.showMessage("1. Agregar impresión a la lista");
        view.showMessage("2. Imprimir documento");
        view.showMessage("3. Salir");
    }

    public void addDocument() {
        String name = view.readString("Ingrese el nombre del documento");
        int pages = view.readInt("Ingrese la cantidad de páginas del documento");
        Document document = new Document(name, pages);
        printer.addDocument(document);
        showTurn(document);
    }

    public void showTurn(Document document) {
        view.showMessage("Documento: " + document.toString() + " agregado a la lista de impresión");
    }

    public static void main(String[] args) {
        new Presenter2().run();
    }
}
