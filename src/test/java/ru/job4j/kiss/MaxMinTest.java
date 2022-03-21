package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        List<Integer> value = new ArrayList<>(List.of(1, 3, 2, 10, 0, 123));
        MaxMin example = new MaxMin();
        Integer rsl = example.max(value, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        Integer exp = 123;
        assertThat(rsl, is(exp));
    }

    @Test
    public void min() {
        List<Integer> value = new ArrayList<>(List.of(1, 3, 2, 10, 0, 123));
        MaxMin example = new MaxMin();
        Integer rsl = example.min(value, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        Integer exp = 0;
        assertThat(rsl, is(exp));
    }
}