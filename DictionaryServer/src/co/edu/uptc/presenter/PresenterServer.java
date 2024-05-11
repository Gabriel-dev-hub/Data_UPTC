package co.edu.uptc.presenter;

//@Author: Gabriel Santiago Cely Forero. 202213440

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.uptc.model.*;

public class PresenterServer {

    private static final int PORT = 1234;
    private ServerSocket serverSocket;
    private MyDictionary myDictionary;
    private ClientThread clientThread;

    public PresenterServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        myDictionary = new MyDictionary();
    }

    public synchronized void run() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            clientThread = new ClientThread(socket, myDictionary);
            clientThread.start();
        }
    }
}
