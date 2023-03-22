package com.example.mymenunavegacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class WebFragment extends Fragment {

    public WebFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista;
        WebView miWeb;
        vista = inflater.inflate(R.layout.fragment_web, container, false);
        miWeb = vista.findViewById(R.id.miWeb);
        miWeb.loadUrl("https://iesclaradelrey.es/portal/index.php/es/");

        return vista;
    }
}