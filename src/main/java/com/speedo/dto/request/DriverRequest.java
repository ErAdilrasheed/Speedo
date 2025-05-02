package com.speedo.speedo.dto.request;

public class DriverRequest {
    private String name;
    private String age;
    private String emailId;

    public DriverRequest() {
    }

    public DriverRequest(String name, String age, String emailId) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
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
