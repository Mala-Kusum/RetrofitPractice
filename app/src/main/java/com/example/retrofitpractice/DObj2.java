package com.example.retrofitpractice;

import java.util.List;

public class DObj2 {
    String _id,categoryName,date,createdAt,updatedAt;
    Boolean isActive;
    List<Designation> items;
    int __v;

    public String get_id() {
        return _id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDate() {
        return date;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<Designation> getItem() {
        return items;
    }

    public int get__v() {
        return __v;
    }
}
