package com.example.boton_segmentado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button myPSP, myPMDM, myPSP_PMDM;
    TextView mytv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytv1 = (TextView) findViewById(R.id.tv1);

        myPSP = (Button) findViewById(R.id.PSP);
        myPMDM = (Button) findViewById(R.id.PMDM);
        myPSP_PMDM = (Button) findViewById(R.id.PSP_PMDM);

        myPSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mytv1.setText("Me encanta PSP");
            }
        });

        myPMDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mytv1.setText("Me encanta PMDM");
            }
        });

        myPSP_PMDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mytv1.setText("Adoro PSP+PMDM");

            }
        });


    }
}