package ru.job4j.ood.ocp.isp;

public interface Car {
    void drive();

    void honk();

    void openFrontDoors();

    void openBackDoors();

    void openTrunk();

}
 /* Здесь нарушение приципа ISP: интерфейс перегружен методами,
 пользователю может понадобиться только часть из них, а остальные придется "глушить" */
