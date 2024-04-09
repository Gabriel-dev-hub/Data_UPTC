package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import co.edu.uptc.exceptions.ProductManagementException;
import co.edu.uptc.structures.*;

public class Store {
    private String name;
    private String address;
    private DoubleList<Product> products;

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        products = new DoubleList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addProduct(Product product) throws ProductManagementException {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product existingProduct = iterator.next();
            if (existingProduct.getId() == product.getId()) {
                throw new ProductManagementException("Ya existe un producto con el mismo código en este almacén.");
            }
        }
        products.insert(product);
    }

    public void removeProductsInRange(int startId, int endId) {
    List<Product> productsToRemove = new ArrayList<>();
    Iterator<Product> iterator = products.iterator();
    while (iterator.hasNext()) {
        Product product = iterator.next();
        if (product.getId() >= startId && product.getId() <= endId) {
            productsToRemove.add(product);
        }
    }
    for (Product productToRemove : productsToRemove) {
        products.remove(productToRemove);
    }
}

    public Product searchProductById(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public int showProductquantity() {
        int totalQuantity = 0;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            totalQuantity++;
        }
        return totalQuantity;
    }

    public double calculateTotalValue() {
        double totalValue = 0.0;
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            totalValue += product.getPrice() * product.getQuantity();
        }
        return totalValue;
    }

    public void sellProduct(int id, int quantity) throws ProductManagementException {
        Product product = searchProductById(id);
        if (product == null) {
            throw new ProductManagementException("El producto no existe en la tienda.");
        }
    
        int remainingQuantity = product.getQuantity() - quantity;
        if (remainingQuantity >= 0) {
            product.setQuantity(remainingQuantity);
        } else {
            throw new ProductManagementException("No hay suficiente cantidad del producto en la tienda.");
        }
    }

    public DoubleList<Product> getProducts() {
        return products;
    }
}
