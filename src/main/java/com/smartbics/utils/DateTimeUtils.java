package com.smartbics.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public class DateTimeUtils {

    public static LocalDateTime getRandomTime() {
        long minDay = LocalDateTime.of(2019, Month.JANUARY, 1, 0, 0)
                .atZone(ZoneId.systemDefault()).toEpochSecond() * 1000;
        long maxDay = LocalDateTime.of(2020, Month.JANUARY, 1, 0, 0)
                .atZone(ZoneId.systemDefault()).toEpochSecond() * 1000;
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(randomDay), ZoneId.systemDefault());
    }

    public static LocalDateTime getHour(LocalDateTime time) {
        LocalDateTime of = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), time.getHour(), 0);
        return of;
    }

    public static LocalDateTime getNextHour(LocalDateTime time) {
        LocalDateTime nextHour = time.plusHours(1);
        LocalDateTime of = LocalDateTime.of(nextHour.getYear(), nextHour.getMonth(), nextHour.getDayOfMonth(), nextHour.getHour(), 0);
        return of;
    }

    public static String getOutput(LocalDateTime time) {
        LocalDateTime hour = getHour(time);
        LocalDateTime nextHour = getNextHour(time);
        String dateFormatted = hour.format(DateTimeFormatter.ofPattern("yyyy-dd-MM, HH:mm"));
        String nextHourFormatted = nextHour.format(DateTimeFormatter.ofPattern("HH:mm"));
        return dateFormatted + "-" + nextHourFormatted;
    }
}
