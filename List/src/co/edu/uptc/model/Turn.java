package co.edu.uptc.model;

public class Turn {
    private String name;
    private int id;
    private char type;

    public Turn(String name, char type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", id: " + type + id;
    }

    
}
