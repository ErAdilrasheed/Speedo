package com.speedo.speedo.dto.request;

public class BookingRequest {
    String pickup;
    String destination;
    double tripDistanceInKm;

    public BookingRequest() {
    }

    public BookingRequest(String pickup, String destination, double tripDistanceInKm) {
        this.pickup = pickup;
        this.destination = destination;
        this.tripDistanceInKm = tripDistanceInKm;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTripDistanceInKm() {
        return tripDistanceInKm;
    }

    public void setTripDistanceInKm(double tripDistanceInKm) {
        this.tripDistanceInKm = tripDistanceInKm;
    }
}
