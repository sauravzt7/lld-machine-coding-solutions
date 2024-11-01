package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.VehicleType;

public abstract class Vehicle {

    private String licensePlate;
    private VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getType(){
        return vehicleType;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

}

