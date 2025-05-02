package com.speedo.speedo.controller;

import com.speedo.speedo.dto.request.BookingRequest;
import com.speedo.speedo.dto.response.BookingResponse;
import com.speedo.speedo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{customerid}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("customerid") int customerId){
        return bookingService.bookCab(bookingRequest, customerId );

    }
}
