package ru.job4j.ood.ocp.dip;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void add() {
    }
}

/* Нарушение принципа DIP: модель данных содержит также метод, который может измениться,
 необходимо выделить метод add() в отдельную абстракцию */