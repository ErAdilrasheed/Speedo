package com.speedo.speedo.transformer;

import com.speedo.speedo.dto.request.CabRequest;
import com.speedo.speedo.dto.response.CabResponse;
import com.speedo.speedo.model.Cab;
import com.speedo.speedo.model.Driver;

public class CabTransformer {

    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabModel(cabRequest.getCabModel())
                .perKmRate(cabRequest.getPerKmRate())
                .available(true)
                .build();
    }

    public static CabResponse cabToCabResponse(Cab cab , Driver driver){
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabModel(cab.getCabModel())
                .perKmRate(cab.getPerKmRate())
                .available(cab.isAvailable())
                .driver(DriverTransformer.driverToDriverResponse(driver))
                .build();
    }
}
