package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.Calendar;

public class ReportForHrTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 100);
        Employee workerTwo = new Employee("Petr", now, now, 500);
        Employee workerThree = new Employee("Olga", now, now, 150);
        store.add(workerOne);
        store.add(workerTwo);
        store.add(workerThree);
        Report engine = new ReportForHr(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerTwo.getName()).append(";")
                .append(workerTwo.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerThree.getName()).append(";")
                .append(workerThree.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(workerOne.getName()).append(";")
                .append(workerOne.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}