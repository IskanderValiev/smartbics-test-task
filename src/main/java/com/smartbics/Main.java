package com.smartbics;

import com.smartbics.models.Log;
import com.smartbics.services.FileService;
import com.smartbics.services.FileServiceImpl;
import com.smartbics.services.StatisticService;
import com.smartbics.services.StatisticServiceImpl;
import com.smartbics.utils.FileUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public class Main {
    public static void main(String[] args) {
        List<Log> errors = new ArrayList<>();
        FileService fileService = new FileServiceImpl();
        fileService.fillUpFiles();
        FileUtils.getLogFiles()
                .forEach(file -> errors.addAll(fileService.getErrorLogs(file)));

        StatisticService service = new StatisticServiceImpl();
        Map<LocalDateTime, Integer> statistic = service.getStatistic(errors);
        fileService.writeDataToStatistic(statistic);
    }
}
