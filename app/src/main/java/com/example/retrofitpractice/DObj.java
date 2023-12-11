package com.example.retrofitpractice;

import java.util.List;

public class DObj {
    public List<DObj2> getMenu() {
        return menu;
    }

    Boolean success;
    List<DObj2> menu;

    public Boolean getSuccess() {
        return success;
    }
}
