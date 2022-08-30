package com.example.tollfreecalculator.model;

import static com.example.tollfreecalculator.util.Constants.CAR;

public class Car implements Vehicles {
    @Override
    public String getVehicle() {
        return CAR;
    }
}
