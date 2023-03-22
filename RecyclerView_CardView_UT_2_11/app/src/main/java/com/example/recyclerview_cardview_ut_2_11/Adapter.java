package com.example.recyclerview_cardview_ut_2_11;

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
    List<Cartas> misCartas;
    Context miContexto;

    LayoutInflater miInflater;

    public Adapter(List<Cartas>misCartas, Context contexto){
        this.misCartas = misCartas;
        this.miContexto = contexto;
        this.miInflater = LayoutInflater.from(contexto);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = miInflater.inflate(R.layout.fila, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        com.example.recyclerviewcolores.Color color = misCartas.get(position);
        holder.myTextView2.setText(color.getNombre() + "  " + misCartas.size());
        holder.myTextView.setText(color.getCodigo());
        holder.myTextView.setTextColor(Color.WHITE);
        holder.myTextView2.setTextColor(Color.WHITE);

        if (posicionSeleccionada == position) {
            holder.myTextView.setBackgroundColor(Color.BLACK);
        } else {
            holder.myTextView.setBackgroundColor(Color.parseColor(color.getCodigo()));

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
        return misCartas.size();
    }

    public int getPosicionSeleccionada(){
        return posicionSeleccionada;
    }

    public void setPosicionSeleccionada(int posicionSeleccionada) {
        this.posicionSeleccionada = RecyclerView.NO_POSITION;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView, myTextView2;
        ViewHolder (View itemView){
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv1);
            myTextView2 = itemView.findViewById(R.id.tv2);
        }
    }
}