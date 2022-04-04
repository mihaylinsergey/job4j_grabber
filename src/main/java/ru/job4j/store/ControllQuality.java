package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Store> list = new ArrayList<>();

    public void sort(List<Food> product) {
        if (list.isEmpty()) {
            list.add(new Warehouse());
            list.add(new Shop());
            list.add(new Trash());
        }
        for (Store store : list) {
            for (Food i : product) {
                if (store.accept(i)) {
                    store.add(i);
                }
            }
        }
    }

    public List<Food> getWarehouseList() {
        for (Store store : list) {
            if (store.getClass() == Warehouse.class) {
                return new ArrayList<>(store.getList());
            }
        }
        return null;
    }

}
