package com.rental.app.model;

import com.rental.app.constants.AppConstants;

public class Rate {

    private String engineType;
    private double standardRate = 15.00;
    private static final int dieselAdjustmentRate = 1;
    private static final int additionalAcRate = 2;
    private static final int additionalRatePerKmAndPerson = 1;

    public Rate(String engineType, boolean AC) {
        this.engineType = engineType;
        adjustRate(engineType, AC);
    }

    public double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(double standardRate) {
        this.standardRate = standardRate;
    }

    private void adjustRate(String engineType) {
        if (engineType != null && engineType.equalsIgnoreCase(AppConstants.DIESEL)) {
            standardRate -= dieselAdjustmentRate;
        }
    }

    private void adjustRate(String engineType, boolean AC) {
        standardRate = 15;
        if (engineType != null && engineType.equalsIgnoreCase(AppConstants.DIESEL)) {
            standardRate -= dieselAdjustmentRate;
        }
        if (AC) {
            standardRate += additionalAcRate;
        }
    }

    public static int getAdditionalChargeRatePerKmAndPerson() {
        return additionalRatePerKmAndPerson;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
        adjustRate(engineType);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vehicle Engine{");
        sb.append("EngineType=").append(this.engineType);
        sb.append(", StandardRate=").append(this.standardRate);
        sb.append("}");
        return sb.toString();
    }

}
