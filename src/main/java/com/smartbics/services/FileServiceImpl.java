package com.smartbics.services;

import com.smartbics.models.Log;
import com.smartbics.models.LogLevel;
import com.smartbics.utils.DataGenerator;
import com.smartbics.utils.DateTimeUtils;
import com.smartbics.utils.FileUtils;
import lombok.SneakyThrows;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public class FileServiceImpl implements FileService {

    @SneakyThrows
    public void fillUpFiles() {
        List<File> files = FileUtils.getLogFiles();
        if (files.isEmpty()) {
            int filesCount = new Random().nextInt(10);
            for (int i = 0; i < filesCount; i++) {
                File file = new File("/Users/isko/Desktop/Projects/smartbics/smartbics-test-task/src/main/resources/logs/log" + i + ".log");
                if (!file.exists()) {
                    file.createNewFile();
                }
                writeDataToFile(file);
            }
        }
    }

    @SneakyThrows
    private void writeDataToFile(File file) {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        List<Log> logs = DataGenerator.generateData();
        logs.forEach(log -> {
            try {
                writer.write(log + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.close();
    }

    @SneakyThrows
    public List<Log> getErrorLogs(File file) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.lines()
                .filter(line -> line.split(";")[1].equalsIgnoreCase("error"))
                .map(line -> {
                    String[] split = line.split(";");
                    LocalDateTime time = LocalDateTime.parse(split[0]);
                    LogLevel logLevel = LogLevel.valueOf(split[1]);
                    return new Log(time, logLevel, split[2]);
                }).collect(Collectors.toList());
    }

    @SneakyThrows
    public void writeDataToStatistic(Map<LocalDateTime, Integer> map) {
        File file = FileUtils.getStatisticFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Map.Entry<LocalDateTime, Integer> entry : map.entrySet()) {
            writer.write(DateTimeUtils.getOutput(entry.getKey()) + ", Errors count: " + entry.getValue() + "\n");
        }
        writer.close();
    }
}
