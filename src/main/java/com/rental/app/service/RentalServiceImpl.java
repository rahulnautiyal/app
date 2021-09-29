package com.rental.app.service;

import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.model.*;

public class RentalServiceImpl implements RentalService {

    @Override
    public String calculateTotalExpense(String vehicle, String engine, String actype, String trip, String passengersCount) throws InvalidDistanceException {
        Vehicle auto = getVehicle(vehicle);
        double totalExpense = auto.calculateTotalExpenseForTrip(vehicle, engine, actype, trip, passengersCount);
        return String.valueOf(totalExpense);
    }

    private Vehicle getVehicle(String vehicle) {
        if(vehicle != null){
            if ("Swift".equalsIgnoreCase(vehicle)) {
                return new Swift();
            } else if ("Bus".equalsIgnoreCase(vehicle)) {
                return new Bus();
            } else if ("Car".equalsIgnoreCase(vehicle)) {
                return new Car();
            } else if ("SUV".equalsIgnoreCase(vehicle)) {
                return new SUV();
            } else if ("Van".equalsIgnoreCase(vehicle)) {
                return new Van();
            } else if ("Truck".equalsIgnoreCase(vehicle)) {
                return new Truck();
            }
        }
        return null;
    }

}