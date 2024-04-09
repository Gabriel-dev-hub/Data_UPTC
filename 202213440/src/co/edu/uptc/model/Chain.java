package co.edu.uptc.model;

import java.util.Iterator;

import co.edu.uptc.exceptions.NotFoundStoreException;
import co.edu.uptc.structures.SimpleList;

public class Chain {
    private SimpleList<Store> stores;

    public Chain() {
        stores = new SimpleList<>();
    }

    public void addStore(Store store) {
        stores.insert(store);
    }

    public double calculateTotalValue() {
        double total = 0;
        Iterator<Store> iterator = stores.iterator();
        while (iterator.hasNext()) {
            total += iterator.next().calculateTotalValue();
        }
        return total;
    }

    public Store searchStore(String storeName) throws NotFoundStoreException {
        Iterator<Store> iterator = stores.iterator();
        while (iterator.hasNext()) {
            Store store = iterator.next();
            if (store.getName().equals(storeName)) {
                return store;
            }
        }
        throw new NotFoundStoreException("Tienda no encontrada en la cadena.");
    }

    public SimpleList<Store> getStores() {
        return stores;
    }
}
