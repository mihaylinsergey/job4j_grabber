package ru.job4j.srp;

import java.util.ArrayList;
import java.util.List;

public class MemStore {
    private List<String> list = new ArrayList<>();

    public void add(String element) {
    }

    public void print(List<String> list) {
    }
    /* Метод print(List<String> list) нарушает принцип SRP */
}
