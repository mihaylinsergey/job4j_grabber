package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    List<Food> list = new ArrayList<>();

    @Override
    public void add(Food product) {
        list.add(product);
    }

    @Override
    public List<Food> getList() {
        return list;
    }
}
