package io.datajek.spring.basics.parkinglot.service;

import io.datajek.spring.basics.parkinglot.entities.ParkingLot;
import io.datajek.spring.basics.parkinglot.entities.Ticket;
import io.datajek.spring.basics.parkinglot.entities.Vehicle;

public class ParkingService {
    private ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public Ticket enterParking(Vehicle vehicle){
        return parkingLot.parkVehicle(vehicle);
    }

    public boolean exitParking(Ticket ticket){
        return parkingLot.leaveVehicle(ticket);
    }

    public void displayAvailability() {
        parkingLot.displayAvailableSpots();
    }

}
