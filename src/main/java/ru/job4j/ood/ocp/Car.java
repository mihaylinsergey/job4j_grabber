package ru.job4j.ood.ocp;

public class Car {

    public void road() {
    }

    public class Body {

        public void set() {
            System.out.println("Sedan");
        }
    }

    public class Lada extends Car {

        private Body body = new Body();

        @Override
        public void road() {
            super.road();
        }
    }
}
/* В данном случае нарушение принципа OCP выражается в использовании поля Body body,
которое накладывает ограничение в классе Lada в рамках применяего в нем метода set().
Для устранения нарушения необходимо применить иинтерфейс и передать его в поле класса Lada */