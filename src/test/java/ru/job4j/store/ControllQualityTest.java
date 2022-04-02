package ru.job4j.store;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void sort() {
        ControllQuality controllQuality = new ControllQuality();
        Food sausage = new Meet("Sausage",
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2022, 1, 1),
                1000, 0);
        Food bread = new Bread("Bread",
                LocalDate.of(2022, 2, 15),
                LocalDate.of(2022, 2, 1),
                40, 0);
        Food milk = new Milk("Milk",
                LocalDate.of(2022, 4, 01),
                LocalDate.of(2022, 3, 31),
                60, 0);
        Food meet = new Meet("Meet",
                LocalDate.of(2022, 4, 4),
                LocalDate.of(2022, 3, 25),
                600, 0);
        List<Food> products = new ArrayList(List.of(sausage, bread, milk, meet));
        controllQuality.sort(products);
        assertThat(controllQuality.getWarehouse().getList(), is(List.of(sausage)));
        assertThat(controllQuality.getShop().getList(), is(List.of(meet)));
        assertThat(controllQuality.getTrash().getList(), is(List.of(bread, milk)));
    }
}