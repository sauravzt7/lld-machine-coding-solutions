package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.ParkingSpotType;

public class LargeSpot extends ParkingSpot{
    public LargeSpot(String spotId){
        super(spotId, ParkingSpotType.LARGE);
    }

}