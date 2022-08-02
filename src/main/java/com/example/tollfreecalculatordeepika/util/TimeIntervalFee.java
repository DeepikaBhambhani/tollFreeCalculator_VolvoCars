package com.example.tollfreecalculatordeepika.util;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Accessors(chain = true)
public class TimeIntervalFee {
    private LocalTime startTime;
    private LocalTime endTime;
    private double fee;
}
