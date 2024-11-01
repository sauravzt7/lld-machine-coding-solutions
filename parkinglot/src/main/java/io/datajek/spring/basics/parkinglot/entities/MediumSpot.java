package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.ParkingSpotType;

public class MediumSpot extends ParkingSpot{
    public MediumSpot(String spotId){
        super(spotId, ParkingSpotType.MEDIUM);
    }

}
