package ru.job4j.store;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface Store {

    void add(Food product);

    List<Food> getList();

    boolean accept(Food food);

    default double checkDate(Food product, LocalDate localDate) {
        double data1 = Duration.between(product.getCreateDate().atStartOfDay(), localDate.atStartOfDay()).toDays();
        double data2 = Duration.between(product.getCreateDate().atStartOfDay(), product.getExpiryDate().atStartOfDay()).toDays();
        return (data1 / data2) * 100;
    }
}
