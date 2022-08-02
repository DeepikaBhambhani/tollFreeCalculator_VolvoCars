package com.example.tollfreecalculatordeepika.bean;

import static com.example.tollfreecalculatordeepika.util.Constants.CAR;

public class Car implements Vehicle {
    @Override
    public String getVehicle() {
        return CAR;
    }
}
