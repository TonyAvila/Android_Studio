package com.example.recyclerview_cardview_ut_2_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    ArrayList<Color> listaColores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Color color1;
        color1= new Color("CIAN CLARO", "#E0FFFF");
        listaColores.add(color1);
        color1= new Color("LINO", "#FAF0E6");
        listaColores.add(color1);
        color1= new Color("BEIGE", "#F5F5DC");
        listaColores.add(color1);
        color1= new Color("LAVANDA", "#E6E6FA");
        listaColores.add(color1);
        color1= new Color("ROSA", "#FFC0CB");
        listaColores.add(color1);
        color1= new Color("AZUL CLARO", "#ADD8E6");
        listaColores.add(color1);
        color1= new Color("CAQUI", "#F0D58C");
        listaColores.add(color1);
        color1= new Color("CIAN", "#00FFFF");
        listaColores.add(color1);
        color1= new Color("PLATA", "#C0C0C0");
        listaColores.add(color1);
        color1= new Color("VIOLETA", "#EE82EE");
        listaColores.add(color1);
        color1= new Color("AMARILLO", "#FFFF00");
        listaColores.add(color1);
        color1= new Color("VERDE MAR CLARO", "#20B2AA");
        listaColores.add(color1);
        color1= new Color("CIAN CLARO", "#E0FFFF");
        listaColores.add(color1);
        color1= new Color("LINO", "#FAF0E6");
        listaColores.add(color1);
        color1= new Color("BEIGE", "#F5F5DC");
        listaColores.add(color1);
        color1= new Color("LAVANDA", "#E6E6FA");
        listaColores.add(color1);
        color1= new Color("ROSA", "#FFC0CB");
        listaColores.add(color1);
        color1= new Color("AZUL CLARO", "#ADD8E6");
        listaColores.add(color1);
        color1= new Color("CAQUI", "#F0D58C");
        listaColores.add(color1);
        color1= new Color("CIAN", "#00FFFF");
        listaColores.add(color1);
        color1= new Color("PLATA", "#C0C0C0");
        listaColores.add(color1);
        color1= new Color("VIOLETA", "#EE82EE");
        listaColores.add(color1);
        color1= new Color("AMARILLO", "#FFFF00");
        listaColores.add(color1);
        color1= new Color("VERDE MAR CLARO", "#20B2AA");
        listaColores.add(color1);






        RecyclerView recyclerView = findViewById(R.id.rvColores);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayout);
        adapter = new Adapter(listaColores, this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration midividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        recyclerView.addItemDecoration(midividerItemDecoration);


    }


}