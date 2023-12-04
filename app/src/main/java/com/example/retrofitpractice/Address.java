package com.example.retrofitpractice;

import com.example.retrofitpractice.JSONInterface;

public class Address {
    String suite;
    String street;
    String city;
    String zipcode;

    public Geo getGeo() {
        return geo;
    }

    Geo geo;

    public String getSuite() {
        return suite;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
