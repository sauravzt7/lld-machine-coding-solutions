package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.ParkingSpotType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String name;
    private List<ParkingLevel> levels;

    public ParkingLot(String name) {
        this.name = name;
        this.levels = new ArrayList<>();
    }

    public void addLevel(ParkingLevel level) {
        levels.add(level);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.parkVehicle(vehicle)) {
                // Generate a ticket
                return new Ticket(vehicle.getLicensePlate(), level);
            }
        }
        System.out.println("Parking Lot Full");
        return null;
    }

    public boolean leaveVehicle(Ticket ticket) {
        ParkingLevel level = ticket.getParkingLevel();
        return level.leaveVehicle(ticket.getSpotId());
    }

    public void displayAvailableSpots() {
        for (ParkingLevel level : levels) {
            System.out.println("Level " + level.levelId + " availability:");
            System.out.println("  Small Spots: " + level.getAvailableSpots(ParkingSpotType.SMALL));
            System.out.println("  Medium Spots: " + level.getAvailableSpots(ParkingSpotType.MEDIUM));
            System.out.println("  Large Spots: " + level.getAvailableSpots(ParkingSpotType.LARGE));
        }
    }
}
