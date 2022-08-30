package com.example.tollfreecalculator.controller;

import com.example.tollfreecalculator.model.Vehicles;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TollCalculatorService {
    boolean isTollFreeVehicle(Vehicles vehicles);
    boolean isTollFreeDate(LocalDate date);
    boolean isValid(Vehicles vehicles, List<LocalDateTime> dates);
}
