package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String anime [] = {" ","one piece", "boruto", "Gintama"};
    String musica [] = {" ","Dvicio", "Taburete", "Sidecars"};
    String serie [] = {" ","Los Simpson", "Walking Dead", "Juegos de tronos"};

    Spinner mySp1;
    Spinner mySp2;
    private ArrayAdapter mAdapter;
    public ImageView myiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySp1 = (Spinner) findViewById(R.id.sp1);
        mySp1.setPrompt("Selecciona una ópcion");
        mySp2 = (Spinner) findViewById(R.id.sp2);

        myiv = (ImageView) findViewById(R.id.iv);

        mySp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion= mySp1.getSelectedItem().toString();
                if (seleccion.equalsIgnoreCase( "Serie")){
                    mAdapter = new ArrayAdapter<>( getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, serie);
                    mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    mySp2.setVisibility(View.VISIBLE);
                    mySp2.setAdapter(mAdapter);

                } else if (seleccion.equalsIgnoreCase( "Grupo música")){
                    mAdapter = new ArrayAdapter<>(  getApplicationContext(),  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, musica);
                    mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    mySp2.setVisibility(View.VISIBLE);
                    mySp2.setAdapter(mAdapter);

                } else if (seleccion.equalsIgnoreCase( "anime")){
                    mAdapter = new ArrayAdapter<>(  getApplicationContext(),  androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, anime);
                    mAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                    mySp2.setVisibility(View.VISIBLE);
                    mySp2.setAdapter(mAdapter);
                } else {
                    mySp2.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mySp2.setVisibility(View.INVISIBLE);
            }
        });

        mySp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion2= mySp2.getSelectedItem().toString();
                myiv.setVisibility(View.VISIBLE);
                switch (seleccion2) {
                    case "one piece":
                        myiv.setImageResource(R.drawable.one_piece);
                        break;
                    case "boruto":
                        myiv.setImageResource(R.drawable.boruto);
                        break;
                    case "Gintama" :
                        myiv.setImageResource(R.drawable.gintama);
                        break;
                    case "Dvicio":
                        myiv.setImageResource(R.drawable.dvicio);
                        break;
                    case "Taburete":
                        myiv.setImageResource(R.drawable.taburete);
                        break;
                    case  "Sidecars":
                        myiv.setImageResource(R.drawable.sidecars);
                        break;
                    case "Los Simpson" :
                        myiv.setImageResource(R.drawable.los_simpson);
                        break;
                    case "Walking Dead":
                        myiv.setImageResource(R.drawable.walking_dead);
                        break;
                    case  "Juegos de tronos":
                        myiv.setImageResource(R.drawable.juegos_de_tronos);
                        break;
                    default:
                        myiv.setVisibility(View.INVISIBLE);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                myiv.setVisibility(View.INVISIBLE);
            }
        });

    }
}