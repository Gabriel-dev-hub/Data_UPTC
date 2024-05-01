package co.edu.uptc.presenter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
    public final static String HOST = "localhost";
    public final static int PORT = 1234;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;

    public Connection() throws UnknownHostException, IOException {
        socket = new Socket(HOST, PORT);
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
    }

    public void sendMessage(String message) throws IOException {
        output.writeUTF(message);
    }

    public String receiveMessage() throws IOException {
        return input.readUTF();
    }

    public String getLocalPort() {
        return String.valueOf(socket.getLocalPort());
    }

    public String getPort() {
        return String.valueOf(socket.getPort());
    }

    public void close() throws IOException {
        socket.close();
    }
}
