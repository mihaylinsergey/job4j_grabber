package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(cachingDir + key))) {
            int read;
            while ((read = in.read()) != -1) {
                rsl.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl.toString();
    }

}