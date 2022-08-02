package com.example.tollfreecalculatordeepika.service;

import com.example.tollfreecalculatordeepika.bean.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VehicleTollService {
    boolean isTollFreeVehicle(Vehicle vehicle);
    boolean isTollFreeDate(LocalDate date);
    boolean isValid(Vehicle vehicle, List<LocalDateTime> dates);
}
