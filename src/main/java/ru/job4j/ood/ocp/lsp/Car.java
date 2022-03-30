package ru.job4j.ood.ocp.lsp;

public class Car {

    public double accelerate(double time) {
        double speed = 0;
        /* some logic */
        if (speed < 100) {
            throw new IllegalArgumentException("Too slow!");
        }
        return speed;
    }
}

class OldCar extends Car {
    @Override
    public double accelerate(double time) {
        double speed = 0;
        /* some logic */
        if (speed < 150) {
            throw new IllegalArgumentException("Too slow!");
        }
        return speed;
    }
}

/* Нарушение принципа LSP по причине ослабления постусловия в методе accelerate(double time) */
