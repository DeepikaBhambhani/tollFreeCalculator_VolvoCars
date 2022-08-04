package com.example.tollfreecalculator.model;

import static com.example.tollfreecalculator.util.Constants.FOREIGN;

public class Foreign implements Vehicle{
    @Override
    public String getVehicle() {
        return FOREIGN;
    }
}
