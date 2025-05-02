package com.speedo.speedo.dto.response;

import com.speedo.speedo.Enum.TripStatus;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class BookingResponse {
    String pickup;
    String destination;
    double tripDistanceInKm;
    TripStatus tripStatus;
    double billAmount;
    Date bookedAt;
    Date lastUpdateAt;

    CustomerResponse customer;
    CabResponse cab;
}
