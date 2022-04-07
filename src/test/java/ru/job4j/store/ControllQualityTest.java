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
                LocalDate.now().plusDays(100),
                LocalDate.now().minusDays(20),
                1000, 0);
        Food bread = new Bread("Bread",
                LocalDate.now().plusDays(9),
                LocalDate.now().minusDays(4),
                40, 0);
        Food milk = new Milk("Milk",
                LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(4),
                60, 0);
        List<Food> products = new ArrayList(List.of(sausage, bread, milk));
        List<Store> stores = new ArrayList<>(List.of(new Warehouse(), new Shop(), new Trash()));
        controllQuality.sort(stores, products);
        assertThat(controllQuality.getStoreList().get(0).getList(), is(List.of(sausage)));
        assertThat(controllQuality.getStoreList().get(1).getList(), is(List.of(bread)));
        assertThat(controllQuality.getStoreList().get(2).getList(), is(List.of(milk)));
    }

    @Test
    public void checkDiscount() {
        ControllQuality controllQuality = new ControllQuality();
        Food milk = new Milk("Milk",
                LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(4),
                120, 30);
        List<Food> products = new ArrayList(List.of(milk));
        List<Store> stores = new ArrayList<>(List.of(new Shop()));
        controllQuality.sort(stores, products);
        assertThat(controllQuality.getStoreList().get(0).getList(), is(List.of(new Milk("Milk",
                LocalDate.now().plusDays(1),
                LocalDate.now().minusDays(4),
                84, 30))));
    }

    @Test
    public void resort() {
        ControllQuality controllQuality = new ControllQuality();
        Food sausage = new Meet("Sausage",
                LocalDate.now().plusDays(100),
                LocalDate.now().minusDays(20),
                1000, 0);
        Food bread = new Bread("Bread",
                LocalDate.now().plusDays(9),
                LocalDate.now().minusDays(4),
                40, 0);
        Food milk = new Milk("Milk",
                LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(4),
                60, 0);
        List<Food> products = new ArrayList(List.of(sausage, bread, milk));
        List<Store> stores = new ArrayList<>(List.of(new Warehouse(), new Shop(), new Trash()));
        controllQuality.sort(stores, products);
        controllQuality.resort(List.of(new Warehouse(), new Shop(), new Trash()));
       assertThat(controllQuality.getStoreList().get(0).getList(), is(List.of(sausage)));
       assertThat(controllQuality.getStoreList().get(1).getList(), is(List.of(bread)));
       assertThat(controllQuality.getStoreList().get(2).getList(), is(List.of(milk)));
    }

}