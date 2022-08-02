package com.example.tollfreecalculatordeepika;


import com.example.tollfreecalculatordeepika.bean.*;
import com.example.tollfreecalculatordeepika.implementation.VehicleTollServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class TollCalculatorForFreeDayApplicationTest {
    @Autowired
    private static  TollCalculator tollCalculator;
    private static LocalDate date;
    private static Vehicle car;


    @BeforeAll
    private static void initDate() {
        car = new Car();
    }

    @Test
    private static void weekendTollTest(){
        List<LocalDateTime> dates = new ArrayList<>();
        date = LocalDate.of(2022, 7, 31);
        dates.add(LocalDateTime.of(date, LocalTime.of(12,52)));
        dates.add(LocalDateTime.of(date, LocalTime.of(13,52)));
        dates.add(LocalDateTime.of(date, LocalTime.of(14,52)));
        assertEquals(0,tollCalculator.getTollFee(car,dates));
    }
    @Test
    private void freeDateTollTest() {
        int year=LocalDate.now().getYear();
        date = LocalDate.of(2022, 01, 01);
        List<LocalDateTime> dateList=new ArrayList<>();
        dateList.add(LocalDateTime.of(date,LocalTime.of(12,52)));
        dateList.add(LocalDateTime.of(date,LocalTime.of(15,52)));
        assertEquals(0,  tollCalculator.getTollFee(car, dateList));

    }

    @Test
    private void tollFreeVehicles(){

        List<LocalDateTime> dateList=new ArrayList<>();
        date = LocalDate.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth());
        dateList.add(LocalDateTime.of(date, LocalTime.of(12,52)));
        dateList.add(LocalDateTime.of(date, LocalTime.of(13,52)));
        dateList.add(LocalDateTime.of(date, LocalTime.of(14,52)));
        Vehicle  emergency=new Emergency();
        Vehicle  diplomat=new Diplomat();
        Vehicle  foreign=new Foreign();
        Vehicle  military=new Military();
        Vehicle  motorbike=new Motorbike();
        Vehicle  tractor=new Tractor();
        assertEquals(0,  tollCalculator.getTollFee(diplomat, dateList));
        assertEquals(0,  tollCalculator.getTollFee(foreign, dateList));
        assertEquals(0,  tollCalculator.getTollFee(military, dateList));
        assertEquals(0,  tollCalculator.getTollFee(motorbike, dateList));
        assertEquals(0,  tollCalculator.getTollFee(tractor, dateList));
        assertEquals(0,  tollCalculator.getTollFee(emergency, dateList));

    }

}
