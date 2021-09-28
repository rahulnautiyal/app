package com.rental.app.dao;

import com.rental.app.exception.InvalidDistanceException;
import com.rental.app.model.Distance;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RentalDao {

    static Map<String, Distance> loadData() {
        Map<String, Distance> distanceMap = new HashMap<>();
        Distance d1 = new Distance("Pune-Mumbai", 200);
        Distance d2 = new Distance("Pune-Bangalore", 1000);
        Distance d3 = new Distance("Pune-Delhi", 2250);
        Distance d4 = new Distance("Pune-Chennai", 1434.5);
        Distance d5 = new Distance("Mumbai-Delhi", 2050);
        Distance d6 = new Distance("Mumbai-Chennai", 1234.5);
        Distance d7 = new Distance("Mumbai-Bangalore", 400);
        Distance d8 = new Distance("Chennai-Bangalore", 420);
        Distance d9 = new Distance("Chennai-Delhi", 600);
        Distance d10 = new Distance("Bangalore-Delhi", 800);
        Distance d11 = new Distance("Bangalore-Pune", 1000);

        distanceMap.put(d1.getId(), d1);
        distanceMap.put(d2.getId(), d2);
        distanceMap.put(d3.getId(), d3);
        distanceMap.put(d4.getId(), d4);
        distanceMap.put(d5.getId(), d5);
        distanceMap.put(d6.getId(), d6);
        distanceMap.put(d7.getId(), d7);
        distanceMap.put(d8.getId(), d8);
        distanceMap.put(d9.getId(), d9);
        distanceMap.put(d10.getId(), d10);
        distanceMap.put(d11.getId(), d11);
        return distanceMap;
    }

    public static List<Distance> getDistanceMap() {
        Map<String, Distance> distanceMap = loadData();
        List<Distance> distances = new ArrayList<>();
        Iterator it = distanceMap.entrySet().iterator();
        while (it.hasNext()) {
            Distance next = (Distance) it.next();
            distances.add(next);
        }
        return distances;
    }

    public static double calculateTotalDistance(List<String> distances) throws InvalidDistanceException {
        Map<String, Distance> distanceMap = loadData();
        double total = 0;
        for (String id : distances) {
            if (!distanceMap.containsKey(id)) {
                throw new InvalidDistanceException(
                        new StringBuilder().append("Invalid Distance : ")
                                .append(id).toString());
            }
            total += distanceMap.get(id).getDistance();
        }
        return total;
    }
}
