package com.rental.app.model;

import com.rental.app.dao.RentalDao;
import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.utils.Util;

public class Bus extends Vehicle{

    private double discountRate = 0.02;

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculateTotalExpenseForTrip(String vehicle, String engine, String actype, String trip, String passengerscount) throws InvalidDistanceException {
        this.noOfPassengers = Integer.parseInt(passengerscount);
        this.setMaxLimit(20);
        rate = new Rate(engine, isAC(actype));
        double standardRate = rate.getStandardRate();
        rate.setStandardRate(standardRate - (standardRate * discountRate));
        double totalDistance = RentalDao.calculateTotalDistance(Util.getDistances(trip));
        double additionalCharge = 0;

        if (limitIsExceeded()) {
            additionalCharge = rate.getAdditionalChargeRatePerKmAndPerson() * totalDistance * noOfPassengers;
        }
        double totalExpenseForTrip = (rate.getStandardRate() * totalDistance) + additionalCharge;
        return Util.roundOff(totalExpenseForTrip, 2);
    }
}
