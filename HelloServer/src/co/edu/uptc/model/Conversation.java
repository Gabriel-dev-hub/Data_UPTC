package co.edu.uptc.model;

import java.util.ArrayList;

public class Conversation {
    private ArrayList<String> messages;

    public Conversation() {
        messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "messages=" + messages +
                '}';
    }
}
