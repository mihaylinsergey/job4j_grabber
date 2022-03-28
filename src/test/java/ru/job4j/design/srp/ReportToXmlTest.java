package ru.job4j.design.srp;

import com.google.gson.GsonBuilder;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportToXmlTest {

    @Test
    public void whenReportToXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportToXml(store);
        String expect = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new Employees(List.of(worker)), writer);
            expect = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
            assertThat(engine.generate(em -> true), is(expect));
        }
    }
}