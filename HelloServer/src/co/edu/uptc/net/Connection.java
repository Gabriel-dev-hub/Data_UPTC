package co.edu.uptc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
    private static final int PORT = 1234;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;

    public Connection() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    public void connect() throws IOException {
        socket = serverSocket.accept();
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
    }

    public void send(String message) throws IOException {
        output.writeUTF(message);
    }

    public String receive() throws IOException {
        return input.readUTF();
    }

    public void close() throws IOException {
        socket.close();
    }
}
