package co.edu.uptc.presenter;

import java.io.IOException;
import java.net.UnknownHostException;
import co.edu.uptc.view.View;
import co.edu.uptc.net.ConnectionClient;
import co.edu.uptc.net.Request;

import com.google.gson.Gson;

public class CalculatorClient {
    private View view;
    private ConnectionClient connection;

    public CalculatorClient() throws UnknownHostException, IOException {
        connection = new ConnectionClient();
        view = new View();
    }

    public void start() throws IOException {

        view.showMessage("Conectado al servidor en el puerto " + connection.getPort());
        view.showMessage("Puerto local: " + connection.getLocalPort());
        view.showMessage("Los operadores válidos son: +, -, *, /");
        view.showMessage("Ingrese una operación usando espacios por operandos (Por ejemplo 4 / 2), 'exit' para salir, o 'mostrar' para ver la memoria:");

        while (true) {
            String operation = view.readData();
            if (operation.equals("exit")) {
                break;
            }
            if (operation.equals("mostrar")) {
                connection.sendMessage(new Gson().toJson(new Request(operation)));
                view.showMessage("Memoria: " + connection.receiveMessage());
                continue;
            }
            connection.sendMessage(new Gson().toJson(new Request(operation)));
            view.showMessage("Resultado: " + connection.receiveMessage());
        }
        connection.close();
    }
}
