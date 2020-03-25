package com.smartbics.models;

import lombok.*;

import java.time.LocalDate;

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
public class Statistic {

    private LocalDate date;
}
