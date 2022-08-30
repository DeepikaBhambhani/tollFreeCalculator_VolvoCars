package com.example.tollfreecalculator.model;

import static com.example.tollfreecalculator.util.Constants.MOTORCYCLE;

public class Motorcycle implements Vehicles {
    @Override
    public String getVehicle() {
        return MOTORCYCLE;
    }
}
