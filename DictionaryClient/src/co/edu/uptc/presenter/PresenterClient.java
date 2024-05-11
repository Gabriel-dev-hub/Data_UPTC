package co.edu.uptc.presenter;

import java.io.IOException;
import java.net.UnknownHostException;

//@Author: Gabriel Santiago Cely Forero. 202213440

import java.util.Properties;

import co.edu.uptc.persistence.*;
import co.edu.uptc.view.*;
import co.edu.uptc.net.*;

public class PresenterClient {

    private View view;
    private Properties menus;
    private MenuPersistence persistence;
    private ConnectionClient connectionClient;

    public PresenterClient() throws UnknownHostException, IOException {
        view = new View();
        persistence = new MenuPersistence();
        menus = persistence.loadMenus("data\\Menus.properties");
        connectionClient = new ConnectionClient();
    }

    public void showOptions(String menuTitle) {
        view.showMessage(menus.getProperty(menuTitle));
    }

    public synchronized void run() throws IOException {
        int option;
        do {
            view.showMessage("\nMenú principal");
            showOptions("menu.options");
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    connectionClient.sendMessage("showEnglishMenu");
                    showMenu();
                    break;
                case 2:
                    connectionClient.sendMessage("showFrenchMenu");
                    showMenu();
                    break;
                case 3:
                    connectionClient.sendMessage("exit");
                    view.showMessage("Gracias por usar el sistema de traducción");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 3);
    }

    public void showMenu() throws IOException {
        int option;
        do {
            view.showMessage("\nMenú de opciones del diccionario");
            showOptions("submenu.options");
            option = view.readInt("Ingrese una opción:");
            connectionClient.sendMessage(option + "");
            switch (option) {
                case 1:
                    connectionClient.sendMessage(view.readString("Ingrese la palabra a traducir:"));
                    connectionClient.sendMessage(view.readString("Ingrese la traducción:"));
                    break;
                case 2:
                    connectionClient.sendMessage(view.readString("Ingrese la palabra a buscar:"));
                    view.showMessage(connectionClient.receiveMessage());
                    break;
                case 3:
                    int number = Integer.parseInt(connectionClient.receiveMessage());
                    for (int i = 0; i < number; i++) {
                        view.showMessage(connectionClient.receiveMessage());
                    }
                    break;
                case 4:
                    view.showMessage(connectionClient.receiveMessage());
                    break;
                case 5:
                    connectionClient.sendMessage(view.readString("Ingrese la palabra a eliminar:"));
                    view.showMessage(connectionClient.receiveMessage());
                    break;
                case 6:
                    view.showMessage(connectionClient.receiveMessage());
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 6);
    }
}
