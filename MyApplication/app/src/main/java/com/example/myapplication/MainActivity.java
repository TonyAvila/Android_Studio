package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView mytv1;
    Button mybt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytv1 = (TextView) findViewById(R.id.tv1);
        mybt1 = (Button) findViewById (R.id.bt1);

        mybt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                mytv1.setText("ADIOS MUNDO CRUEL");
            }
        });

        mybt1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mytv1.setText("ADIOOOOOOS MUNDO CRUEL");
                return false;
            }
        });

    }
}

 /*   public void adios (View v){
        mytv1.setText("ADIOS MUNDO CRUEL");
    }
}*/