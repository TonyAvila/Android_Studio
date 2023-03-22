package com.example.e009_persistencia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myEditText;
    TextView myTextview;

    Integer progreso, progresoTotal = 0;

    SharedPreferences myprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = findViewById(R.id.editTextNumber);
        myTextview = findViewById(R.id.TextView);

        myprefs = getSharedPreferences("PreferenciasDAM", Context.MODE_PRIVATE);
    }

    public void anyadirPref(View view){
        String email = myEditText.getText().toString();

        SharedPreferences.Editor editor = myprefs.edit();
        editor.putString("email", email);
        editor.commit();
    }

    public void aniadirProgreso(View v){
        progreso = Integer.parseInt(myEditText.getText().toString());

        progresoTotal = progresoTotal + progreso;
    }
    public void recuperar_email(View view){
        String correo = myprefs.getString("email", "por_defecto@email,com");
        myTextview.setText( correo);

    }

    public void verProgreso(View v){
        myTextview.setText(progresoTotal.toString());
    }


    // UT5.1 - Persistencia y reconstruccion de una actividad
    // Bundle: objeto para pasarse informacion a si mismo

    // guardar progreso
    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mi_progreso_total", progresoTotal);
    }

    // restaurar progreso
    @Override
    protected void onRestoreInstanceState (@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        progresoTotal = savedInstanceState.getInt( "mi_progreso_total" );
        myTextview.setText( progresoTotal .toString());
    }
    public void abrir_activity (View view){
        Intent my_intent = new Intent(this, SettingsActivity.class);
        startActivity(my_intent);
    }
}