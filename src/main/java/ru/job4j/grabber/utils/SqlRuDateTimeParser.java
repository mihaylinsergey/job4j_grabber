package ru.job4j.grabber.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static java.util.Map.entry;

public class SqlRuDateTimeParser implements DateTimeParser {

    private static final Map<String, String> MONTHS = Map.ofEntries(
            entry("янв", "1"),
            entry("фев", "2"),
            entry("мар", "3"),
            entry("апр", "4"),
            entry("май", "5"),
            entry("июн", "6"),
            entry("июл", "7"),
            entry("авг", "8"),
            entry("сен", "9"),
            entry("окт", "10"),
            entry("ноя", "11"),
            entry("дек", "12")
    );

    @Override
    public LocalDateTime parse(String parse) {
        LocalDateTime rsl = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
        DateTimeFormatter formatterTemp = DateTimeFormatter.ofPattern("yy-MM-dd");
        String[] dataParse = parse.split(",");
        if ("сегодня".contains(dataParse[0])) {
            LocalDate date = LocalDate.now();
            String text = date.format(formatterTemp);
            rsl = LocalDateTime.parse(text + dataParse[1], formatter);
        } else if ("вчера".contains(dataParse[0])) {
            LocalDate date = LocalDate.now().minusDays(1);
            String text = date.format(formatterTemp);
            rsl = LocalDateTime.parse(text + dataParse[1], formatter);
        } else {
            String[] dataParseThen = dataParse[0].split(" ");
            int year = Integer.parseInt(dataParseThen[2]);
            int month = Integer.parseInt(MONTHS.get(dataParseThen[1]));
            int day  = Integer.parseInt(dataParseThen[0]);
            LocalDate date = LocalDate.of(year, month, day);
            String text = date.format(formatterTemp);
            rsl = LocalDateTime.parse(text + dataParse[1], formatter);
        }
        return rsl;
    }
}