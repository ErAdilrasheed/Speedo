package com.speedo.speedo.transformer;

import com.speedo.speedo.Enum.TripStatus;
import com.speedo.speedo.dto.request.BookingRequest;
import com.speedo.speedo.dto.response.BookingResponse;
import com.speedo.speedo.model.Booking;
import com.speedo.speedo.model.Cab;
import com.speedo.speedo.model.Customer;
import com.speedo.speedo.model.Driver;

public class BookingTransformer {
    public static Booking bookingRequestToBooking(BookingRequest bookingRequest , double perKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.PENDING)
                .billAmount(bookingRequest.getTripDistanceInKm() * perKmRate)
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                .customer(CustomerTransformer.customerToCustomerResponse(customer))
                .cab(CabTransformer.cabToCabResponse(cab , driver))
                .build();
    }
}
