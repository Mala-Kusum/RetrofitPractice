package com.example.retrofitpractice;

import com.example.retrofitpractice.JSONInterface;

public class Model {
    int id;
    String name;
    String username;
    String email;
    String phone;
    String website;
    Address address;
    Company company;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }
}
