package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private List<Store> list = new ArrayList<>();

    public void sort(List<Store> stores, List<Food> product) {
        list.addAll(stores);
        for (Food i : product) {
            for (Store store : list) {
                if (store.accept(i)) {
                    store.add(i);
                }
            }
        }
    }

    public List<Store> getStoreList() {
        return new ArrayList<>(list);
    }

}
