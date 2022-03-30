package ru.job4j.ood.ocp.lsp;

public class Elevator {

    public void elevate(int weight) {
    if (weight > 350) {
        throw new IllegalArgumentException("Excess weight!");
    }
        /* other logic */
    }
}

class SmallElevator extends Elevator {
    @Override
    public void elevate(int weight) {
        if (weight > 150) {
            throw new IllegalArgumentException("Excess weight!");
        }
        /* other logic */
    }
}
/* Нарушение принципа LSP по причине усиления предусловия в методе elevate(int weight) */