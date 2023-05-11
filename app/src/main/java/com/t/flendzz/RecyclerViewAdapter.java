package com.t.flendzz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>{

    private List<Models> userList;

    public RecyclerViewAdapter(List<Models> userList) {
        this.userList = userList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Models model = userList.get(position);
        holder.name.setText(model.getName());
        holder.email.setText(model.getEmail());



        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLinks = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/"));
                v.getContext().startActivity(openLinks);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView email;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }

}