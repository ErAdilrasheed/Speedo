package com.speedo.speedo.service;

import com.speedo.speedo.Enum.Gender;
import com.speedo.speedo.dto.request.CustomerRequest;
import com.speedo.speedo.dto.response.CustomerResponse;
import com.speedo.speedo.exception.CustomerNotFoundException;
import com.speedo.speedo.model.Customer;
import com.speedo.speedo.repository.CustomerRepository;
import com.speedo.speedo.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        // Request dto to entity conversion
//        Customer customer = new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setGender(customerRequest.getGender());
        // OR

        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);


        // save the entity to db
        Customer savedCustomer = customerRepository.save(customer);

        // saved entity to response entity conversion

//        CustomerResponse customerResponse = new CustomerResponse();
//
//        customerResponse.setName(customer.getName());
//        customerResponse.setAge(customer.getAge());
//        customerResponse.setEmailId(customer.getEmailId());
//        return customerResponse;
        return CustomerTransformer.customerToCustomerResponse(customer);
    }


    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Customer savedCustomer = optionalCustomer.get();

        // saved entity to response dto conversion

//        CustomerResponse customerResponse = new CustomerResponse();
//
//        customerResponse.setName(savedCustomer.getName());
//        customerResponse.setAge(savedCustomer.getAge());
//        customerResponse.setEmailId(savedCustomer.getEmailId());
//
//
//
//        return customerResponse;
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);

        // entity to response dto conversion

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, String age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAge(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));

        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, String age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));

        }
        return customerResponses;
    }
}
