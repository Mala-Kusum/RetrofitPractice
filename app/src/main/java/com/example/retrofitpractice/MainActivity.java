package com.example.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = findViewById(R.id.text);
        Retrofit r = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONInterface i = r.create(JSONInterface.class);
        Call<List<Model>> c = i.getData();
        c.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(!response.isSuccessful()){
                    t.setText("Code: "+response.code());
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
                    t.setText(d);
                }
            }
            @Override
            public void onFailure(Call<List<Model>> call, Throwable t1) {
                t.setText(t1.getMessage());
            }
        });
    }
}

