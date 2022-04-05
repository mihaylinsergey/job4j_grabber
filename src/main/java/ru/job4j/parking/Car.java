package ru.job4j.parking;

public class Car extends Vehicle {

    public static final int SIZE = 1;

    public Car() {
        super.setSize(SIZE);
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
