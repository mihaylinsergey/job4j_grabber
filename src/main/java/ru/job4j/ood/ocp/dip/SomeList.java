package ru.job4j.ood.ocp.dip;

import java.util.ArrayList;
import java.util.List;

public class SomeList {

    private List<Integer> list = new ArrayList<>();

    public SomeList(List<Integer> list) {
        this.list = list;
    }
}
/* Нарушение принципа DIP: в поле класса находися конкретная реализация List<Integer>,
что не даст нам возможности изменить реализацию класса */