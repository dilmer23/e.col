package com.example.ecol;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


public class fragment_regimen_de_velocidad extends Fragment {
   private CheckBox categoria1,categoria2,categoria3,categoria4;
   private TextView puntuacion;

    public fragment_regimen_de_velocidad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_regimen_de_velocidad, container, false);
        categoria1 = (CheckBox) view.findViewById(R.id.categoria1);
        categoria2 = (CheckBox) view.findViewById(R.id.categoria2);
        categoria3 = (CheckBox) view.findViewById(R.id.categoria3);
        categoria4 = (CheckBox) view.findViewById(R.id.categoria4);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        categoria1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (categoria1.isChecked()){
                    puntuacion.setText("10");
                    //categoria1.setChecked(false);
                    categoria2.setChecked(false);
                    categoria3.setChecked(false);
                    categoria4.setChecked(false);
                    guadra();
                }
            }
        });

        categoria2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (categoria2.isChecked()){
                    puntuacion.setText("8");
                    categoria1.setChecked(false);
                    //categoria2.setChecked(false);
                    categoria3.setChecked(false);
                    categoria4.setChecked(false);
                    guadra();
                }
            }
        });

        categoria3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (categoria3.isChecked()){
                    puntuacion.setText("6");
                    categoria1.setChecked(false);
                    categoria2.setChecked(false);
                    //categoria3.setChecked(false);
                    categoria4.setChecked(false);
                    guadra();
                }
            }
        });

        categoria4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (categoria1.isChecked()){
                    puntuacion.setText("4");
                    categoria1.setChecked(false);
                    categoria2.setChecked(false);
                    categoria3.setChecked(false);
                    //categoria4.setChecked(false);
                    guadra();
                }
            }
        });
        
        return view;
    }

    private void guadra() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String puntosrapidos_sedimentos = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_regimen_velocidad",puntosrapidos_sedimentos);
        editor.commit();

    }

}
