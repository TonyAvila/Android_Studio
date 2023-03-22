package com.example.bisiesto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button btnGenerador, btnComprobar;
    public TextView txtNumeroAleatorio, txtResultado;
    public RadioButton radioRBsi, radioRBno;
    public Switch swfondo;
    public ConstraintLayout ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerador = (Button) findViewById(R.id.Generador);
        btnComprobar = (Button) findViewById(R.id.comprobar);

        txtNumeroAleatorio = (TextView) findViewById(R.id.numAleatorio);
        txtResultado = (TextView) findViewById(R.id.result);

        radioRBsi = (RadioButton) findViewById(R.id.rbSi);
        radioRBno = (RadioButton) findViewById(R.id.rbNo);

        swfondo = (Switch) findViewById(R.id.fondo);

        ct = (ConstraintLayout) findViewById(R.id.constraint);

        swfondo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ct.setBackgroundColor(Color.parseColor("#f1f885"));
                    //ct.setBackgroundColor(R.color.palo);
                } else {
                    ct.setBackgroundColor(Color.WHITE);
                }
            }
        });


        btnGenerador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aleatorio = (int) (Math.random() * (2500 - 1900 + 1) + 1900);

                txtNumeroAleatorio.setText("   " + String.valueOf(aleatorio));
            }
        });

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String variable = String.valueOf(txtNumeroAleatorio.getText());


                if (!variable.isEmpty()) {
                    Double anio = Double.parseDouble(txtNumeroAleatorio.getText().toString());


                    if (anio > 0) {
                        //boolean si_no;
                        if (!radioRBsi.isChecked() && !radioRBno.isChecked()) {
                            txtResultado.setText("Debes marcar una opcion en el checkbox");
                            txtResultado.setTextColor(Color.BLUE);
                        } else {
                            if (radioRBsi.isChecked()) {
                                if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
                                    txtResultado.setText("Acertaste");
                                    txtResultado.setTextColor(Color.GREEN);
                                } else {
                                    txtResultado.setText("Fallaste");
                                    txtResultado.setTextColor(Color.RED);
                                }
                            }
                            if (radioRBno.isChecked()) {
                                if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
                                    txtResultado.setText("Fallaste");
                                    txtResultado.setTextColor(Color.RED);
                                } else {
                                    txtResultado.setText("Acertaste");
                                    txtResultado.setTextColor(Color.BLUE);
                                }
                            }
                        }
                    }
                } else {
                    txtResultado.setText("Debes crear un número aleatorio");
                    txtResultado.setTextColor(Color.MAGENTA);
                }
            }
        });


    }

    public void cerrar (View v){
        System.exit(0);
    }

}