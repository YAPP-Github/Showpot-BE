package org.example.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeUtil {

    public static String formatLocalDateTime(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("M월 d일");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String dayOfWeek = dateTime
            .getDayOfWeek()
            .getDisplayName(TextStyle.FULL, Locale.KOREAN)
            .substring(0, 1);

        return dateTime.format(dateFormatter) + " (" + dayOfWeek + ") " + dateTime.format(timeFormatter);
    }

}
