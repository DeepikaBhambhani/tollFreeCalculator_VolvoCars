package com.example.tollfreecalculatordeepika.bean;


import com.example.tollfreecalculatordeepika.bean.Vehicle;

import static com.example.tollfreecalculatordeepika.util.Constants.EMERGENCY;

public class Emergency implements Vehicle {
    @Override
    public String getVehicle() {
        return EMERGENCY;
    }
}
