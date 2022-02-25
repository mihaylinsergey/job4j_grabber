package ru.job4j.gc;

public class User {

    private int age;
    private String firstName;
    private String secondName;

    public User(int age, String firstName, String secondName) {
        this.age = age;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Removed %d %s %s%n", age, firstName, secondName);
    }

     public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new User(i, "F" + i, "S" + i);
            System.gc();
        }
    }
}