package ru.job4j.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> list = new ArrayList<>();
    private LocalDate localDate = LocalDate.now();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            if (checkDate(food) >= 75) {
                food.setPrice(food.getPrice() * (1 - food.getDiscount() / 100));
            }
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
        return  checkDate(food) > 25 && checkDate(food) < 100;
    }
}
