package com.speedo.speedo.model;

import com.speedo.speedo.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@NoArgsConstructor       //default constructor
//@AllArgsConstructor
//@Getter
//@Setter
@Entity
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private String age;
    @Column(unique = true , nullable = false )
    private String emailId;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    List<Booking> bookings = new ArrayList<>();


    public Customer() {
    }

    public Customer(int customerId, String name, String age, String emailId, Gender gender, List<Booking> bookings) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.gender = gender;
        this.bookings = bookings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
