package com.example.tollfreecalculator;

import com.example.tollfreecalculator.model.Car;
import com.example.tollfreecalculator.model.Vehicle;
import com.example.tollfreecalculator.controller.TollCalculatorServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.example.tollfreecalculator.util.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TollTestForNullParamExecutionTests {
    private final TollCalculator tollCalculator;
    private static LocalDate date;
    private static Vehicle car;

    public TollTestForNullParamExecutionTests() {
        this.tollCalculator = new TollCalculator(new TollCalculatorServiceImpl());
    }

    @BeforeAll
    private static void initDate() {
        date = LocalDate.of(2021, 12, 17);
        car = new Car();
    }


    @Test
    @DisplayName("Null vehicle parameter test")
    public void nullParamVehicleTest() {
        RuntimeException re = assertThrows(RuntimeException.class,
                () -> tollCalculator.getTollFee(null,
                        List.of(LocalDateTime.of(date, LocalTime.of(6, 0)))
                                ));
        assertEquals(VEHICLE_NULL_MSG, re.getMessage());
    }


    @Test
    @DisplayName("Date parameter null test")
    public void nullParamDatesTest() {
        RuntimeException re = assertThrows(RuntimeException.class,
                () -> tollCalculator.getTollFee(car, null));
        assertEquals(DATES_NULL_MSG, re.getMessage());
    }


    @Test
    @DisplayName("Multiple date test")
    public void differentDatesTest() {
        RuntimeException re = assertThrows(RuntimeException.class,
                () -> tollCalculator.getTollFee(car,
                        List.of(LocalDateTime.of(2022, 8, 10, 7, 0),
                                        LocalDateTime.of(2022, 8, 11, 7, 0))
                                ));
        assertEquals(MORE_THAN_ONE_DAY_MSG, re.getMessage());
    }
}
