package com.speedo.speedo.dto.request;

import com.speedo.speedo.Enum.Gender;


public class CustomerRequest {
    private String name;
    private String age;
    private String emailId;
    private Gender gender;

    public CustomerRequest() {
    }

    public CustomerRequest(String name, String age, String emailId, Gender gender) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.gender = gender;
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
}
