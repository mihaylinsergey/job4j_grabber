package ru.job4j.ood.ocp.lsp;

public class Bird {
    public void fly() {
    }
}

class Duck extends Bird {
    @Override
    public void fly() {
        super.fly();
    }
}

class Ostrich extends Bird {
}
/* Утка может летать (использовать метод fly()). А страус - подтип класса Птица, летать не умеет,
не может использовать метод fly() ,что нарушает принцип LSP (инвариантность) */
