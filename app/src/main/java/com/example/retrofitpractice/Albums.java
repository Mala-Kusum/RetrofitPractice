package com.example.retrofitpractice;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Albums {
    @SerializedName("userId")
    String userid;
    String id;
    String title;

    public String getUserid() {
        return userid;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static class Model1 {
        List<StaffDetails> staffDetails;

        public List<StaffDetails> getStaffDetails() {
            return staffDetails;
        }

        public void setStaffDetails(List<StaffDetails> staffDetails) {
            this.staffDetails = staffDetails;
        }
    }
}
