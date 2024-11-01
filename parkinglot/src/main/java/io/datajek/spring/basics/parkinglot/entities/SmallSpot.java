package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.ParkingSpotType;

public class SmallSpot extends ParkingSpot{

    public SmallSpot(String spotId){
        super(spotId, ParkingSpotType.SMALL);
    }
}
