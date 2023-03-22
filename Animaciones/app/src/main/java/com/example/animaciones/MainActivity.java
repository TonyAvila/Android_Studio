package com.example.animaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView myiV1;
    AnimationDrawable miTragaperras;
    ImageView myImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myiV1 = (ImageView) findViewById(R.id.iV1);
        myiV1.setBackgroundResource( R.drawable.tragaperras);
        miTragaperras = (AnimationDrawable) myiV1.getBackground();
    }
    protected void onStart() {
        super.onStart();
        miTragaperras .start();
    };

    public void parar (View view){
        miTragaperras.stop();
    }
}