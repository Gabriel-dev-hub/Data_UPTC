package co.edu.uptc.presenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.uptc.model.Calculator;

public class CalculatorServer {
    
    private static final int PORT = 1234;
    private ServerSocket serverSocket;
    private Calculator calculator;

    public CalculatorServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        calculator = new Calculator();
    }

    public void start() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            ClientThread clientThread = new ClientThread(socket, calculator);
            clientThread.start(); 
        }
    }
}
