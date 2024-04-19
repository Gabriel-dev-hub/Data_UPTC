package co.edu.uptc.Presenter;

//@Author: Gabriel Santiago Cely. 202213440

import java.util.List;

import co.edu.uptc.model.City;
import co.edu.uptc.model.Department;
import co.edu.uptc.view.View;

public class Presenter {
    private Department department;
    private View view;

    public Presenter() {
        department = new Department();
        view = new View();
    }

    private void run() {
        int option;
        do {
            showMenu();
            option = view.readInt("Ingrese una opción:");
            switch (option) {
                case 1:
                    insertCity();
                    break;
                case 2:
                    insertCitizen();
                    break;
                case 3:
                    showCities();
                    break;
                case 4:
                    showCitizens();
                    break;
                case 5:
                    view.showMessage("Gracias por usar el sistema de información de municipios y ciudadanos");
                    break;
                default:
                    view.showMessage("Opción no válida");
                    break;
            }
        } while (option != 5);
    }

    private void showMenu() {
        view.showMessage("\nMenú principal");
        view.showMessage("1. Agregar Municipio");
        view.showMessage("2. Agregar Ciudadano");
        view.showMessage("3. Mostrar municipios");
        view.showMessage("4. Mostrar ciudadanos de un municipio");
        view.showMessage("5. Salir");
    }

    private void insertCity() {
        try {
            String cityName = view.readString("Ingrese el nombre del municipio:");
            department.addCity(new City(cityName));
            view.showMessage("Municipio agregado correctamente");
        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    private void insertCitizen() {
        try {
            String cityName = view.readString("Ingrese el nombre del municipio donde se insertará el ciudadano:");
            String citizenName = view.readString("Ingrese el nombre del ciudadano:");
            City city = new City(cityName);
            if (department.existCity(city)) {
                department.getCity(city).addCitizen(citizenName);
                view.showMessage("Ciudadano agregado correctamente");
            } else {
                department.addCity(city);
                city.addCitizen(citizenName);
                view.showMessage("Nuevo municipio creado y ciudadando agregado correctamente");
            }
        } catch (Exception e) {
            view.showMessage(e.getMessage());
        }
    }

    private void showCities() {
        view.showMessage("Lista de municipios:");
        List<City> cities = department.showCities();
        City cityWithMostCitizens = null;
        for (City city : cities) {
            if (cityWithMostCitizens == null || city.calculatePopulation() > cityWithMostCitizens.calculatePopulation()) {
                cityWithMostCitizens = city;
            }
            view.showMessage(city.getName());
        }
        if (cityWithMostCitizens != null) {
            view.showMessage("La ciudad con más habitantes es: " + cityWithMostCitizens.getName() + " con " + cityWithMostCitizens.calculatePopulation() + " habitantes.");
        } else {
            view.showMessage("No hay ciudades registradas.");
        }
    }

    private void showCitizens() {
        view.showMessage("Lista de municipios:");
        department.showCities().forEach(c -> view.showMessage(c.getName()));
        String cityNameToSearch = view.readString("Ingrese el nombre del municipio que desea consultar:");
        City cityToSearch = new City(cityNameToSearch);
        if (department.existCity(cityToSearch)) {
            view.showMessage("Ciudadanos del municipio " + cityNameToSearch + ":");
            department.getCity(cityToSearch).showCitizens().forEach(c -> view.showMessage(c));
        } else {
            view.showMessage("El municipio no existe");
        }
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}
