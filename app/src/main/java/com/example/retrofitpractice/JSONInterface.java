package com.example.retrofitpractice;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface JSONInterface {
    @GET("users")
    Call<List<Model>> getData();
}
