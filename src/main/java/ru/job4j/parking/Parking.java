package ru.job4j.parking;

public interface Parking {

    boolean park(Vehicle vehicle);

    int getParkingCarsSize();

    int getParkingTracksSize();

    }
