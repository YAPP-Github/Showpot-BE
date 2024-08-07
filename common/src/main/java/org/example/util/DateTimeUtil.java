package org.example.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    public static String formatLocalDateTime(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return dateTime.format(dateFormatter) + dateTime.format(timeFormatter);
    }

}
