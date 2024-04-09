package co.edu.uptc.model;

public class Document {
    private String name;
    private int pages;

    public Document(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "nombre: " + name + ", numero de páginas: " + pages;
    }
}
