package co.edu.uptc.model;

import java.util.List;

import co.edu.uptc.structures.BinaryTree;

public class MyDictionary {
    private WordComparator wordComparator;
    private BinaryTree<Word> englishTree;
    private BinaryTree<Word> frenchTree;

    public MyDictionary() {
        wordComparator = new WordComparator();
        englishTree = new BinaryTree<>(wordComparator);
        frenchTree = new BinaryTree<>(wordComparator);
    }

    public synchronized void insertWordInDictionary(Word word, Language language) {
        if (language == Language.ENGLISH) {
            englishTree.insert(word);
        } else if (language == Language.FRENCH) {
            frenchTree.insert(word);
        }
    }

    public synchronized Word searchInDictionary(String originalWord, Language language) {
        Word word = null;
        if (language == Language.ENGLISH) {
            word = englishTree.search(new Word(originalWord, ""));
        } else if (language == Language.FRENCH) {
            word = frenchTree.search(new Word(originalWord, ""));
        }
        return word;
    }

    public synchronized List<Word> showDictionary(Language language) {
        List<Word> list = null;
        if (language == Language.ENGLISH) {
            list = englishTree.inOrder();
        } else if (language == Language.FRENCH) {
            list = frenchTree.inOrder();
        }
        return list;
    }

    public synchronized int calculateSizeOfDictionary(Language language) {
        int size = 0;
        for (Word word : showDictionary(language)) {
            size++;
        }
        return size;
    }

    public synchronized void deleteWordInDictionary(String originalWord, Language language) {
        if (language == Language.ENGLISH) {
            englishTree.remove(new Word(originalWord, ""));
        } else if (language == Language.FRENCH) {
            frenchTree.remove(new Word(originalWord, ""));
        }
    }
}
