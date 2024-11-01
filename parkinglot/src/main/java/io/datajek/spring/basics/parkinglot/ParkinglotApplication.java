package io.datajek.spring.basics.parkinglot;

import io.datajek.spring.basics.parkinglot.entities.*;
import io.datajek.spring.basics.parkinglot.service.ParkingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkinglotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkinglotApplication.class, args);

        // Create a parking lot
        ParkingLot parkingLot = new ParkingLot("My Parking Lot");

        // Add levels to the parking lot
        parkingLot.addLevel(new ParkingLevel(1, 10, 10, 5));
        parkingLot.addLevel(new ParkingLevel(2, 10, 10, 5));


        ParkingService parkingService = new ParkingService(parkingLot);
        parkingService.displayAvailability();
        // Create vehicles
        Vehicle motorcycle = new MotorCycle("MC123");
        Vehicle car = new Car("CAR456");
        Vehicle truck = new Truck("TRK789");

        // Vehicle enters parking
        Ticket ticket1 = parkingService.enterParking(motorcycle);
        Ticket ticket2 = parkingService.enterParking(car);
        Ticket ticket3 = parkingService.enterParking(truck);

        // Display availability
        parkingService.displayAvailability();

        // Vehicle exits parking
        parkingService.exitParking(ticket1);
        parkingService.exitParking(ticket2);
        parkingService.exitParking(ticket3);

        // Display availability
        parkingService.displayAvailability();
    }

}
