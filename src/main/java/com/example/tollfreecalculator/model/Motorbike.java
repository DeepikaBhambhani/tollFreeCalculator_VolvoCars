package com.example.tollfreecalculator.model;

import static com.example.tollfreecalculator.util.Constants.MOTORBIKE;

public class Motorbike implements Vehicle {
    @Override
    public String getVehicle() {
        return MOTORBIKE;
    }
}
