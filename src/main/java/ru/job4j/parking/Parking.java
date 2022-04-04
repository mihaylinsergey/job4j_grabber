package ru.job4j.parking;

public interface Parking {

    boolean park(Vehicle vehicle);

    void leave(Vehicle vehicle);

    int parkingCarsSize();

    int parkingTracksSize();

    int getParkingCarsSize();

    int getParkingTracksSize();

    int checkSize();
    }
