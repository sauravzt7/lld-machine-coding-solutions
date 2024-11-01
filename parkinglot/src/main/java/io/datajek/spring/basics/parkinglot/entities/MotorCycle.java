package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.VehicleType;

public class MotorCycle extends Vehicle{

    public MotorCycle(String licensePlate){
        super(licensePlate, VehicleType.MOTORCYCLE);
    }

}
