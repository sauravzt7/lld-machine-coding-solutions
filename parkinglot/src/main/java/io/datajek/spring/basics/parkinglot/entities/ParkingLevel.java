package io.datajek.spring.basics.parkinglot.entities;

import io.datajek.spring.basics.parkinglot.enums.ParkingSpotType;
import io.datajek.spring.basics.parkinglot.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLevel {

    public int levelId;
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpotTypetMap;

    private ReentrantLock lock;

    public ParkingLevel(int levelId, int smallSpots, int mediumSpots, int largeSpots) {

        this.levelId = levelId;
        this.parkingSpotTypetMap = new HashMap<>();
        this.lock = new ReentrantLock();

        parkingSpotTypetMap.put(ParkingSpotType.SMALL, new ArrayList<>());
        parkingSpotTypetMap.put(ParkingSpotType.MEDIUM, new ArrayList<>());
        parkingSpotTypetMap.put(ParkingSpotType.LARGE, new ArrayList<>());

        for(int i = 0; i < smallSpots; i++){
            parkingSpotTypetMap.get(ParkingSpotType.SMALL).add(new SmallSpot("S" + levelId + "_" + i));
        }


        for(int i = 0; i < mediumSpots; i++){
            parkingSpotTypetMap.get(ParkingSpotType.MEDIUM).add(new MediumSpot( "M" + levelId + "_" + i));
        }


        for(int i = 0; i < largeSpots; i++){
            parkingSpotTypetMap.get(ParkingSpotType.LARGE).add(new MediumSpot( "L" + levelId + "_" + i));
        }
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType){
        lock.lock();
        try {
            ParkingSpotType spotTypeForVehicle = getSpotTypeForVehicle(vehicleType);
            List<ParkingSpot> spots = parkingSpotTypetMap.get(spotTypeForVehicle);
            for(ParkingSpot spot: spots){
                if(spot.isAvailable())return spot;
            }

        }
        finally {
            lock.unlock();
        }
        return null;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot != null) {
            spot.parkVehicle(vehicle);
            return true;
        }
        return false;
    }

    public boolean leaveVehicle(String spotId) {
        lock.lock();
        try {
            for (List<ParkingSpot> spots : parkingSpotTypetMap.values()) {
                for (ParkingSpot spot : spots) {
                    if (spot.getSpotId().equals(spotId)) {
                        spot.removeVehicle();
                        return true;
                    }
                }
            }
        } finally {
            lock.unlock();
        }
        return false;
    }

    public int getAvailableSpots(ParkingSpotType type) {
        int count = 0;
        for (ParkingSpot spot : parkingSpotTypetMap.get(type)) {
            if (spot.isAvailable()) {
                count++;
            }
        }
        return count;
    }




    private ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE:
                return ParkingSpotType.SMALL;
            case CAR:
                return ParkingSpotType.MEDIUM;
            case TRUCK:
                return ParkingSpotType.LARGE;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }


}
