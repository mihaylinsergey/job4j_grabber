package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace implements Parking {

    private List<Vehicle> parkingCars;
    private List<Vehicle> parkingTracks;
    private int parkingCarsSize = 0;
    private int parkingTracksSize = 0;
    private int carsCounter = 0;
    private int tracksCounter = 0;

    public ParkingPlace(int cars, int tracks) {
        parkingCars = new ArrayList<>(cars);
        parkingTracks = new ArrayList<>(tracks);
        parkingCarsSize = cars;
        parkingTracksSize = tracks;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean rsl = false;
        int size = vehicle.getSize();
        if (vehicle.getSize() == 1) {
            if (parkingCarsSize > 0) {
                parkingCars.add(vehicle);
                parkingCarsSize--;
                carsCounter++;
                rsl = true;
            }
        }
        if (vehicle.getSize() >= 2) {
            if (parkingTracksSize  > 0) {
                parkingTracks.add(vehicle);
                parkingTracksSize--;
                tracksCounter++;
                rsl = true;
            } else if (parkingCarsSize >= size) {
                parkingCars.add(vehicle);
                parkingCarsSize = parkingCarsSize - size;
                carsCounter = carsCounter + size;
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public int getParkingCarsSize() {
        return carsCounter;
    }

    @Override
    public int getParkingTracksSize() {
        return tracksCounter;
    }
}
