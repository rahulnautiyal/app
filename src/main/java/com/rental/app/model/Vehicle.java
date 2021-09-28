package com.rental.app.model;

import com.rental.app.constants.AppConstants;
import com.rental.app.dao.RentalDao;
import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.utils.Util;

public abstract class Vehicle {

    protected String type;
    protected int maxLimit = 2;
    protected int noOfPassengers;
    protected Rate rate;

    public Vehicle() {
    }

    public double calculateTotalExpenseForTrip(String vehicle, String engine, String actype, String trip, String passengerscount) throws InvalidDistanceException {
        this.noOfPassengers = Integer.parseInt(passengerscount);
        rate = new Rate(engine, isAC(actype));
        double distance = RentalDao.calculateTotalDistance(Util.getDistances(trip));
        double additionalCharge = 0;

        if (limitIsExceeded()) {
            additionalCharge = rate.getAdditionalChargeRatePerKmAndPerson() * distance * noOfPassengers;
        }

        double totalExpenseForTrip = (rate.getStandardRate() * distance) + additionalCharge;

        return Util.roundOff(totalExpenseForTrip, 2);
    }

    public boolean isAC(String actype) {
        return actype == null ? false : actype.equalsIgnoreCase(AppConstants.AC);
    }

    public boolean limitIsExceeded() {
        return noOfPassengers > maxLimit;
    }


}
