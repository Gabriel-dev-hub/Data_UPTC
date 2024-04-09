package co.edu.uptc.model;

public class Word {
    private String originalWord;
    private String traduction;

    public Word(String originalWord, String traduction) {
        this.originalWord = originalWord;
        this.traduction = traduction;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public String getTraduction() {
        return traduction;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public void setTraduction(String traduction) {
        this.traduction = traduction;
    }

    @Override
    public String toString() {
        return  "palabra='" + originalWord + '\'' +
                ", traduccion='" + traduction + '\'';
    }
}
