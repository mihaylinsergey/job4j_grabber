package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportToJsonTest {

    @Test
    public void whenReportToJson() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, Calendar.MARCH, 30);
        now.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        String gsonDate = new GsonBuilder().create().toJson(now);
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToJson(store);
        StringBuilder expect = new StringBuilder()
                .append("[{\"name\":\"Ivan\",\"hired\":")
                .append("{\"year\":2022,\"month\":2,\"dayOfMonth\":30,\"hourOfDay\":0,\"minute\":0,\"second\":0}")
                .append(",\"fired\":")
                .append("{\"year\":2022,\"month\":2,\"dayOfMonth\":30,\"hourOfDay\":0,\"minute\":0,\"second\":0}")
                .append(",\"salary\":100.0}]");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}