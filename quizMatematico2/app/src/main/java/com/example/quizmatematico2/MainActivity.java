package com.example.quizmatematico2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button btnGenerador, btnComprobar;
    public TextView txtNumeroAleatorio, txtResultado;
    public CheckBox cbdiv2, cbdiv3, cbdiv5, cbdiv10, cbdivNo;
    public ImageView ivOk, ivKo, ivInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerador = (Button) findViewById(R.id.Generador);
        btnComprobar = (Button) findViewById(R.id.comprobar);

        txtNumeroAleatorio = (TextView) findViewById(R.id.numAleatorio);
        txtResultado = (TextView) findViewById(R.id.result);

        cbdiv2 = (CheckBox) findViewById(R.id.div2);
        cbdiv3 = (CheckBox) findViewById(R.id.div3);
        cbdiv5 = (CheckBox) findViewById(R.id.div5);
        cbdiv10 = (CheckBox) findViewById(R.id.div10);
        cbdivNo = (CheckBox) findViewById(R.id.divNo);

        ivOk = (ImageView) findViewById(R.id.ok);
        ivKo = (ImageView) findViewById(R.id.ko);
        ivInt = (ImageView) findViewById(R.id.inter);

        btnGenerador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aleatorio = (int)(Math.random()*(1000-2000+1)+2000);

                txtNumeroAleatorio.setText("   " + String.valueOf(aleatorio));
            }
        });

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String variable = String.valueOf(txtNumeroAleatorio.getText());


                if (!variable.isEmpty()) {
                    Double num = Double.parseDouble(txtNumeroAleatorio.getText().toString());

                    boolean si_no = true;

                    if (si_no) {
                        if (cbdiv2.isChecked()) {
                            if (!(num % 2 == 0)) {
                                si_no = false;
                            }
                        } else {
                            if (num % 2 == 0) {
                                si_no = false;
                            }
                        }
                    }

                    if (si_no) {
                        if (cbdiv3.isChecked()) {
                            if (!(num % 3 == 0)) {
                                si_no = false;
                            }
                        } else {
                            if (num % 3 == 0) {
                                si_no = false;
                            }
                        }
                    }

                    if (si_no) {
                        if (cbdiv5.isChecked()) {
                            if (!(num % 5 == 0)) {
                                si_no = false;
                            }
                        } else {
                            if (num % 5 == 0) {
                                si_no = false;
                            }
                        }
                    }

                    if (si_no) {
                        if (cbdiv10.isChecked()) {
                            if (!(num % 10 == 0)) {
                                si_no = false;
                            }
                        } else {
                            if (num % 10 == 0) {
                                si_no = false;
                            }
                        }
                    }
                    if (si_no) {
                        if ((cbdiv2.isChecked() || cbdiv3.isChecked() || cbdiv5.isChecked() || cbdiv10.isChecked()) && cbdivNo.isChecked()) {
                            si_no = false;
                        }
                    }

                    if ((!cbdiv2.isChecked() && !cbdiv3.isChecked() && !cbdiv5.isChecked() && !cbdiv10.isChecked()) && !cbdivNo.isChecked()) {
                        txtResultado.setText("Debe escoger al menos una de las opciones");
                        ivOk.setVisibility(View.INVISIBLE);
                        ivKo.setVisibility(View.INVISIBLE);
                        ivInt.setVisibility(View.VISIBLE);
                    } else if (si_no == true) {
                        txtResultado.setText("Correcto");
                        ivInt.setVisibility(View.INVISIBLE);
                        ivOk.setVisibility(View.VISIBLE);
                        ivKo.setVisibility(View.INVISIBLE);
                    } else {
                        txtResultado.setText("Error");
                        ivInt.setVisibility(View.INVISIBLE);
                        ivOk.setVisibility(View.INVISIBLE);
                        ivKo.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}