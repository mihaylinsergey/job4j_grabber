package ru.job4j.ood.ocp;

public class Cat {

    public void run() {
        System.out.println("running on the ground");
    }

    public class Maus extends Cat {
        public void run() {
            System.out.println("running under the floor");
        }
    }
}
/* В этом случае принцип OCP нарушен из-за некорректного применения наследования классов,
необходимо создать отдельный интерфейс с методом run() */