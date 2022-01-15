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


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_frecuencia_rapidos extends Fragment {
    private CheckBox rapido1,rapido2,rapido3,rapido4,rapido5;
    TextView puntuacion;


    public fragment_frecuencia_rapidos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment_frecuencia_rapidos, container, false);
        rapido1 = (CheckBox) view.findViewById(R.id.rapido1);
        rapido2 = (CheckBox) view.findViewById(R.id.rapido2);
        rapido3 = (CheckBox) view.findViewById(R.id.rapido3);
        rapido4 = (CheckBox) view.findViewById(R.id.rapido4);
        rapido5 = (CheckBox) view.findViewById(R.id.rapido5);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        rapido1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rapido1.isChecked()){
                    puntuacion.setText("10");
                    rapido2.setChecked(false);
                    rapido3.setChecked(false);
                    rapido4.setChecked(false);
                    rapido5.setChecked(false);
                    guadra();
                }
            }
        });
        rapido2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rapido2.isChecked()){
                    puntuacion.setText("8");
                    rapido1.setChecked(false);
                    rapido3.setChecked(false);
                    rapido4.setChecked(false);
                    rapido5.setChecked(false);
                    guadra();
                }
            }
        });
        rapido3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rapido3.isChecked()){
                    puntuacion.setText("6");
                    rapido2.setChecked(false);
                    rapido1.setChecked(false);
                    rapido4.setChecked(false);
                    rapido5.setChecked(false);
                    guadra();
                }
            }
        });
        rapido4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rapido4.isChecked()){
                    puntuacion.setText("4");
                    rapido2.setChecked(false);
                    rapido1.setChecked(false);
                    rapido3.setChecked(false);
                    rapido5.setChecked(false);
                    guadra();
                }
            }
        });
        rapido5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rapido5.isChecked()){
                    puntuacion.setText("2");
                    rapido2.setChecked(false);
                    rapido1.setChecked(false);
                    rapido4.setChecked(false);
                    rapido3.setChecked(false);
                    guadra();
                }
            }
        });
        return view;
    }

    private void guadra() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        String puntosrapidos_sedimentos = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_frecuencias_rapidos",puntosrapidos_sedimentos);
        editor.commit();
    }

}
