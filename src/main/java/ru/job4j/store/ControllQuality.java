package ru.job4j.store;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControllQuality {

    private Store warehouse = new Warehouse();
    private Store shop = new Shop();
    private Store trash = new Trash();
    private LocalDate localDate = LocalDate.now();

    public void sort(List<Food> product) {
        for (Food i : product) {
          if (checkDate(i) <= 25) {
            warehouse.add(i);
          } else if (checkDate(i) > 25 && checkDate(i) < 75) {
            shop.add(i);
         } else if (checkDate(i) >= 75 && checkDate(i) < 100) {
            i.setDiscount(new Discount().discount);
            shop.add(i);
         } else {
            trash.add(i);
         }
        }
    }

    private double checkDate(Food product) {
        double data1 = Duration.between(product.getCreateDate().atStartOfDay(), localDate.atStartOfDay()).toDays();
        double data2 = Duration.between(product.getCreateDate().atStartOfDay(), product.getExpiryDate().atStartOfDay()).toDays();
        return (data1 / data2) * 100;
    }

    public Store getWarehouse() {
        return warehouse;
    }

    public Store getShop() {
        return shop;
    }

    public Store getTrash() {
        return trash;
    }

    public static void main(String[] args) {
        ControllQuality example = new ControllQuality();
        List<Food> products = new ArrayList<>();
        Food prod = new Meet("Sausage",
                        LocalDate.of(2022, 12, 1),
                        LocalDate.of(2022, 1, 1),
                        1000, 0);
        System.out.println(prod);
        products.add(prod);
    }
}
