package com.smartbics.models;

import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Iskander Valiev
 * created by isko
 * on 3/25/20
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {

    private LocalDateTime date;

    private LogLevel level;

    private String message;

    @Override
    public String toString() {
        return date + ";" + level + ";" + message;
    }
}
