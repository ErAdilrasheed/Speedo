package com.speedo.speedo.service;

import com.speedo.speedo.dto.request.BookingRequest;
import com.speedo.speedo.dto.response.BookingResponse;
import com.speedo.speedo.exception.CabUnavailableException;
import com.speedo.speedo.exception.CustomerNotFoundException;
import com.speedo.speedo.model.Booking;
import com.speedo.speedo.model.Cab;
import com.speedo.speedo.model.Customer;
import com.speedo.speedo.model.Driver;
import com.speedo.speedo.repository.BookingRepository;
import com.speedo.speedo.repository.CabRepository;
import com.speedo.speedo.repository.CustomerRepository;
import com.speedo.speedo.repository.DriverRepository;
import com.speedo.speedo.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    CustomerRepository customerRepository;



    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Customer customer = optionalCustomer.get();

        Cab availableCab  = cabRepository.getAvailableCabRandomly();
        if (availableCab == null) {
            throw new CabUnavailableException("Sorry No Cab Available at this movement");
        }
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());
        Booking savedBooking = bookingRepository.save(booking);

        availableCab.setAvailable(false);

        customer.getBookings().add(savedBooking);

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());

        driver.getBookings().add(savedBooking);

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

        // sendng email

        sendEmail(savedCustomer);
        return BookingTransformer.bookingToBookingResponse(savedBooking , savedCustomer, availableCab, savedDriver);
        }
        private void sendEmail(Customer customer){
        String message = "Congratulations!! " + customer.getName() + ". Your Cab has been booked";
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("adilgiri.ag@gmail.com");
            simpleMailMessage.setTo(customer.getEmailId());
            simpleMailMessage.setSubject("Cab Booked");
            simpleMailMessage.setText(message);
            javaMailSender.send(simpleMailMessage);
        }
    }
