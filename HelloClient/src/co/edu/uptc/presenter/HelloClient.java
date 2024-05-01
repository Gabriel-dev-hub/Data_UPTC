package co.edu.uptc.presenter;

import java.io.IOException;
import java.net.UnknownHostException;

import co.edu.uptc.view.View;

public class HelloClient {
    
    private View view;
    private Connection connection;

    public HelloClient() throws UnknownHostException, IOException {
        connection = new Connection();
        view = new View();
    }

    public void start() throws IOException {
        view.showMessage("Soy el cliente");
        view.showMessage("Saliendo por el puerto: " + connection.getLocalPort());
        view.showMessage("Apuntando al puerto: " + connection.getPort());
        view.showMessage(connection.receiveMessage());
        view.showMessage("inicio envio de datos...");
        String option = new String();
        while(!option.equals("exit")) {
            option = view.readData();
            connection.sendMessage(option);
        }
        view.showMessage("Respuesta del servidor: " + connection.receiveMessage());
        connection.close();
    }
}
