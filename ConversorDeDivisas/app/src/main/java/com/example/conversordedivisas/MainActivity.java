package com.example.conversordedivisas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    ArrayList<Divisas> divisas;

    TextView mytv4;
    Button myconvertir;
    Switch myvips;

    EditText myedt;

    String euros;

    Integer posicionSeleccionada = -1;
    Boolean longClik;
    Seleccion seleccion = new Seleccion("", 0, 0);

    int ronda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytv4 = (TextView) findViewById(R.id.tv4);
        myconvertir = (Button) findViewById(R.id.convertir);
        myvips = (Switch) findViewById(R.id.vips);
        myedt = (EditText) findViewById(R.id.euros);


        divisas = new ArrayList<>();
        String[] divisasNames = getResources().getStringArray(R.array.nombres_divisas);
        String[] divisasCodigos = getResources().getStringArray(R.array.siglas_divisas);
        String[] divisasValor = getResources().getStringArray(R.array.valor_divisas);
        String[] divisasSimbolo = getResources().getStringArray(R.array.simbolo_divisas);

        for (int i = 0; i < divisasNames.length; i++) {
            Divisas divisa = new Divisas(divisasNames[i], divisasValor[i], divisasCodigos[i], divisasSimbolo[i]);
            divisas.add(divisa);
        }

        RecyclerView recyclerView = findViewById(R.id.rvDivisas);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayout);
        adapter = new Adapter(divisas, this, 0, mytv4);
        recyclerView.setAdapter(adapter);

        // DividerItemDecoration midividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        //recyclerView.addItemDecoration(midividerItemDecoration);


        myconvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion;
                float cambio, euros;
                float comision = 1;
                String mensaje = "";

                if (!myvips.isChecked()) comision -= 0.01;

                if (myedt.getText().toString().isEmpty()) {
                    mensaje = "Tienes que introducir una cantidad en euros.";
                    Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                } else {
                    if (adapter.getPosicionSeleccionada() == -1) {
                        mensaje = "Tienes que seleccionar una moneda de cambio.";
                        Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                    } else {
                        euros = Float.parseFloat(myedt.getText().toString());
                        posicion = adapter.getPosicionSeleccionada();
                        cambio = euros * comision * Float.parseFloat(divisas.get(posicion).getConversion());
                        DecimalFormat formatearCambio = new DecimalFormat("#.##");
                        formatearCambio.setRoundingMode(RoundingMode.FLOOR);
                        String cambio2digitos = formatearCambio.format(cambio);
                        mytv4.setText(cambio2digitos + " " + divisas.get(posicion).getSimbolo());

                        seleccion.setEuros(myedt.getText().toString());
                        seleccion.setDivisa(adapter.getPosicionSeleccionada());
                        seleccion.setRonda(adapter.getRonda());
                    }
                }
            }
        });

        myvips.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int posicion;
                float cambio, euros;
                float comision = 1;

                if (!myvips.isChecked()) comision -= 0.01;

                if (myedt.getText().toString().isEmpty()) {

                } else {
                    if (adapter.getPosicionSeleccionada() == -1) {
                    } else {
                        if (seleccion.getDivisa() == adapter.getPosicionSeleccionada() && seleccion.getEuros().equals(myedt.getText().toString()) && seleccion.getRonda() == adapter.getRonda()) {
                            euros = Float.parseFloat(myedt.getText().toString());
                            posicion = adapter.getPosicionSeleccionada();
                            cambio = euros * comision * Float.parseFloat(divisas.get(posicion).getConversion());
                            DecimalFormat formatearCambio = new DecimalFormat("#.##");
                            formatearCambio.setRoundingMode(RoundingMode.FLOOR);
                            String cambio2digitos = formatearCambio.format(cambio);
                            mytv4.setText(cambio2digitos + " " + divisas.get(posicion).getSimbolo());
                        }
                    }
                }
            }
        });

        myedt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mytv4.setText("");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState) {
        super.onSaveInstanceState(outState) ;
        outState.putString( "seleccion_euros" , mytv4.getText().toString());
        outState.putInt( "seleccion_adapter" , adapter.getPosicionSeleccionada() );
        outState.putBoolean( "seleccion_longClick" , adapter.isSeleccionLarga());
        outState.putInt( "seleccion_ronda" , adapter.getRonda());
    }



    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState) ;


        posicionSeleccionada = savedInstanceState.getInt("seleccion_adapter");
        adapter.setPosicionSeleccionada(posicionSeleccionada);

        longClik = savedInstanceState.getBoolean("seleccion_longClick");
        adapter.setSeleccionLarga(longClik);

        ronda = savedInstanceState.getInt("seleccion_ronda");
        adapter.setRonda(ronda);

        euros = savedInstanceState.getString( "seleccion_euros" );
        mytv4.setText(euros);

        seleccion.setEuros(myedt.getText().toString());
        seleccion.setRonda(ronda);
        seleccion.setDivisa(posicionSeleccionada);
    }

}

