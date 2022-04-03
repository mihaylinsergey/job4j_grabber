package ru.job4j.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Store> list = new ArrayList<>();
    private Store warehouse = new Warehouse();
    private Store shop = new Shop();
    private Store trash = new Trash();
    private LocalDate localDate = LocalDate.now();

    public void sort(List<Food> product) {
        for (Food i : product) {
            if (warehouse.accept(i)) {
                warehouse.add(i);
            } else if (shop.accept(i)) {
                shop.add(i);
            } else if (trash.accept(i)) {
                trash.add(i);
            }
        }
    }

    public Store getWarehouse() {
        return warehouse;
    }

    public Store getShop() {
        return shop;
    }

    public Store getTrash() {
        return trash;
    }

}
