package co.edu.uptc.model;

import java.util.List;

import co.edu.uptc.structures.AVLTree;

public class City {
    private String name;
    private AVLTree<String> citizens;

    public City(String name) {
        this.name = name;
        this.citizens = new AVLTree<>(String::compareTo);
    }

    public String getName() {
        return name;
    }

    public AVLTree<String> getCitizens() {
        return citizens;
    }

    public void addCitizen(String citizenName) throws Exception{
        citizens.insert(citizenName);
    }

    public boolean existCitizen(String citizenName) {
        return citizens.exist(citizenName);
    }

    public List<String> showCitizens() {
        return citizens.inOrder();
    }

    public int calculatePopulation() {
        int size = 0;
        for (String citizen : showCitizens()) {
            size++;
        }
        return size;
    }
}
