package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}
