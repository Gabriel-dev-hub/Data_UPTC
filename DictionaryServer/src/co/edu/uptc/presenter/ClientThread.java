package co.edu.uptc.presenter;

import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;

import co.edu.uptc.model.*;
import co.edu.uptc.net.*;

public class ClientThread extends Thread {

    private ConnectionServer connection;
    private MyDictionary dictionary;
    private Gson gson;

    public ClientThread(Socket socket, MyDictionary dictionary) throws IOException {
        connection = new ConnectionServer(socket);
        this.dictionary = dictionary;
        gson = new Gson();
    }

    public void run() {
        try {
            connection.connect();
            String message;
            do {
                message = connection.receive();
                if (message.equals("showEnglishMenu")) {
                    showEnglishMenu();
                } else if (message.equals("showFrenchMenu")) {
                    showFrenchMenu();
                }
            } while (!message.equals("exit"));
        } catch (IOException e) {
            System.err.println("Error al recibir mensaje: " + e.getMessage());
        }
    }
    

    public void showEnglishMenu() throws IOException {
        int option;
        do {
            option = Integer.parseInt(connection.receive());
            switch (option) {
                case 1:
                    insertInDictionary(Language.ENGLISH);
                    break;
                case 2:
                    searchInDictionary(Language.ENGLISH);
                    break;
                case 3:
                    int quantity = dictionary.calculateSizeOfDictionary(Language.ENGLISH);
                    connection.send(quantity + "");
                    dictionary.showDictionary(Language.ENGLISH).forEach(word -> {
                        try {
                            connection.send(gson.toJson(word));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case 4:
                    connection.send("El diccionario inglés tiene: "
                            + dictionary.calculateSizeOfDictionary(Language.ENGLISH) + " palabras");
                    break;
                case 5:
                    deleteInDictionary(Language.ENGLISH);
                    break;
                case 6:
                    connection.send("Saliendo del menú inglés");
                    break;
                default:
                    connection.send("Opción no válida");
                    break;
            }
        } while (option != 6);
    }

    public void showFrenchMenu() throws IOException {
        int option;
        do {
            option = Integer.parseInt(connection.receive());
            switch (option) {
                case 1:
                    insertInDictionary(Language.FRENCH);
                    break;
                case 2:
                    searchInDictionary(Language.FRENCH);
                    break;
                case 3:
                    int quantity = dictionary.calculateSizeOfDictionary(Language.FRENCH);
                    connection.send(quantity + "");
                    dictionary.showDictionary(Language.FRENCH).forEach(word -> {
                        try {
                            connection.send(gson.toJson(word));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case 4:
                    connection.send("El diccionario francés tiene: "
                            + dictionary.calculateSizeOfDictionary(Language.FRENCH) + " palabras");
                    break;
                case 5:
                    deleteInDictionary(Language.FRENCH);
                    break;
                case 6:
                    connection.send("Saliendo del menú francés");
                    break;
                default:
                    connection.send("Opción no válida");
                    break;
            }
        } while (option != 6);
    }

    public synchronized void insertInDictionary(Language language) throws IOException {
        String originalWord = connection.receive();
        String traduction = connection.receive();
        Word word = new Word(originalWord, traduction);
        dictionary.insertWordInDictionary(word, language);
    }

    public synchronized void searchInDictionary(Language language) throws IOException {
        String originalWord = connection.receive();
        Word word = dictionary.searchInDictionary(originalWord, language);
        if (word != null) {
            connection.send(gson.toJson(word));
        } else {
            connection.send("Palabra no encontrada");
        }
    }

    public synchronized void deleteInDictionary(Language language) throws IOException {
        try {
            String originalWord = connection.receive();
            dictionary.deleteWordInDictionary(originalWord, language);
            connection.send("Palabra eliminada"); 
        } catch (Exception e) {
            connection.send("Palabra no encontrada");
        }
    }
}
