package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.function.Predicate;

public class ReportToJson implements Report {

    private Store store;

    public ReportToJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employee = store.findBy(filter);
        Gson report = new GsonBuilder().create();
        return report.toJson(employee);
    }
}