package ru.job4j.store;

import java.util.List;

public interface Store {

    void add(Food product);

    List<Food> getList();
}
