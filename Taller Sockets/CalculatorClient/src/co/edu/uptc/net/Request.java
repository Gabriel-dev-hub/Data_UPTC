package co.edu.uptc.net;

public class Request {
    private String operation;

    public Request(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Request { " + operation + " }";
    }
}
