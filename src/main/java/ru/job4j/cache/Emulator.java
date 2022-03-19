package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название директории, например, ./data/");
        String dir = in.nextLine();
        System.out.println("Введите название файла, например, Names.txt или Address.txt");
        String file = in.nextLine();
        DirFileCache example = new DirFileCache(dir);
        System.out.println(example.get(file));
    }
}
