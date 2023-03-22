package com.example.dados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButtonToggleGroup;

import kotlin.random.Random;

public class MainActivity extends AppCompatActivity {


    String par_impar [] = {"Par", "Impar"};
    String mayor_menor_7 [] = {"Mayor que 7", "Menor que 7"};
    Boolean gano = false, activado = false;
    int numdado1, numdado2;

    Button mybtParImpar, mybtMayorMenor7, myelb1;
    Spinner mySp1;
    TextView mytv1, mytv2;
    EditText myjuagada;
    MaterialButtonToggleGroup mytb;
    ImageView myiv, myivgif, myivdado1, myivdado2;
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
        myivdado1 = (ImageView) findViewById(R.id.ivdado1);
        myivdado2 = (ImageView) findViewById(R.id.ivdado2);

        mytb = (MaterialButtonToggleGroup) findViewById(R.id.tb);
        mytv1 = (TextView) findViewById(R.id.tv1);
        mytv2 = (TextView) findViewById(R.id.tv2);


        myjuagada = (EditText) findViewById(R.id.jugada);

        mybtParImpar= (Button) findViewById(R.id.btParImpar);
        mybtMayorMenor7= (Button) findViewById(R.id.btMayorMenor7);
        myelb1 = (Button) findViewById(R.id.elb1);

;       mySp1 = (Spinner) findViewById(R.id.sp1);

        mybtParImpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAdapter = new ArrayAdapter<>( getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, par_impar);
                mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                mySp1.setAdapter(mAdapter);
                activado =true;
                cambiarColoresBotones(mybtParImpar,mybtMayorMenor7);
            }
        });

        mybtMayorMenor7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter = new ArrayAdapter<>( getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, mayor_menor_7);
                mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                mySp1.setAdapter(mAdapter);
                activado =true;
                cambiarColoresBotones(mybtMayorMenor7, mybtParImpar);
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
                                numdado1 = numeroAleatorio();
                                numdado2 = numeroAleatorio();


                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        resultadoJugada();
                                        seguirJugando();
                                        myelb1.setEnabled(true);
                                        mandarImagenDado(myivdado1,numdado1);
                                        mandarImagenDado(myivdado2,numdado2);
                                    }
                                }, 3000);
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
            int aleatorio = (int)(Math.random()*6+1);

            return aleatorio;
        }

    @SuppressLint("ResourceAsColor")
    public void resultadoJugada(){
        int resultado = numdado1 + numdado2;
        String tipo_partida = mySp1.getSelectedItem().toString();
        boolean win = false;
        switch (tipo_partida){
            case  "Par":
                if (resultado%2 == 0)
                    win = true;
                break;
            case "Impar":
                if (resultado%2 != 0)
                win = true;;
                break;
            case "Mayor que 7":
                if (resultado > 7)
                    win = true;
                break;
            case "Menor que 7":
                if (resultado < 7)
                    win = true;
                break;
            default:

                break;
        }
        int saldofinal = Integer.parseInt(mytv2.getText().toString());
        if (win){
            saldofinal += Integer.parseInt(myjuagada.getText().toString());
            myiv.setImageResource(R.drawable.ganar_dados);
            gano = true;
        } else {
            saldofinal -= Integer.parseInt(myjuagada.getText().toString());
            myiv.setImageResource(R.drawable.perder_dados);
            gano = false;
        }
        myiv.setVisibility(View.VISIBLE);
        mytv2.setText(String.valueOf(saldofinal));
        if (saldofinal==0){
            mytv2.setTextColor(Color.RED);
        }
    }

    public void verDados(View view){
       myInflter = getLayoutInflater();
       View gif = myInflter.inflate(R.layout.layout_gif_dados, null);
      //  myivgif.setBackgroundColor(Color.WHITE);
      //Glide.with(getApplicationContext().;
        Toast myToastDados = new Toast(getApplicationContext());
        Glide.with(this).load(R.drawable.dado_imagen_animada).into((ImageView) gif.findViewById(R.id.ivdados));

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
    public void cambiarColoresBotones(Button seleccionado, Button noSeleccionado){
        seleccionado.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#f57f17")));
        seleccionado.setTextColor(Color.parseColor("#fdebd0"));

        noSeleccionado.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#fdebd0")));
        noSeleccionado.setTextColor(Color.parseColor("#f57f17"));

    }
    public void mandarImagenDado(ImageView iv, int num){
        switch (num){
            case  1:
                iv.setImageResource(R.drawable.cara1);
                break;
            case  2:
                iv.setImageResource(R.drawable.cara2);
                break;
            case  3:
                iv.setImageResource(R.drawable.cara3);
                break;
            case  4:
                iv.setImageResource(R.drawable.cara4);
                break;
            case  5:
                iv.setImageResource(R.drawable.cara5);
                break;
            case  6:
                iv.setImageResource(R.drawable.cara6);
                break;
            default:
                break;
        }

    }
}

