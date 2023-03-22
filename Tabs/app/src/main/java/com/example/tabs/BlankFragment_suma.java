package com.example.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment_suma#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment_suma extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment_suma() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment_suma newInstance(String param1, String param2) {
        BlankFragment_suma fragment = new BlankFragment_suma();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        EditText myedt1, myedt2;
        TextView mytv1;
        Button mybt1;

        View vista;
        vista = inflater.inflate(R.layout.fragment_blank_suma, container, false);

        myedt1 = vista.findViewById(R.id.edt1);
        myedt2 = vista.findViewById(R.id.edt2);
        mytv1 = vista.findViewById(R.id.tv1);
        mybt1 = vista.findViewById(R.id.bt1);

        mybt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float n1, n2, n3;
                n1= Float.valueOf(myedt1.getText().toString());
                n2= Float.valueOf(myedt2.getText().toString());
                n3 = n1 + n2;

                mytv1.setText(n3.toString());
            }
        });



        return vista;
    }
}