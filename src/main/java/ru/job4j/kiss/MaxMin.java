package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return modSort(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return modSort(value, comparator.reversed());
    }

    public <T> T modSort(List<T> value, Comparator<T> comparator) {
        T rsl = value.get(0);
        for (T i : value) {
            if (comparator.compare(rsl, i) >= 0) {
                rsl = i;
            }
        }
        return rsl;
    }
}