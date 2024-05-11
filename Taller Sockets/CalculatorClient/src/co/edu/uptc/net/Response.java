package co.edu.uptc.net;

public class Response {
    private String result;

    public Response(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Response { " + result + " }";
    }
}
