package ru.job4j.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> list = new ArrayList<>();
    private LocalDate localDate = LocalDate.now();

    @Override
    public void add(Food food) {
        if (accept(food)) {
            list.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean accept(Food food) {
        if (checkDate(food, localDate) < 25) {
            return true;
        }
        return false;
    }
}
