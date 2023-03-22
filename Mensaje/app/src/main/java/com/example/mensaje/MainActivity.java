package com.example.mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
 /*   public void verToast(View view){
        Context context = getApplicationContext();
        String text = "hello toast";
        int duration= Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }*/
    public void verToast(View view){
        LayoutInflater myInflter = getLayoutInflater();
        View myLayout = myInflter.inflate(R.layout.layout_toast, null);
        Toast myToast = new Toast(getApplicationContext());
        myToast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        myToast.setDuration(Toast.LENGTH_LONG);
        myToast.setView(myLayout);
        myToast.show();
 }
    public void myAlert(View vista){
        AlertDialog.Builder MyAlert = new AlertDialog.Builder(this);
        MyAlert.setTitle("CLASE PMDM DAW+DAM");
        LayoutInflater myinflater = getLayoutInflater();
        View myView_Inflado =  myinflater.inflate(R.layout.layout_login, null);
        MyAlert.setView(myView_Inflado);
    //    MyAlert.setMessage("Aprendiendo a poner AlertDialog");
        MyAlert.setItems(R.array.deportes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// i indica la posición del array clickeada
                pinta_deporte(i);
            }});
        MyAlert.setPositiveButton("Perfecto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                paquete();
            }
        });
        MyAlert.setNegativeButton("No me entero", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText myUsername;
                myUsername = (EditText) myView_Inflado.findViewById(R.id.username);
                String nombre = myUsername.getText().toString();
                hola(nombre);
            }
        });
        /*MyAlert.setNeutralButton("A ver si ahora", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                paquete();
            }
        });*/
        AlertDialog dialog = MyAlert.create();
        dialog.show(); }

    private void paquete(){
        myImageView = findViewById(R.id.iv1);
        myImageView.setVisibility(View.VISIBLE);
        myImageView.setImageResource(R.drawable.manzanas);
    }
    private void paquete2(){
        myImageView = findViewById(R.id.iv1);
        myImageView.setVisibility(View.VISIBLE);
        myImageView.setImageResource(R.drawable._ndice);
    }
    private void paquete3(){
        myImageView = findViewById(R.id.iv1);
        myImageView.setVisibility(View.INVISIBLE);
    }
    private void pinta_deporte(int i){
        Context context = getApplicationContext();
        String text= null;
        switch (i){
            case 0:{
                text= "Usted eligio la opcion 1. Futbol";
                break;
            }
            case 1:{
                text= "Usted eligio la opcion 2. Futbolin";
                break;
            }
            case 2:{
                text= "Usted eligio la opcion 3. Futbol sala";
                break;
            }
            case 3:{
                text= "Usted eligio la opcion 4. Futbol 7";
                break;
            }
        }
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void hola (String nombre){
        Context context = getApplicationContext();
        String text = "Hola " + nombre;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}