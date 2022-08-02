package com.example.tollfreecalculatordeepika;

import com.example.tollfreecalculatordeepika.bean.Vehicle;
import com.example.tollfreecalculatordeepika.implementation.VehicleTollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.tollfreecalculatordeepika.util.Constants.MAX_FEE_FOR_ONE_DAY;

@SpringBootApplication
@Configuration
public class TollFreeCalculatorDeepikaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TollFreeCalculatorDeepikaApplication.class, args);
    }
}
