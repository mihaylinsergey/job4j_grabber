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
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");
    private static final DateTimeFormatter TEMP_FORMATTER = DateTimeFormatter.ofPattern("yy-MM-dd");
    private static final String TODAY = "сегодня";
    private static final String YESTERDAY = "вчера";

    @Override
    public LocalDateTime parse(String parse) {
        LocalDateTime rsl = null;
        LocalDate date = LocalDate.now();
        String[] dataParse = parse.split(",");
        if (TODAY.contains(dataParse[0])) {
            String text = date.format(TEMP_FORMATTER);
            rsl = LocalDateTime.parse(text + dataParse[1], FORMATTER);
        } else if (YESTERDAY.contains(dataParse[0])) {
            String text = date.minusDays(1).format(TEMP_FORMATTER);
            rsl = LocalDateTime.parse(text + dataParse[1], FORMATTER);
        } else {
            String[] dataParseThen = dataParse[0].split(" ");
            int year = Integer.parseInt(dataParseThen[2]);
            int month = Integer.parseInt(MONTHS.get(dataParseThen[1]));
            int day  = Integer.parseInt(dataParseThen[0]);
            date = LocalDate.of(year, month, day);
            String text = date.format(TEMP_FORMATTER);
            rsl = LocalDateTime.parse(text + dataParse[1], FORMATTER);
        }
        return rsl;
    }
}