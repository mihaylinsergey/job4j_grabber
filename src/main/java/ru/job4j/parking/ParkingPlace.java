package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace implements Parking {

    private List<Vehicle> parking;
    private int parkingSize = 0;

    public ParkingPlace(int size) {
        parking = new ArrayList<>(size);
        parkingSize = size;
    }

    @Override
    public int getParkingSize() {
        return parkingSize;
    }

    @Override
    public void park(Vehicle vehicle) {

    }

    @Override
    public void leave(Vehicle vehicle) {

    }

    @Override
    public int getSize() {
        return parking.size();
    }

    @Override
    public int checkSize() {
        return 0;
    }
}
