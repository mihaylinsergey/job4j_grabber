package ru.job4j.design.srp;

import org.junit.Ignore;
import org.junit.Test;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportToXmlTest {

    @Ignore
    @Test
    public void whenReportToXml() {
        MemStore store = new MemStore();
        Calendar now = new GregorianCalendar(2022, Calendar.MARCH, 30);
        now.setTimeZone(TimeZone.getTimeZone(ZoneOffset.of("+3")));
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToXml(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append(System.lineSeparator())
                .append("<Employee>")
                .append(System.lineSeparator())
                .append("    <employees>")
                .append(System.lineSeparator())
                .append("        <fired>2022-03-30T00:00:00+03:00</fired>")
                .append(System.lineSeparator())
                .append("        <hired>2022-03-30T00:00:00+03:00</hired>")
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
