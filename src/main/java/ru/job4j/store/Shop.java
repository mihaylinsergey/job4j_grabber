package ru.job4j.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> list = new ArrayList<>();
    private LocalDate localDate = LocalDate.now();

    @Override
    public void add(Food food) {
        if (accept(food)) {
            if (checkDate(food, localDate) >= 75) {
                food.setDiscount(30);
                food.setPrice(food.getPrice() * 0.7);
            }
            list.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean accept(Food food) {
        if (checkDate(food, localDate) > 25 && checkDate(food, localDate) < 100) {
            return true;
        }
        return false;
    }
}
