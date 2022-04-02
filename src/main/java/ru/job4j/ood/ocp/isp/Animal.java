package ru.job4j.ood.ocp.isp;

public interface Animal {
    void run();

    void fly();
}

/* Здесь нарушение приципа ISP: не все звери умеют летать, необходимо разделение интерфейсов */