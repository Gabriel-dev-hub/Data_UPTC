package co.edu.uptc.model;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word w1, Word w2) {
        return w1.getOriginalWord().compareTo(w2.getOriginalWord());
    }
    
}
