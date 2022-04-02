package ru.job4j.parking;

public interface Parking {

    void park(Vehicle vehicle);

    void leave(Vehicle vehicle);

    int getSize();

    int getParkingSize();

    int checkSize();
    }
