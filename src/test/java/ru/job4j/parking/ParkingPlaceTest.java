package ru.job4j.parking;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingPlaceTest {

    @Ignore
    @Test
    public void when2CarsAnd1Track() {
        Parking parking = new ParkingPlace(2, 1);
        Car red = new Car();
        Car blue = new Car();
        Track big = new Track(4);
        parking.park(red);
        parking.park(blue);
        parking.park(big);
        assertThat(parking.getParkingCarsSize(), is(2));
        assertThat(parking.getParkingTracksSize(), is(1));
    }

    @Ignore
    @Test
    public void when2Tracks() {
        Parking parking = new ParkingPlace(2, 1);
        Track big = new Track(4);
        Track small = new Track(2);
        parking.park(big);
        parking.park(small);
        assertThat(parking.getParkingCarsSize(), is(2));
        assertThat(parking.getParkingTracksSize(), is(1));
    }

    @Ignore
    @Test
    public void whenNoPlaceForCars() {
        Parking parking = new ParkingPlace(1, 1);
        Car red = new Car();
        Car blue = new Car();
        assertTrue(parking.park(red));
        assertFalse(parking.park(blue));
    }

    @Ignore
    @Test
    public void whenNoPlaceForTracks() {
        Parking parking = new ParkingPlace(0, 1);
        Track small = new Track(2);
        Track big = new Track(4);
        assertTrue(parking.park(small));
        assertFalse(parking.park(big));
    }
}