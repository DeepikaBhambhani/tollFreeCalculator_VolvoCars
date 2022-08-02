package com.example.tollfreecalculatordeepika.bean;


import com.example.tollfreecalculatordeepika.bean.Vehicle;

import static com.example.tollfreecalculatordeepika.util.Constants.DIPLOMAT;

public class Diplomat implements Vehicle{
    @Override
    public String getVehicle() {
        return DIPLOMAT;
    }
}
