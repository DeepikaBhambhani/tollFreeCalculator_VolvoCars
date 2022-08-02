package com.example.tollfreecalculatordeepika.bean;


import static com.example.tollfreecalculatordeepika.util.Constants.MILITARY;

public class Military implements Vehicle {
    @Override
    public String getVehicle(){
        return MILITARY;
    }

}
