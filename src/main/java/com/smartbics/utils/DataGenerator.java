package com.smartbics.utils;

import com.smartbics.models.Log;
import com.smartbics.models.LogLevel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public class DataGenerator {

    public static List<Log> generateData() {
        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            LocalDateTime time = DateTimeUtils.getRandomTime();
            int level = new Random().nextInt(3);
            LogLevel logLevel = LogLevel.values()[level];
            logs.add(Log.builder()
                    .date(time)
                    .level(logLevel)
                    .message("this is " + logLevel.toString() + " level log")
                    .build());
        }
        return logs.stream().sorted(Comparator.comparing(Log::getDate)).collect(Collectors.toList());
    }
}
