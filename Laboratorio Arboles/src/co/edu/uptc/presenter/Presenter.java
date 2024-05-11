package co.edu.uptc.presenter;

//@Author: Gabriel Santiago Cely Forero. 202213440

import java.util.Properties;

import co.edu.uptc.model.*;
import co.edu.uptc.view.*;
import co.edu.uptc.persistence.*;

public class Presenter {

    private MyDictionary myDictionary;
    private View view;
    private Properties menus;
    private MenuPersistence persistence;

    public Presenter() {
        myDictionary = new MyDictionary();
        view = new View();
        persistence = new MenuPersistence();
        menus = persistence.loadMenus("data\\Menus.properties");
    }

    public void showOptions(String menuTitle) {
        view.showMessage(menus.getProperty(menuTitle));
    }

    public void run() {
        int option;
        do {
            view.showMessage("\nMenú principal");
            showOptions("menu.options");
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    showEnglishMenu();
                    break;
                case 2:
                    showFrenchMenu();
                    break;
                case 3:
                    view.showMessage("Gracias por usar el sistema de traducción");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 3);
    }

    public void showEnglishMenu() {
        int option;
        do {
            view.showMessage("\nMenú de opciones del diccionario inglés");
            showOptions("submenu.options");
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    insertInDictionary(Language.ENGLISH);
                    break;
                case 2:
                    searchInDictionary(Language.ENGLISH);
                    break;
                case 3:
                    myDictionary.showDictionary(Language.ENGLISH).forEach(word -> view.showMessage(word.toString()));
                    break;
                case 4:
                    view.showMessage("El diccionario inglés tiene: "
                            + myDictionary.calculateSizeOfDictionary(Language.ENGLISH) + " palabras");
                    break;
                case 5:
                    deleteInDictionary(Language.ENGLISH);
                    break;
                case 6:
                    view.showMessage("Saliendo al menú principal...");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 6);
    }

    public void showFrenchMenu() {
        int option;
        do {
            view.showMessage("\nMenú de opciones del diccionario francés");
            showOptions("submenu.options");
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    insertInDictionary(Language.FRENCH);
                    break;
                case 2:
                    searchInDictionary(Language.FRENCH);
                    break;
                case 3:
                    myDictionary.showDictionary(Language.FRENCH).forEach(word -> view.showMessage(word.toString()));
                    break;
                case 4:
                    view.showMessage("El diccionario francés tiene: "
                            + myDictionary.calculateSizeOfDictionary(Language.FRENCH) + " palabras");
                    break;
                case 5:
                    deleteInDictionary(Language.FRENCH);
                    break;
                case 6:
                    view.showMessage("Saliendo al menú principal...");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 6);
    }

    public void insertInDictionary(Language language) {
        String originalWord = view.readString("Ingrese la palabra en Español:");
        String traduction = view.readString("Ingrese la traducción de la palabra:");
        Word word = new Word(originalWord, traduction);
        myDictionary.insertWordInDictionary(word, language);
    }

    public void searchInDictionary(Language language) {
        String originalWord = view.readString("Ingrese la palabra a buscar en español:");
        Word word = myDictionary.searchInDictionary(originalWord, language);
        if (word != null) {
            view.showMessage("Traducción: " + word.getTraduction());
        } else {
            view.showMessage("La palabra no existe en el diccionario");
        }
    }

    public void deleteInDictionary(Language language) {
        try {
            String originalWord = view.readString("Ingrese la palabra a eliminar en español:");
            myDictionary.deleteWordInDictionary(originalWord, language);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        new Presenter().run();
    }

}
