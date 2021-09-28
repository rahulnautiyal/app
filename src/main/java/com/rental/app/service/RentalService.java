package com.rental.app.service;

import com.rental.app.exception.InvalidDistanceException;

public interface RentalService {

    String calculateTotalExpense(String vehicle, String engine, String actype, String trip, String passengerscount) throws InvalidDistanceException;

}
