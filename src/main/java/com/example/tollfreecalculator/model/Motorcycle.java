package com.example.tollfreecalculator.model;

import static com.example.tollfreecalculator.util.Constants.MOTORCYCLE;

public class Motorcycle implements Vehicle {
    @Override
    public String getVehicle() {
        return MOTORCYCLE;
    }
}
