package com.Ankit.DunzoCarrier;

import static com.Ankit.DunzoCarrier.DistanceCalculator.calculateDistance;

public class Ankit {
    public static void main(String[] args) {
        double lat1 = 28.2490;
        double lon1 = 77.8549;
        double lat2 = 27.8974;
        double lon2 = 78.0880;

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Distance between the points: " + distance + " km");
    }
}
