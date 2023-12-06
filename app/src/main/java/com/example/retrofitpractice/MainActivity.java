package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static  String EMAIL;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = findViewById(R.id.text);
        Retrofit r = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONInterface i = r.create(JSONInterface.class);
        Call<List<Model>> c = i.getData();
        Call<List<Albums>> a = i.getAlbums(2);
        b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this, Page2.class);
                startActivity(i);
            }
        });
        c.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(!response.isSuccessful()){
                    //t.setText("Code: "+response.code());
                }
                else {
                    List<Model> l = response.body();
                    String d;
                    d="";
                    for(Model m:l){
                        d += "id: "+m.getId()+"\n";
                        d += "name: "+m.getName()+"\n";
                        d += "username: "+m.getUsername()+"\n";
                        d += "email: "+m.getEmail()+"\n";
                        Address a = m.getAddress();
                        Geo g = a.getGeo();
                        d += "address: \n \tstreet: "+a.getStreet()+"\n\tsuite: "+a.getSuite()+"\n\t city: "+a.getCity()+"\n\t zipcode: "+a.getZipcode()+"\n\t geo: "+"\n\t\t lat: "+g.getLat()+"\n\t\t lng: "+g.getLng()+"\n";
                        d += "phone: "+m.getPhone()+"\n";
                        d += "website: "+m.getWebsite()+"\n";
                        Company c = m.getCompany();
                        d += "company: \n\t name: "+c.getName()+"\n\t catchPhrase: "+c.getCatchPhrase()+"\n\t bs: "+c.getBs()+"\n\n";
                    }
                   // t.setText(d);
                }
            }
            @Override
            public void onFailure(Call<List<Model>> call, Throwable t1) {
                //t.setText(t1.getMessage());
            }
        });
        a.enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                if(!response.isSuccessful()){
                    t.setText("Code: "+response.code());
                }
                else {
                    List<Albums> la = response.body();
                    String d;
                    d="";
                    for(Albums m:la){
                        d += "userId: "+m.getUserid()+"\n";
                        d += "id: "+m.getId()+"\n";
                        d += "title: "+m.getTitle()+"\n\n";
                    }
                    t.setText(d);
                }
            }
            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t1) {
                t.setText(t1.getMessage());
            }
        });
    }
}

