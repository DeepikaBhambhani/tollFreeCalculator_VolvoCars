package com.example.tollfreecalculator;

import com.example.tollfreecalculator.model.Vehicles;
import com.example.tollfreecalculator.controller.TollCalculatorServiceImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.tollfreecalculator.util.Constants.*;

public class TollCalculator {


    private TollCalculatorServiceImpl tollService;

    public TollCalculator(TollCalculatorServiceImpl tollService) {
        this.tollService = tollService;
    }

    //this method calculates toll fee depending on day,time of travel and type of vehicle
    public int getTollFee(Vehicles vehicles, List<LocalDateTime> dates) {

        if (!tollService.isValid(vehicles, dates)) {
            return 0;
        }

        List<LocalTime> validTimeList = dates.stream()
                .map(LocalDateTime::toLocalTime)
                .filter(time -> tollService.getFee(time) > 0)
                .sorted()
                .collect(Collectors.toList());

        if (validTimeList.isEmpty()) {
            return 0;
        }

        LocalDateTime intervalStart = dates.get(0);
        int totalFee = 0;
        for (LocalDateTime date : dates) {
            double nextFee = tollService.getFee(date.toLocalTime());
            double tempFee = tollService.getFee(intervalStart.toLocalTime());
            long minutes = ChronoUnit.MINUTES.between(intervalStart, date);

            if (minutes <= 60) {
                if (totalFee > 0) totalFee -= tempFee;
                if (nextFee >= tempFee) tempFee = nextFee;
                totalFee += tempFee;
            } else {
                totalFee += nextFee;
            }
        }
        if (totalFee > MAX_FEE_FOR_ONE_DAY) totalFee = MAX_FEE_FOR_ONE_DAY;
        return totalFee;
    }

}


