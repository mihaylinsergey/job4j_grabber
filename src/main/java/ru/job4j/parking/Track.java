package ru.job4j.parking;

public class Track extends Vehicle {

    public Track(int size) {
        super.setSize(size);
    }

    @Override
    public String toString() {
        return "Track{}"
                + "SIZE"
                + super.getSize();
    }
}
