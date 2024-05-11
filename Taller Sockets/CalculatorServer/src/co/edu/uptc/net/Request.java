package co.edu.uptc.net;

public class Request {
    private String input;

    public Request(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "Request [input=" + input + "]";
    }
}
