package com.example.retrofitpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewHolder>{
    Context context;
    ArrayList<Model1> list;
    String DocID;
    String Type;
    String email;
    public MAdapter(Context context, ArrayList<Model1> list) {
        this.context = context;
        this.list = list;
    }
    public void filterList(ArrayList<Model1> filterlist) {
        list = filterlist;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v=LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model1 user = list.get(position);
        holder.name.setText(user.getNAME());
        holder.designation.setText("(" + user.getDESIGNATION() + ")");
        holder.department.setText(user.getDEPARTMENT());
        holder.address.setText(user.getADDRESS());
        holder.email.setText(user.getEMAIL());
        holder.phone.setText(user.getLANDLINE());
        holder.mobile.setText(user.getMOBILE());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,designation,department,address,phone,mobile,email,button;
        LinearLayout card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            name=itemView.findViewById(R.id.name);
            designation=itemView.findViewById(R.id.designation);
            department=itemView.findViewById(R.id.department);
            address=itemView.findViewById(R.id.address);
            phone=itemView.findViewById(R.id.phone);
            mobile=itemView.findViewById(R.id.mobile);
            email=itemView.findViewById(R.id.email);
        }
    }
}
