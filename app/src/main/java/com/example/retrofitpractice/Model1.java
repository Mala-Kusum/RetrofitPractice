package com.example.retrofitpractice;

import java.util.List;

public class Model1 {
    List<StaffDetails> staffDetails;
    boolean success;

    public List<StaffDetails> getStaffDetails() {
        return staffDetails;
    }

    public void setStaffDetails(List<StaffDetails> staffDetails) {
        this.staffDetails = staffDetails;
    }
    public boolean isSuccess() {
        return success;
    }
}
