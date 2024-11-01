package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.ParkingSpotType;

public abstract class ParkingSpot {
    private ParkingSpotType type;
    private String spotId;
    private boolean isAvailable;
    private Vehicle currentVehicle;


    public ParkingSpot(String spotId, ParkingSpotType type){
        this.spotId = spotId;
        this.type = type;
        this.isAvailable = true;
    }

    public String getSpotId() {
        return spotId;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    public ParkingSpotType getParkingSpotType(){
        return type;
    }

    public void parkVehicle(Vehicle vehicle){
        this.currentVehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle(){
        this.currentVehicle = null;
        this.isAvailable = false;
    }
}
