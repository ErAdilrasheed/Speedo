package com.speedo.speedo.dto.response;

import lombok.Builder;

@Builder
public class DriverResponse {
    private int driverId;
    private String name;
    private String age;
    private String emailId;

    public DriverResponse() {
    }

    public DriverResponse(int driverId , String name, String age, String emailId) {
        this.driverId = driverId;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
    }

    public int getDriverId(){
        return driverId;
    }

    public void setDriverId(int driverId){
        this.driverId = driverId;

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
}
