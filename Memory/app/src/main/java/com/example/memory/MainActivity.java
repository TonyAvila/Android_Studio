package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button mybtReiniciar, mybtSalir;
    TextView mytv;
    ImageButton myib, myib1, myib2, myib3, myib4, myib5, myib6, myib7, myib8,
            myib9, myib10, myib11, myib12, myib13, myib14, myib15, myibAnterior;;

   int numImagenAnterior, numBotonAnterior, puntuacion, aciertos;
   int [] arrayImagenes;
   ArrayList<Integer> desorden;
   ArrayList<ImageButton> arrayImageButton, bloqueados;
   Handler handler = new Handler();
   boolean compara=false;
    private ActionBar myToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mybtReiniciar = (Button) findViewById(R.id.btReiniciar);
        mybtSalir = (Button) findViewById(R.id.btSalir);
        mytv = (TextView) findViewById(R.id.tv);
        myib = (ImageButton) findViewById(R.id.ib);
        myib1 = (ImageButton) findViewById(R.id.ib1);
        myib2 = (ImageButton) findViewById(R.id.ib2);
        myib3 = (ImageButton) findViewById(R.id.ib3);
        myib4 = (ImageButton) findViewById(R.id.ib4);
        myib5 = (ImageButton) findViewById(R.id.ib5);
        myib6 = (ImageButton) findViewById(R.id.ib6);
        myib7 = (ImageButton) findViewById(R.id.ib7);
        myib8 = (ImageButton) findViewById(R.id.ib8);
        myib9 = (ImageButton) findViewById(R.id.ib9);
        myib10 = (ImageButton) findViewById(R.id.ib10);
        myib11 = (ImageButton) findViewById(R.id.ib11);
        myib12 = (ImageButton) findViewById(R.id.ib12);
        myib13 = (ImageButton) findViewById(R.id.ib13);
        myib14 = (ImageButton) findViewById(R.id.ib14);
        myib15 = (ImageButton) findViewById(R.id.ib15);

        arrayImagenes = new int[]{
                R.drawable.la0,
                R.drawable.la1,
                R.drawable.la2,
                R.drawable.la3,
                R.drawable.la4,
                R.drawable.la5,
                R.drawable.la6,
                R.drawable.la7};

        iniciarJuagada();

        for (int i= 0; i < arrayImageButton.size(); i++){
            ImageButton im = arrayImageButton.get(i);
            Integer numer = i;
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    revisarCarta(im, numer);
                }
            });
        }



        mybtReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarJuagada();
            }
        });

        mybtSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });


    }
    private ArrayList barajarCartas(ArrayList<Integer> desorden){
        desorden =  new ArrayList<>();
        for (int i= 0; i <8; i++ ){
            desorden.add(i);
            desorden.add(i);
        }
        bloqueados = crearArrayImmageButton();
        Collections.shuffle(desorden);

        return desorden;
    }

    private void mostrarTodasCartas(ArrayList<Integer> desorden){
        for (int i= 0; i < arrayImageButton.size(); i++) {
            ImageButton im = arrayImageButton.get(i);
            im.setImageResource(arrayImagenes[desorden.get(i)]);
            im.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void taparTemporizador() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i= 0; i < arrayImageButton.size(); i++) {
                    ImageButton im = arrayImageButton.get(i);
                    im.setImageResource(R.drawable.fondo);
                    im.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }
        }, 2000);
    }
    private void taparUno(ImageButton myboton) {
        myboton.setImageResource(R.drawable.fondo);
        myboton.setEnabled(true);
    }

    private void revisarCarta(ImageButton myboton, int num) {
        myboton.setImageResource(arrayImagenes[desorden.get(num)]);
        if (compara==true){
          // bloquear();
            if (desorden.get(num)!= numImagenAnterior) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myboton.setImageResource(R.drawable.fondo);
                        taparUno(myibAnterior);
                        cambiarPuntuacion(-1);
                    }
                }, 1000);
                desorden.remove(myboton);
                desorden.remove(myibAnterior);

            } else {
                myboton.setEnabled(false);
                cambiarPuntuacion(1);
                aciertos ++;
                if (aciertos == 8){
                   //creo el toast
                    LayoutInflater myInflter = getLayoutInflater();
                    View myLayout = myInflter .inflate( R.layout.toast_custom, null);
                    Toast myToast = new Toast(getApplicationContext());
                    myToast.setGravity( Gravity.BOTTOM, 0, 0);
                    myToast.setDuration( Toast.LENGTH_LONG);
                    myToast.setView( myLayout );

                    //y lo muestro
                    myToast.show();

                }
              //  desbloquear();
            }
            compara=false;
        } else {
            myboton.setEnabled(false);
            compara=true;
            numImagenAnterior =desorden.get(num);
            numBotonAnterior = num;
            myibAnterior=myboton;
        }
    }
    private void desbloquear() {
        for(int i=0;i< arrayImageButton.size();i++){
            if (bloqueados.contains(arrayImageButton.get(i))) {
                ImageButton im = arrayImageButton.get(i);
                im.setEnabled(true);
            }
        }
    }

    private void bloquear() {
        for(int i=0;i< arrayImageButton.size();i++){
                ImageButton im = arrayImageButton.get(i);
                im.setEnabled(false);

        }
    }

    private ArrayList<ImageButton> crearArrayImmageButton(){
        ArrayList<ImageButton> aib = new ArrayList<>();
        aib.add(myib);
        aib.add(myib1);
        aib.add(myib2);
        aib.add(myib3);
        aib.add(myib4);
        aib.add(myib5);
        aib.add(myib6);
        aib.add(myib7);
        aib.add(myib8);
        aib.add(myib9);
        aib.add(myib10);
        aib.add(myib11);
        aib.add(myib12);
        aib.add(myib13);
        aib.add(myib14);
        aib.add(myib15);

        return aib;
    }

    private void iniciarJuagada() {
        arrayImageButton = crearArrayImmageButton();
    //    bloqueados = crearArrayImmageButton();
        aciertos = 0;
        puntuacion= 0;
        mytv.setText("Iniciando Jugada");

        desorden = barajarCartas(desorden);
        mostrarTodasCartas(desorden);
        taparTemporizador();
        desbloquear();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mytv.setText("Puntuacion: "+ puntuacion);
            }
        }, 2000);
    }
    private void cambiarPuntuacion(int num) {
        puntuacion += num;
        if (puntuacion < 0)
            puntuacion = 0;

        mytv.setText("Puntuacion: "+ puntuacion);
    }
    public void myToast (View v){
        LayoutInflater myInflter = getLayoutInflater();
        View myLayout = myInflter .inflate( R.layout.toast_custom, null);
        Toast myToast = new Toast(getApplicationContext());
        myToast.setGravity( Gravity.CENTER_VERTICAL, 0, 0);
        myToast.setDuration( Toast.LENGTH_LONG);
        myToast.setView( myLayout );
    }
}