package com.example.calculadora2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        EditText myedt1, myedt2;
        TextView mytv3;
        Button myboton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myedt1 = (EditText) findViewById(R.id.edt1);
        myedt2 = (EditText) findViewById(R.id.edt2);

        mytv3 = (TextView) findViewById(R.id.tv3);

        myboton = (Button) findViewById(R.id.bt1);

        myboton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mytv3.setText("");
                return true;
            }
        });
    }

    public void sumar(View v){
        Double numero1, numero2, numero3;

        numero1 = Double.parseDouble(myedt1.getText().toString());
        numero2 = Double.parseDouble(myedt2.getText().toString());

        numero3 = numero1 + numero2;

         mytv3.setText(String.valueOf(numero3));
    }
}