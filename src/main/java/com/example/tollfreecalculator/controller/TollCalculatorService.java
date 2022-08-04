package com.example.tollfreecalculator.controller;

import com.example.tollfreecalculator.model.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TollCalculatorService {
    boolean isTollFreeVehicle(Vehicle vehicle);
    boolean isTollFreeDate(LocalDate date);
    boolean isValid(Vehicle vehicle, List<LocalDateTime> dates);
}
