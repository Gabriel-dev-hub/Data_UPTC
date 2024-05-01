package co.edu.uptc.model;


public class Client{
    private int timeExpend;

    public Client(){
        this.timeExpend = (int) (Math.random() * 5000);
    }

    public int getTimeExpend() {
        return timeExpend;
    }

    public void setTimeExpend(int timeExpend) {
        this.timeExpend = timeExpend;
    }

}
