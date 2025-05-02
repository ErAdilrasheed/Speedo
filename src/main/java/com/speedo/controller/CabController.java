package com.speedo.speedo.controller;

import com.speedo.speedo.dto.request.CabRequest;
import com.speedo.speedo.dto.response.CabResponse;
import com.speedo.speedo.model.Cab;
import com.speedo.speedo.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping("/register/driver/{driverid}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
                                   @PathVariable("driverid") int driverId){
        return cabService.registerCab(cabRequest , driverId);

    }
}
