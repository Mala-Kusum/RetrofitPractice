package com.example.retrofitpractice;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StaffDetails {
    @SerializedName("_id")
    String id;
    List<StaffData> staffData;

    public String getId() {
        return id;
    }

    public List<StaffData> getStaffData() {
        return staffData;
    }
}
