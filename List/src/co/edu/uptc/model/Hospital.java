package co.edu.uptc.model;

import co.edu.uptc.structures.*;

public class Hospital {
    private MyQueue<Turn> queue;
    private final char GENERAL = 'G';
    private final char LAB = 'L';
    private final char XRAY = 'X';
    private int generalCounter;
    private int labCounter;
    private int xRayCounter;

    public Hospital() {
        queue = new MyQueue<>();
        generalCounter = 0;
        labCounter = 0;
        xRayCounter = 0;
    }

    public void addTurn(Turn client) {
        if (client.getType() == GENERAL) {
            generalCounter++;
            client.setId(generalCounter);
        } else if (client.getType() == LAB) {
            labCounter++;
            client.setId(labCounter);
        } else if (client.getType() == XRAY) {
            xRayCounter++;
            client.setId(xRayCounter);
        }
        queue.push(client);
    }

    public Turn attendTurn() {
        return queue.pull();
    }
}
