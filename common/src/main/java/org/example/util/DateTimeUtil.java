package org.example.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String formatLocalDateTime(LocalDateTime dateTime) {
        return formatDate(dateTime.toLocalDate()) + " " + formatTime(dateTime.toLocalTime());
    }

    public static String formatDate(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        return date.format(dateFormatter);
    }

    public static String formatTime(LocalTime time) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(timeFormatter);
    }

    public static LocalDateTime parse(String origin) {
        return LocalDateTime.parse(origin, DateTimeFormatter.ofPattern("yyyy-MM-dd H:m"));
    }
}
