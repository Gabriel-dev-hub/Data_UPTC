package co.edu.uptc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionServer {

    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;

    public ConnectionServer(Socket socket) throws IOException {
        this.socket = socket;
    }

    public void connect() throws IOException {
        
        // crear el hilo
        // hilo.start();
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
