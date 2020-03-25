package com.smartbics.services;

import com.smartbics.models.Log;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface FileService {
    void fillUpFiles();
    List<Log> getErrorLogs(File file);
    void writeDataToStatistic(Map<LocalDateTime, Integer> map);
}
