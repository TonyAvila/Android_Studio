package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String paises [] = {"Seleccione", "Italia", "China", "Japon", "Rusia"};
    Spinner mySp2;
    private ArrayAdapter mAdapter;
    public TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = (TextView) findViewById(R.id.tv1);
        mySp2 = (Spinner) findViewById(R.id.sp2);

        mAdapter = new ArrayAdapter<>( this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, paises);
        mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        mySp2.setAdapter(mAdapter);
        mySp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccionado = mySp2.getSelectedItem().toString();
                txtResultado.setText("Seleccionado: " + seleccionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                txtResultado.setText("No hay seleccion");
            }
        });

    }
}