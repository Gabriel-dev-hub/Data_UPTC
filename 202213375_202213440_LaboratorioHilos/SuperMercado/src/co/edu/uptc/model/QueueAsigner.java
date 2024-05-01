package co.edu.uptc.model;

import co.edu.uptc.structures.MyQueue;

public class QueueAsigner extends Thread {
    private int clients;

    public MyQueue<Client> createQueue(int n) {
        MyQueue<Client> queue = new MyQueue<>();
        for (int i = 0; i < n; i++) {
            Client client = new Client();
            queue.push(client);
            clients++;
        }
        return queue;
    }

    public void assignClients(Register[] registers, int n) {
        int clientsPerRegister = n / registers.length;
        int remainingClients = n % registers.length;
        for (int i = 0; i < registers.length; i++) {
            registers[i].setClients(createQueue(clientsPerRegister + (i < remainingClients ? 1 : 0)));
        }
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

}
