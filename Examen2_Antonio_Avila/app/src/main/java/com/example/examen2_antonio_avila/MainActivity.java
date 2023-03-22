package com.example.examen2_antonio_avila;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}