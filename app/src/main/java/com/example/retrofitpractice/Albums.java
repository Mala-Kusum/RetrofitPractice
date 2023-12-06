package com.example.retrofitpractice;
import com.google.gson.annotations.SerializedName;

import  retrofit2.*;

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
}
