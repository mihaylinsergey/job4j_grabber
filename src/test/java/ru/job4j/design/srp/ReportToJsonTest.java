package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportToJsonTest {

    @Test
    public void whenReportToJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        String gsonDate = new GsonBuilder().create().toJson(now);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToJson(store);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"Ivan\",\"hired\":")
                .append(gsonDate)
                .append(",\"fired\":")
                .append(gsonDate)
                .append(",\"salary\":100.0}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}