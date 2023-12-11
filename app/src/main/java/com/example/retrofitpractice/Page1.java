package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Page1 extends AppCompatActivity {
ListView listView;
List<String> l;
Button b;
    void showList(){
        l=new ArrayList<>();
        b=findViewById(R.id.allsearch);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1.this, Page2.class);
                startActivity(intent);
            }
        });
        Retrofit r = new Retrofit.Builder().baseUrl("http://35.200.224.164:9000/api/dropdownMenu/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONInterface i = r.create(JSONInterface.class);
        Call<DObj> c = i.getDesignation();
        c.enqueue(new Callback<DObj>() {
            @Override
            public void onResponse(Call<DObj> call, Response<DObj> response) {
                if(!response.isSuccessful()){
                    Log.d("onResponse: ","Code: "+ response.code());
                }
                else {
                    DObj o = response.body();
                    Log.d("onResponse: ", new Gson().toJson(o));
                    Log.d( "menu: ",new Gson().toJson(o.getMenu().get(0)));
                    Log.d( "Designations: ",new Gson().toJson(o.getMenu().get(0).getItem().get(0)));
                    listView=findViewById(R.id.list);
                    for(Designation d:o.getMenu().get(0).getItem()){
                        Log.d("Name: ",d.getName());
                        l.add(d.getName());
                    }
                    ArrayAdapter<String> ad = new ArrayAdapter<String>(Page1.this, android.R.layout.simple_list_item_1, l);
                    listView.setAdapter(ad);

                }
            }

            @Override
            public void onFailure(Call<DObj> call, Throwable t) {
                Log.d("onFailure: ",t.getMessage());
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        showList();
    }
}