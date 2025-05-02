package com.speedo.speedo.service;

import com.speedo.speedo.dto.request.DriverRequest;
import com.speedo.speedo.dto.response.DriverResponse;
import com.speedo.speedo.model.Driver;
import com.speedo.speedo.repository.DriverRepository;
import com.speedo.speedo.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Driver savedDriver = driverRepository.save(driver);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }
}
