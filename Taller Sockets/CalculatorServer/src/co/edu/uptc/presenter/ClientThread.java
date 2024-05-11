package co.edu.uptc.presenter;

import java.io.IOException;
import java.net.Socket;
import com.google.gson.Gson;

import co.edu.uptc.model.Calculator;
import co.edu.uptc.net.ConnectionServer;
import co.edu.uptc.net.Request;

public class ClientThread extends Thread{
    
    private ConnectionServer connection;
    private Calculator calculator;
    private Gson gson;

    public ClientThread(Socket socket, Calculator calculator) throws IOException {
        connection = new ConnectionServer(socket);
        this.calculator = calculator;
        gson = new Gson();
    }

    public void run() {
        try {
            menu();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void menu() throws IOException {
        connection.connect();
        boolean running = true;
        while (running) {
            String message = connection.receive();
            Request request = gson.fromJson(message, Request.class);
            message = request.getInput();
            if (message.equals("mostrar")) {
                connection.send(gson.toJson(calculator.getMemory()) + "");
                continue;
            }
            if (message.equals("exit")) {
                running = false;
            } else {
                if (calculator.processInput(message) == false) {
                    connection.send("Operación inválida, intente de nuevo con el formato adecuado, por ejemplo: 2 + 2");
                    continue;
                } else {
                    connection.send("Resultado: " + calculator.getResult());
                }
            }
        }
        connection.close();
    }
}
