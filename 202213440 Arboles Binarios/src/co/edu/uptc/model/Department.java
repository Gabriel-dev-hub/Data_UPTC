package co.edu.uptc.model;

import java.util.List;

import co.edu.uptc.structures.BinaryTree;

public class Department {
    private BinaryTree<City> cities;
    private CityComparator cityComparator;

    public Department() {
        cityComparator = new CityComparator();
        cities = new BinaryTree<>(cityComparator);
    }

    public BinaryTree<City> getCities() {
        return cities;
    }

    public void setCities(BinaryTree<City> cities) {
        this.cities = cities;
    }

    public void addCity(City city) throws Exception{
        cities.insert(city);
    }

    public boolean existCity(City city) {
        return cities.exist(city);
    }

    public City getCity(City city) {
        return cities.search(city);
    }

    public List<City> showCities() {
        return cities.preOrder();
    }
}
