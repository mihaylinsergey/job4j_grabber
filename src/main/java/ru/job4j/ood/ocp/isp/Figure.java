package ru.job4j.ood.ocp.isp;

public interface Figure {

    void draw();

    void print();

    void getRadius();

    void getPerimeter();
}
/* Здесь нарушение приципа ISP: в интерфейсе использутся методы,
 которые свойственны разным фигурам.
 Например, логично выделить определение радиуса фигуры в один интерфейс,
 а определение периметра фигуры в другой */