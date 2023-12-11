package com.example.retrofitpractice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface JSONInterface {
    @GET("users")
    Call<List<Model>> getData();

    @GET("users/{id}/albums")
    Call<List<Albums>> getAlbums(@Path("id") int i);

    @GET("get-corporate-office-staff")
    Call<Model1> getModel1();
    @GET("Corporate-Office-Staff-Works-Under")
    Call<DObj> getDesignation();

}
