package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace implements Parking {

    private List<Vehicle> parkingCars;
    private List<Vehicle> parkingTracks;
    private int parkingCarsSize = 0;
    private int parkingTracksSize = 0;

    public ParkingPlace(int cars, int tracks) {
        parkingCars = new ArrayList<>(cars);
        parkingTracks = new ArrayList<>(tracks);
        parkingCarsSize = cars;
        parkingTracksSize = tracks;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public void leave(Vehicle vehicle) {

    }

    @Override
    public int parkingCarsSize() {
        return 0;
    }

    @Override
    public int parkingTracksSize() {
        return 0;
    }

    @Override
    public int getParkingCarsSize() {
        return 0;
    }

    @Override
    public int getParkingTracksSize() {
        return 0;
    }

    @Override
    public int checkSize() {
        return 0;
    }
}
