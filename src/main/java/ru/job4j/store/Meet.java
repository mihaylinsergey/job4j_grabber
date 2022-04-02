package ru.job4j.store;

import java.time.LocalDate;

public class Meet extends Food {

    public Meet(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
