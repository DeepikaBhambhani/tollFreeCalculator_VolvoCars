package com.example.tollfreecalculator.model;


import static com.example.tollfreecalculator.util.Constants.MILITARY;

public class Military implements Vehicles {
    @Override
    public String getVehicle(){
        return MILITARY;
    }

}
