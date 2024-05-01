package co.edu.uptc.model;

import co.edu.uptc.structures.MyQueue;

public class Register extends Thread{
    private MyQueue<Client> clients = new MyQueue<>();
    private int attendedClients;

    public Register(String str, MyQueue<Client> clients){
        super(str);
        this.attendedClients = 0;
        this.clients = clients;
    }

    public void run(){
        while(!clients.isEmpty()){
            try {
                Thread.sleep(clients.peek().getTimeExpend());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clients.poll();
            attendedClients++;

        }

    }

    public MyQueue<Client> getClients() {
        return clients;
    }

    public int getRemainingClients(){
        return clients.size();
    }

    public void setClients(MyQueue<Client> clients) {
        this.clients = clients;
    }

    public int getAttendedClients() {
        return attendedClients;
    }

    public void setAttendedClients(int attendedClients) {
        this.attendedClients = attendedClients;
    }
    
    
}
    
