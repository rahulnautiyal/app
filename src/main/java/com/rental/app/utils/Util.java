package com.rental.app.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> getDistances(String trip) {
        List<String> distances = new ArrayList<>();
        List<String> points = new ArrayList<>();

        points.addAll(Arrays.asList(trip.split("-")));

        while (points.size() > 1) {
            distances.add(distance(points.get(0), points.get(1)));
            points.remove(points.get(0));
        }
        return distances;
    }

    private static String distance(String from, String to) {
        return new StringBuilder().append(from).append("-").append(to).toString();
    }

    public static long roundOff(double number, int digits) {
        String val = String.valueOf(number);
        int index = val.indexOf(".");
        val = val.substring(index);
        if (val.length() > 4) {
            return new BigDecimal(number).setScale(digits, RoundingMode.UP).longValue();
        }
        return new BigDecimal(number).setScale(digits, RoundingMode.FLOOR).longValue();
    }
}
