package ru.job4j.ood.ocp;

public class Salary {

    public double calculate(int days) {
        return 5000 * days;
    }
}
/* Нарушение принципа OCP по причине невозможности расширения функционала
расчета зарплаты в методе calculate(int days) */