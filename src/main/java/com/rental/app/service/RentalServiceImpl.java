package com.rental.app.service;

import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.model.Bus;
import com.rental.app.model.Swift;
import com.rental.app.model.Truck;
import com.rental.app.model.Vehicle;
import org.springframework.stereotype.Component;

public class RentalServiceImpl implements RentalService {

    @Override
    public String calculateTotalExpense(String vehicle, String engine, String actype, String trip, String passengerscount) throws InvalidDistanceException {
        Vehicle auto = getVehicle(vehicle);
        double totalExpense = auto.calculateTotalExpenseForTrip(vehicle, engine, actype, trip, passengerscount);
        return String.valueOf(totalExpense);
    }

    private Vehicle getVehicle(String vehicle) {
        if ("swift".equalsIgnoreCase(vehicle)) {
            return new Swift();
        } else if ("Bus".equalsIgnoreCase(vehicle)) {
            return new Bus();
        } else {
            return new Truck();
        }
    }

}