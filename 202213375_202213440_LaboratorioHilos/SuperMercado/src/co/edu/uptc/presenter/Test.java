package co.edu.uptc.presenter;

//@Authors: Gabriel Cely. 202213440, William Gonzalez. 202213375

import co.edu.uptc.model.Client;
import co.edu.uptc.model.QueueAsigner;
import co.edu.uptc.model.Register;
import co.edu.uptc.structures.MyQueue;
import co.edu.uptc.view.View;

public class Test {
    private View view;
    private QueueAsigner queueAsigner;
    private MyQueue<Client> generalQueue;
    private Register[] registers;

    public Test() {
        view = new View();
        queueAsigner = new QueueAsigner();
        generalQueue = queueAsigner.createQueue((int) (Math.random() * 50));
        registers = new Register[3];
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.run();
    }

    public void run() {
        long time1 = System.currentTimeMillis();
        view.printMessage(
                "A continuación, se simulara el funcionamiento de un supermercado con 3 cajas y (aleatorio 0-50) "
                        + generalQueue.size() + " clientes, durante 30 segundos.");
        view.printMessage(
                "Cada cliente puede tardar (aleatorio) entre 1 y 5 segundos en la caja. Tener en cuenta que si no son por lo menos 35 clientes, todos los clientes serán atendidos");
        for (int i = 0; i < registers.length; i++) {
            registers[i] = new Register("Caja " + (i + 1), generalQueue);
        }
        queueAsigner.assignClients(registers, queueAsigner.getClients());
        for (int i = 0; i < registers.length; i++) {
            registers[i].start();
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        int remainingClients = 0;
        for (Register register : registers) {
            view.printMessage(register.getName() + " atendió " + register.getAttendedClients() + " clientes");
            remainingClients += register.getRemainingClients();
        }
        view.printMessage("La cantidad de clientes que no fueron atendidos es: " + (remainingClients));
        view.printMessage("El tiempo total de ejecución fue de: " + (time2 - time1) + " milisegundos");
        // Thread.currentThread().interrupt() no funciono
        System.exit(0);
    }
}