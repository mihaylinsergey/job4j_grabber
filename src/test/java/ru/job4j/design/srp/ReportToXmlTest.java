package ru.job4j.design.srp;

import org.junit.Ignore;
import org.junit.Test;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.TimeZone;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportToXmlTest {

    @Ignore
    @Test
    public void whenReportToXml() {
        MemStore store = new MemStore();
        Calendar date = Calendar.getInstance();
        date.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee worker = new Employee("Ivan", date, date, 100);
        store.add(worker);
        Report engine = new ReportToXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(System.lineSeparator())
                .append("<Employee>")
                .append(System.lineSeparator())
                .append("    <employees>")
                .append(System.lineSeparator())
                .append("        <fired>" + date + "</fired>")
                .append(System.lineSeparator())
                .append("        <hired>" + date + "</hired>")
                .append(System.lineSeparator())
                .append("        <name>Ivan</name>")
                .append(System.lineSeparator())
                .append("        <salary>100.0</salary>")
                .append(System.lineSeparator())
                .append("    </employees>")
                .append(System.lineSeparator())
                .append("</Employee>")
                .append(System.lineSeparator());
         assertThat(engine.generate(em -> true), is(expect.toString()));
        }
    }
