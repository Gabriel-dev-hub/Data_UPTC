package co.edu.uptc.presenter;

import java.util.Iterator;

import co.edu.uptc.exceptions.*;
import co.edu.uptc.model.*;
import co.edu.uptc.view.*;

public class Presenter {

    public View view;
    public Chain chain;

    public Presenter() {
        view = new View();
        chain = new Chain();
    }

    public void run() {

        int option;
        do {
            showMenu();
            option = view.readInt("Ingrese una opcion: ");
            switch (option) {
                case 1:
                    addStore();
                    break;
                case 2:
                    showStores();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    sellProduct();
                    break;
                case 5:
                    showStoreProducts();
                    break;
                case 6:
                    removeProducts();
                    break;
                case 7:
                    view.print("Valor total de la cadena de tiendas: $" + chain.calculateTotalValue());
                    break;
                case 8:
                    option = 0;
                    break;
                default:
                    view.print("Opción no válida");
                    break;

            }
        } while (option != 0);
    }

    public void showMenu() {
        view.print("Bienvenido a la tienda de la cadena de tiendas");
        view.print("1. Agregar tienda");
        view.print("2. Mostrar tiendas");
        view.print("3. Agregar producto");
        view.print("4. Vender producto");
        view.print("5. Mostrar productos de una tienda");
        view.print("6. Eliminar rango de productos de una tienda");
        view.print("7. Ver valor total de la cadena");
        view.print("8. Salir");
    }

    public void addStore() {
        String name = view.readString("Ingrese el nombre de la tienda: ");
        String address = view.readString("Ingrese la dirección de la tienda: ");
        Store store = new Store(name, address);
        chain.addStore(store);
    }

    public void addProduct() {
        try {
            view.print("Seleccione la tienda a la que desea agregar el producto: ");
            showStores();
            String storeName = view.readString("Ingrese el nombre de la tienda: ");
            Store auxStore = chain.searchStore(storeName);
            insertProduct(auxStore);
        } catch (NotFoundStoreException e) {
            view.print(e.getMessage());
        }
    }

    public void insertProduct(Store auxStore) {
        try {
            int id = view.readInt("Ingrese el id del producto: ");
            String nameProduct = view.readString("Ingrese el nombre del producto: ");
            double price = view.readDouble("Ingrese el precio del producto (Pesos colombianos): ");
            int quantity = view.readInt("Ingrese la cantidad del producto: ");
            Product product = new Product(id, nameProduct, price, quantity);
            auxStore.addProduct(product);
            view.print("Producto agregado a la tienda");
        } catch (ProductManagementException e) {
            view.print(e.getMessage());
        }
    }

    public void sellProduct() {
        try {
            view.print("Seleccione la tienda a la que desea vender el producto: ");
            showStores();
            String storeName = view.readString("Ingrese el nombre de la tienda: ");
            Store auxStore = chain.searchStore(storeName);
            showProducts(auxStore);
            int idProduct = view.readInt("Ingrese el id del producto: ");
            int quantity = view.readInt("Ingrese la cantidad del producto: ");
            auxStore.sellProduct(idProduct, quantity);
            view.print("Venta realizada");
        } catch (NotFoundStoreException | ProductManagementException e) {
            view.print(e.getMessage());
        }
    }

    public void showStoreProducts() {
        try {
            view.print("Seleccione la tienda de la que desea ver los productos: ");
            showStores();
            String storeName = view.readString("Ingrese el nombre de la tienda: ");
            Store auxStore = chain.searchStore(storeName);
            showProducts(auxStore);
        } catch (NotFoundStoreException e) {
            view.print(e.getMessage());
        }
    }

    public void removeProducts() {
        try {
            view.print("Seleccione la tienda de la que desea eliminar un rango de productos: ");
            showStores();
            String storeName = view.readString("Ingrese el nombre de la tienda: ");
            Store auxStore = chain.searchStore(storeName);
            int startId = view.readInt("Ingrese el valor inical del rango: ");
            int endId = view.readInt("Ingrese el valor final del rango: ");
            auxStore.removeProductsInRange(startId, endId);
            view.print("Productos eliminados");
        } catch (NotFoundStoreException e) {
            view.print(e.getMessage());
        }
    }

    public void showStores() {
        Iterator<Store> iterator = chain.getStores().iterator();
        while (iterator.hasNext()) {
            showStoreInfo(iterator.next());
        }
    }

    public void showProducts(Store store) {
        Iterator<Product> iterator = store.getProducts().iterator();
        while (iterator.hasNext()) {
            showProductInfo(iterator.next());
        }
    }

    public void showStoreInfo(Store store) {
        view.print("Nombre: " + store.getName() + " Dirección: " + store.getAddress() + " Cantidad de productos: " + store.showProductquantity() + " Valor total: $" + store.calculateTotalValue());
    }

    public void showProductInfo(Product product) {
        view.print("Id: " + product.getId() + " Nombre: " + product.getName() + " Precio: " + product.getPrice() + " Cantidad: " + product.getQuantity());
    }

    public static void main(String[] args) {
        new Presenter().run();
    }
}
