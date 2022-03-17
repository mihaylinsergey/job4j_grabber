package ru.job4j.cache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache example = new DirFileCache("./data/");
        System.out.println(example.get("Names.txt"));
        System.out.println(example.get("Address.txt"));
    }
}
