package com.example.tollfreecalculator;

import com.example.tollfreecalculator.controller.TollCalculatorServiceImpl;
import com.example.tollfreecalculator.model.Car;
import com.example.tollfreecalculator.model.Vehicles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.tollfreecalculator.util.Constants.MAX_FEE_FOR_ONE_DAY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TollFreeCalculatorApplicationTests {

    private static  TollCalculator tollCalculator;
    private static LocalDate date;

    private static Vehicles car;

    TollFreeCalculatorApplicationTests() {
        tollCalculator=new TollCalculator(new TollCalculatorServiceImpl());
        car=new Car();
    }

    @BeforeAll
    private static void initialiseDate(){
        date= LocalDate.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth());
        //date=LocalDate.of(2022,8,01);

    }

    @Test
    @DisplayName("Toll test for vehicles travelling from midnight till morning")
    public void midnightMorningZeroFeeTimeTest() {
        List<LocalDateTime> dates = new ArrayList<>();
        // early morning time
        dates.add(LocalDateTime.of(date, LocalTime.of(0, 0))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(0, 59))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(1, 0))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(1, 59))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(2, 0))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(2, 59))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(3, 0))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(3, 59))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(4, 0))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(4, 59))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(5, 0))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(5, 59))); // 0
        //midnight time
        dates.add(LocalDateTime.of(date, LocalTime.of(18, 30))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(19, 10))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(20, 15))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(21, 20))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(22, 30))); // 0
        dates.add(LocalDateTime.of(date, LocalTime.of(23, 40))); // 0

        assertEquals(0, tollCalculator.getTollFee(car, dates));
    }

    @Test
    @DisplayName("Toll test for vehicles traveling in the morning")
    public void morningRushHourTollTest() {
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(LocalDateTime.of(date, LocalTime.of(6, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(6, 29)));
        dates.add(LocalDateTime.of(date, LocalTime.of(6, 50)));
        dates.add(LocalDateTime.of(date, LocalTime.of(7, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(7, 59)));
        dates.add(LocalDateTime.of(date, LocalTime.of(8, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(8, 29)));
        dates.add(LocalDateTime.of(date, LocalTime.of(8, 30)));
        dates.add(LocalDateTime.of(date, LocalTime.of(9, 0)));
        assertEquals(60, tollCalculator.getTollFee(car, dates));
    }

    @Test
    public void eveningRushHourTollTest() {
        List<LocalDateTime> dates = new ArrayList<>();

        dates.add(LocalDateTime.of(date, LocalTime.of(15, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(15, 30)));
        //total 22
        dates.add(LocalDateTime.of(date, LocalTime.of(16, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(16, 30)));
        //total 22
        dates.add(LocalDateTime.of(date, LocalTime.of(17, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(17, 30)));
        // total 16
        dates.add(LocalDateTime.of(date, LocalTime.of(18, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(18, 30)));

        //total 0
        assertEquals(60, tollCalculator.getTollFee(car, dates));
    }

    @Test
    @DisplayName("Maximum toll calculation in one day")
    public void MaxFeeCalcTest() {
        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(LocalDateTime.of(date, LocalTime.of(6, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(11, 35)));
        dates.add(LocalDateTime.of(date, LocalTime.of(12, 35)));
        dates.add(LocalDateTime.of(date, LocalTime.of(14, 35)));
        dates.add(LocalDateTime.of(date, LocalTime.of(15, 5)));
        dates.add(LocalDateTime.of(date, LocalTime.of(15, 30)));

        dates.add(LocalDateTime.of(date, LocalTime.of(16, 0)));
        dates.add(LocalDateTime.of(date, LocalTime.of(16, 30)));

        assertEquals(MAX_FEE_FOR_ONE_DAY, tollCalculator.getTollFee(car, dates));
    }


}
