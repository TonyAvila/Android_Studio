package com.example.recyclerview;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    EditText myEditext;
    ArrayList <String> animalNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditext = (EditText) findViewById(R.id.edt);

        animalNames.add("Caballo");
        animalNames.add("Vaca");
        animalNames.add("Perro");
        animalNames.add("Gato");
        animalNames.add("León");
        animalNames.add("Tigre");
        animalNames.add("Rinoceronte");
        animalNames.add("Elefante");
        animalNames.add("Águila");
        animalNames.add("Mariposa");
        animalNames.add("Serpiente");
        animalNames.add("Oso");

        RecyclerView recyclerView = findViewById(R.id.rvAnimales);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayout);
        adapter = new Adapter(animalNames, this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration midividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        recyclerView.addItemDecoration(midividerItemDecoration);


    }
    public void borrar(View v){
        int position = adapter.getPosicionSeleccionada();
        Context context = getApplicationContext();
        int dutation = Toast.LENGTH_LONG;

        if (position<0){
            String text = "Debe Seleccionar un animal para borrar";
            Toast toast = Toast.makeText(context, text, dutation);
            toast.show();
            return;
        }
        animalNames.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(0,animalNames.size());
    }
    public  void anyadir(View v){
        int insertIndex, position = adapter.getPosicionSeleccionada();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        if (position<0){position =-1;}
        String item;
        item = myEditext.getText().toString();
        if (item.isEmpty()){
            String text = "Debe introducir un animal";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        insertIndex =position+1;
        animalNames.add(insertIndex, item);
        adapter.notifyItemInserted(insertIndex);
        adapter.notifyItemRangeChanged(0, animalNames.size());
    }
}