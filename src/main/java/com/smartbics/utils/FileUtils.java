package com.smartbics.utils;

import com.smartbics.models.Log;
import com.smartbics.models.LogLevel;
import lombok.SneakyThrows;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public class FileUtils {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static List<File> getLogFiles() {
        File file = new File(PROJECT_DIR + "/src/main/resources/logs");
        if (file.isDirectory()) {
            return Arrays.asList(file.listFiles());
        } else {
            throw new IllegalStateException("It is not a directory");
        }
    }

    @SneakyThrows
    public static File getStatisticFile() {
        File file = new File(PROJECT_DIR + "/src/main/resources/statistics/statistic.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }
}
