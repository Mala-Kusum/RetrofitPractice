package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Page2 extends AppCompatActivity {
    RecyclerView recycler;
    MAdapter adapt;
    List<StaffDetails> l2;
    List<StaffData> l3;

    void getD(){
        Retrofit r = new Retrofit.Builder().baseUrl("http://35.200.224.164:9000/api/detailsOfStaff/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONInterface i = r.create(JSONInterface.class);
        Call<Model1> c = i.getModel1();
        c.enqueue(new Callback<Model1>() {
            @Override
            public void onResponse(Call<Model1> call, Response<Model1> response) {
                if(!response.isSuccessful()){
                    Log.d("onResponse: ","Code: "+ response.code());
                    //Toast.makeText(Page2.this, "Code: "+ response.code(),Toast.LENGTH_SHORT).show();
                }
                else {
                    Model1 l = response.body();
                    Log.d( "Model1: ",new Gson().toJson(l));
                    Log.d("StaffDetails: ",new Gson().toJson(l.getStaffDetails()));

                    l2 = l.getStaffDetails();
                    Log.d("StaffData: ",new Gson().toJson(l2.get(0).getStaffData().get(0)));
                    for(StaffDetails m:l2){
                        Log.d("In outer for StaffData: ",new Gson().toJson(m.getStaffData().get(0)));
                        l3.addAll(m.getStaffData());
                        adapt.notifyDataSetChanged();
                    }
                                        // t.setText(d);
                }
            }
            @Override
            public void onFailure(Call<Model1> call, Throwable t1) {
                Log.d("onFailure: ",t1.getMessage());
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        l2=new ArrayList<>();
        l3=new ArrayList<>();
        recycler = findViewById(R.id.SearchByDesignation);
        getD();

        adapt = new MAdapter(this, (ArrayList<StaffData>) l3);
        recycler.setAdapter(adapt);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}