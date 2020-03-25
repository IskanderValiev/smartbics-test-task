package com.smartbics.services;

import com.smartbics.models.Log;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
public interface StatisticService {
    Map<LocalDateTime, Integer> getStatistic(List<Log> logs);
}
