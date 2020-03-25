package com.smartbics.services;

import com.smartbics.models.Log;
import com.smartbics.utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public class StatisticServiceImpl implements StatisticService {

    public Map<LocalDateTime, Integer> getStatistic(List<Log> logs) {
        Map<LocalDateTime, Integer> map = new TreeMap<>();
        logs.forEach(log -> {
            LocalDateTime time = DateTimeUtils.getHour(log.getDate());
            map.merge(time, 1, Integer::sum);
        });
        return map;
    }
}
