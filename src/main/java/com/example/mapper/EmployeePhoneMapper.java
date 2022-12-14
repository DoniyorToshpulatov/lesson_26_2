package com.example.mapper;

public class EmployeePhoneMapper {
    private  Integer id;
    private  String name;
    private  String phone;

    public EmployeePhoneMapper( String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public EmployeePhoneMapper() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
