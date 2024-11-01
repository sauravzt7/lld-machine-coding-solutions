package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.VehicleType;

public class Car extends Vehicle{

    public Car(String licensePlate){
        super(licensePlate, VehicleType.CAR);
    }

}
