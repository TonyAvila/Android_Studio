package com.example.examen_antonio_avila;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class MainActivity extends AppCompatActivity {

    String par_impar [] = {"Par", "Impar"};
    String docena [] = {"1 docena", "2 Doccena", "3 Docena"};
    Boolean gano = false, activado = false;

    Button mybtParImpar, mybtDocena, myelb1;
    Spinner mySp1;
    TextView mytv1, mytv2, mytv3;
    EditText myjuagada;
    MaterialButtonToggleGroup mytb;
    ImageView myiv, myivgif;
    LayoutInflater myInflter;

    Handler handler = new Handler();

    private ArrayAdapter mAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myiv = (ImageView) findViewById(R.id.iv);
        myivgif = (ImageView) findViewById(R.id.ivgif);
        mytb = (MaterialButtonToggleGroup) findViewById(R.id.tb);
        mytv1 = (TextView) findViewById(R.id.tv1);
        mytv2 = (TextView) findViewById(R.id.tv2);
        mytv3 = (TextView) findViewById(R.id.tv3);


        myjuagada = (EditText) findViewById(R.id.jugada);

        mybtParImpar= (Button) findViewById(R.id.btParImpar);
        mybtDocena= (Button) findViewById(R.id.Docena);
        myelb1 = (Button) findViewById(R.id.elb1);

        mySp1 = (Spinner) findViewById(R.id.sp1);

        mybtParImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter = new ArrayAdapter<>( getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, par_impar);
                mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                mySp1.setAdapter(mAdapter);
                activado =true;
            }
        });

        mybtDocena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter = new ArrayAdapter<>( getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, docena);
                mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                mySp1.setAdapter(mAdapter);
                activado =true;
            }
        });

        myelb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensaje="";
                //trampa pregunatar como corregir
                if (!activado){
                    mensaje = "Tienes que elegir un tipo de juego";
                    Toast.makeText(MainActivity.this, mensaje,Toast.LENGTH_SHORT).show();

                } else {
                    if (!myjuagada.getText().toString().isEmpty()){
                        int apuesta = Integer.parseInt(myjuagada.getText().toString());
                        int saldo  = Integer.parseInt(mytv2.getText().toString());

                        if (saldo==0 || apuesta==0) {
                            if (saldo==0)
                                mensaje = "Tu saldo es 0, ya no puedes Jugar.";
                            if (apuesta==0)
                                mensaje = "Tu apuesta tiene que ser mayor de 0 para poder Jugar.";

                            Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                        } else {
                            if (apuesta > saldo) {
                                mensaje = "Tu saldo es inferior a tu apuesta, baja tu apuesta.";
                                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_SHORT).show();
                            } else {
                                myelb1.setEnabled(false);
                                verDados(myivgif);
                                mytv3.setText(String.valueOf(numeroAleatorio()));

                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        resultadoJugada();
                                        seguirJugando();
                                        myelb1.setEnabled(true);
                                    }
                                }, 4000);
                            }
                        }
                    } else {
                        mensaje = "Tienes que introducir una cantidad para apostar";
                        Toast.makeText(MainActivity.this, mensaje,Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }
    public void verToast(String texto){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, texto, duration);
        toast.show();
    }

    public int numeroAleatorio(){
        int aleatorio = (int)(Math.random()*36+1);

        return aleatorio;
    }

    public void resultadoJugada(){
        int resultado = Integer.parseInt(mytv3.getText().toString());
        String tipo_partida = mySp1.getSelectedItem().toString();
        int ganancias= 1;
        boolean win = false;
        switch (tipo_partida){
            case  "Par":
                if (resultado%2 == 0 && resultado!=0)
                    win = true;
                break;
            case "Impar":
                if (resultado%2 != 0)
                    win = true;;
                break;
            case "1 docena":
                if (resultado > 1 && resultado <= 12) {
                    win = true;
                    ganancias = 2;
                }
                break;
            case "2 Doccena":
                if (resultado > 12 && resultado <= 24) {
                    win = true;
                    ganancias = 2;
                }
                break;
            case "3 docena":
                if (resultado > 24 && resultado <= 36) {
                    win = true;
                    ganancias = 2;
                }
                break;
            default:

                break;
        }
        int saldofinal = Integer.parseInt(mytv2.getText().toString());
        if (win){
            saldofinal += (Integer.parseInt(myjuagada.getText().toString())*ganancias);
            gano = true;
        } else {
            saldofinal -= Integer.parseInt(myjuagada.getText().toString());
            gano = false;
        }
        // mostrar imagen si dobla saldo o si se queda en 0
        myiv.setVisibility(View.VISIBLE);
        mytv2.setText(String.valueOf(saldofinal));
    }

    public void verDados(View view){
        myInflter = getLayoutInflater();
        View gif = myInflter.inflate(R.layout.layout_gif_dados, null);
        Toast myToastDados = new Toast(getApplicationContext());
        Glide.with(this).load(R.drawable.ruleta_casino_89320).into((ImageView) gif.findViewById(R.id.ivdados));

        myToastDados.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        myToastDados.setDuration(Toast.LENGTH_LONG);
        myToastDados.setView(gif);
        myToastDados.show();
    }

    public void seguirJugando(){
        String frase  ="";
        if (gano)
            frase = "Ganaste";
        else
            frase = "Perdiste";
        AlertDialog.Builder MyAlert = new AlertDialog.Builder(MainActivity.this);
        MyAlert.setTitle(frase);
        MyAlert.setMessage("¿Quieres seguir jugando?");
        MyAlert.setNegativeButton("SI", null);
        MyAlert.setPositiveButton("SALIR DEL JUEGO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dialog = MyAlert.create();
        dialog.show();

    }
}

