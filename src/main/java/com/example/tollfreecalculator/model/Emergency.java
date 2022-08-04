package com.example.tollfreecalculator.model;

import static com.example.tollfreecalculator.util.Constants.EMERGENCY;

public class Emergency implements Vehicle {
    @Override
    public String getVehicle() {
        return EMERGENCY;
    }
}
