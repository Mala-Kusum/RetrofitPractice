package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

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
    ArrayList<Model1> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        list = new ArrayList<>();
        recycler = findViewById(R.id.SearchByDesignation);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        Retrofit r = new Retrofit.Builder().baseUrl("http://35.200.224.164:9000/api/detailsOfStaff/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONInterface i = r.create(JSONInterface.class);
        Call<List<Model1>> c = i.getModel1();
        c.enqueue(new Callback<List<Model1>>() {
            @Override
            public void onResponse(Call<List<Model1>> call, Response<List<Model1>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Page2.this, "Code: "+ response.code(),Toast.LENGTH_SHORT).show();
                }
                else {
                    List<Model1> l = response.body();
                    String d;
                    d="";
                    for(Model1 m:l){
                        list.add(m);
                        adapt.notifyDataSetChanged();
                    }
                    // t.setText(d);
                }
            }
            @Override
            public void onFailure(Call<List<Model1>> call, Throwable t1) {
                Toast.makeText(Page2.this, "Code: "+ t1.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}