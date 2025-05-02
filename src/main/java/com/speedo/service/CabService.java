package com.speedo.speedo.service;

import com.speedo.speedo.dto.request.CabRequest;
import com.speedo.speedo.dto.response.CabResponse;
import com.speedo.speedo.exception.DriverNotFoundException;
import com.speedo.speedo.model.Cab;
import com.speedo.speedo.model.Driver;
import com.speedo.speedo.repository.CabRepository;
import com.speedo.speedo.repository.DriverRepository;
import com.speedo.speedo.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;



    public CabResponse registerCab(CabRequest cabRequest, int driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Driver Id");
        }
        Driver driver = optionalDriver.get();

        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver = driverRepository.save(driver);  // it will save both cab and driver because of cascade type used
        return CabTransformer.cabToCabResponse(savedDriver.getCab(), savedDriver);

    }
}
