package com.speedo.speedo.controller;

import com.speedo.speedo.Enum.Gender;
import com.speedo.speedo.dto.request.CustomerRequest;
import com.speedo.speedo.dto.response.CustomerResponse;
import com.speedo.speedo.model.Customer;
import com.speedo.speedo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGender(gender);

    }

    @GetMapping("/get")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender ,
                                                       @RequestParam("age") String age){
      return customerService.getAllByGenderAndAge(gender , age);
    }

    @GetMapping("/greater-than")
        public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@RequestParam("gender") Gender gender,
                                                                      @RequestParam("age") String age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
        }

}
