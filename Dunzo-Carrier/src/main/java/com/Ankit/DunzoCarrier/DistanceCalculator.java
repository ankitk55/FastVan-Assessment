package com.Ankit.DunzoCarrier;


public class DistanceCalculator {
    // Radius of the Earth in kilometers
    private static final double RADIUS = 6371.0;

    // Convert degrees to radians
    private static double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    // Calculate distance between two points using Haversine formula
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = toRadians(lat2 - lat1);
        double dLon = toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(toRadians(lat1)) * Math.cos(toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIUS * c;
    }


}
