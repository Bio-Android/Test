package com.example.test.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.test.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Myholder> implements View.OnClickListener {


    public String userselected =new String();
    private LayoutInflater mInflater;
    public ArrayList<String> lista;
    private View.OnClickListener listener;

    public Adapter(Context context, ArrayList<String> lista) {
        this.mInflater = LayoutInflater.from(context);
        this.lista= lista;

    }




    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.itemuser,parent,false);
        view.setOnClickListener(this);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {

        holder.nombreuser.setText(lista.get(position));


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }

    }

    public class Myholder extends RecyclerView.ViewHolder {
        ConstraintLayout Item;
        TextView  nombreuser;

        public Myholder(View view) {
            super(view);
            nombreuser=view.findViewById(R.id.tvNames);
            Item=view.findViewById(R.id.ItemUserName);

        }
    }
}
