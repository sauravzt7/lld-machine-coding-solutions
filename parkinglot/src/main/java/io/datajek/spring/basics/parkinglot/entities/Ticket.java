package io.datajek.spring.basics.parkinglot.entities;

public class Ticket {
    private String licensePlate;
    private String spotId;
    private ParkingLevel parkingLevel;
    private long entryTime;

    public Ticket(String licensePlate, ParkingLevel parkingLevel) {
        this.licensePlate = licensePlate;
        this.parkingLevel = parkingLevel;
        this.entryTime = System.currentTimeMillis();
        // For simplicity, assume spotId is licensePlate (in real scenario, get from ParkingSpot)
        this.spotId = licensePlate;
    }

    // Getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getSpotId() {
        return spotId;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public long getEntryTime() {
        return entryTime;
    }
}
