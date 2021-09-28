package com.rental.app.model;

import java.util.Objects;

public class Distance {

    private String id;
    private double distance;

    public Distance(String id, double distance) {
        this.id = id;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Distance other = (Distance) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder("Distance{");
        toStringBuilder.append("Id=").append(this.id);
        toStringBuilder.append(", Distance=").append(this.distance);
        toStringBuilder.append('}');
        return toStringBuilder.toString();
    }

}
