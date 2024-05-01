package co.edu.uptc.presenter;

import java.io.IOException;

import co.edu.uptc.model.Conversation;
import co.edu.uptc.net.Connection;

public class HelloServer { 
    private Conversation conversation;
    private Connection connection;

    public HelloServer() throws IOException {
        connection = new Connection();
        conversation = new Conversation();
    }

    public void start() throws IOException {
        connection.connect();
        connection.send("Conectado al servidor");
        System.out.println("Cliente conectado");
        System.out.println("Datos recibidos");
        String recievedMessage = new String();
        while (!recievedMessage.equals("exit")) {
            recievedMessage = connection.receive();
            conversation.addMessage(recievedMessage);
            System.out.println("conversacion: " + conversation.getMessages());
        }
        System.out.println("Fin de la transmision");
        connection.send("Datos recibidos satisfactoriamente");
        connection.close();
    }
}
