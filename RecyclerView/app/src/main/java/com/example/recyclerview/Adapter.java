package com.example.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    private int posicionSeleccionada = RecyclerView.NO_POSITION;
    List<String> misDatos;
    Context miContexto;
    LayoutInflater miInflater;

    public Adapter(List<String> datos, Context contexto){
        this.misDatos = datos;
        this.miContexto = contexto;
        this.miInflater = LayoutInflater.from(contexto);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = miInflater.inflate(R.layout.myrow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String animal = misDatos.get(position);
        holder.myTextView.setText(animal);

        if (posicionSeleccionada == position) {
            holder.myTextView.setBackgroundColor(Color.RED);
            holder.myTextView.setTextColor(Color.WHITE);
        } else {
            holder.myTextView.setBackgroundColor(Color.WHITE);
            holder.myTextView.setTextColor(Color.BLACK);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemChanged(posicionSeleccionada);
                posicionSeleccionada=position;
                notifyItemChanged(posicionSeleccionada);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                holder.myTextView.setBackgroundColor(Color.WHITE);
                holder.myTextView.setTextColor(Color.BLACK);

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return misDatos.size();
    }

    public int getPosicionSeleccionada(){
        return posicionSeleccionada;
    }

    public void setPosicionSeleccionada(int posicionSeleccionada) {
        this.posicionSeleccionada = RecyclerView.NO_POSITION;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ViewHolder (View itemView){
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv1);
        }
    }
}
