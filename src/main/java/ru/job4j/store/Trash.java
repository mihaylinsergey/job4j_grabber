package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> list = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            list.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean accept(Food food) {
        return  checkDate(food) >= 100;
    }
}
