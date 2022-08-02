package com.example.tollfreecalculatordeepika;

import com.example.tollfreecalculatordeepika.bean.Vehicle;
import com.example.tollfreecalculatordeepika.implementation.VehicleTollServiceImpl;
import com.example.tollfreecalculatordeepika.service.VehicleTollService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.tollfreecalculatordeepika.util.Constants.*;

public class TollCalculator {

    private VehicleTollServiceImpl vehicleTollService;

    public TollCalculator(VehicleTollServiceImpl vehicleTollService) {
        this.vehicleTollService = vehicleTollService;
    }
    public int getTollFee(Vehicle vehicle, List<LocalDateTime> dates) {

        if (!vehicleTollService.isValid(vehicle, dates)) {
            return 0;
        }

        List<LocalTime> validTimeList = dates.stream()
                .map(LocalDateTime::toLocalTime)
                .filter(time -> vehicleTollService.getFee(time) > 0)
                .sorted()
                .collect(Collectors.toList());

        if (validTimeList.isEmpty()) {
            return 0;
        }

        LocalDateTime intervalStart = dates.get(0);
        int totalFee = 0;
        for (LocalDateTime date : dates) {
            double nextFee = vehicleTollService.getFee(date.toLocalTime());
            double tempFee = vehicleTollService.getFee(intervalStart.toLocalTime());
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


