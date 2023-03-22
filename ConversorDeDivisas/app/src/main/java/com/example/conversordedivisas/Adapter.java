package com.example.conversordedivisas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {

    private int posicionSeleccionada = RecyclerView.NO_POSITION;
    List<Divisas> misDatos;
    Context miContexto;
    LayoutInflater miInflater;
    boolean seleccionLarga;
    int ronda;

    TextView mytvAdapter;



    public Adapter(List<Divisas> datos, Context contexto, int ronda, TextView mytvAdapter){
        this.misDatos = datos;
        this.miContexto = contexto;
        this.miInflater = LayoutInflater.from(contexto);
        this.ronda = ronda;
        this.mytvAdapter = mytvAdapter;
        this.seleccionLarga=false;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = miInflater.inflate(R.layout.myrow, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String moneda;

        if (posicionSeleccionada == position) {
            if (!seleccionLarga) {
                holder.myTextView.setBackgroundResource(R.color.fondo_selecion_raw);
                holder.myTextView.setTextColor(Color.WHITE);
                moneda = misDatos.get(position).getNombre();
                holder.myTextView.setTextSize(24);
            } else {
                holder.myTextView.setBackgroundResource(R.color.fondo_selecion_larga_raw);//no funciona
                holder.myTextView.setTextColor(Color.WHITE);
                moneda = misDatos.get(position).getConversion();
                holder.myTextView.setText(moneda);
                holder.myTextView.setTextSize(24);
            }
        } else {
            holder.myTextView.setBackgroundResource(R.color.Fondo_row);
            holder.myTextView.setTextColor(Color.BLACK);
            moneda = misDatos.get(position).getCodigo();
            holder.myTextView.setTextSize(16);
        }

        holder.myTextView.setText(moneda);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyItemChanged(posicionSeleccionada);
                if (posicionSeleccionada!=position){
                    posicionSeleccionada=position;
                    notifyItemChanged(posicionSeleccionada);
                    ronda ++;
                    mytvAdapter.setText("");
                }
                seleccionLarga = false;
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onLongClick(View view) {
               // holder.myTextView.setBackgroundColor(Color.parseColor("#FF3700B3"));

                notifyItemChanged(posicionSeleccionada);
                if (posicionSeleccionada!=position){
                    posicionSeleccionada=position;
                    notifyItemChanged(posicionSeleccionada);
                    ronda ++;
                    mytvAdapter.setText("");
                }
                seleccionLarga = true;
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
        this.posicionSeleccionada = posicionSeleccionada;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ViewHolder (View itemView){
            super(itemView);
            myTextView = itemView.findViewById(R.id.constraint);
        }
    }
    public boolean isSeleccionLarga() {
        return seleccionLarga;
    }

    public void setSeleccionLarga(boolean seleccionLarga) {
        this.seleccionLarga = seleccionLarga;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }
    public int getRonda() {
        return ronda;
    }

    public void setMytvAdapter(String texto) {
        mytvAdapter.setText(texto);
    }

}
