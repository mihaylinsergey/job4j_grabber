package ru.job4j.ood.ocp.dip;

public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }
}

class Racing {

    Car car = new Car("Lada");
}

/* Нарушение принципа DIP: класс Racing зависит от конкретной реализации класса Car,
необходмо задать класс Car путем абстрации */