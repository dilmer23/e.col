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


public class fragment_elementos_heteronegialidad extends Fragment {
    private CheckBox porcentaje1,porcentaje2,porcentaje3,porcentaje4,porcentaje5;
    private TextView puntuacion;

    public fragment_elementos_heteronegialidad() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fragment_elementos_heteronegialidad, container, false);

        porcentaje1 = (CheckBox) view.findViewById(R.id.porcentaje1);
        porcentaje2 = (CheckBox) view.findViewById(R.id.porcentaje2);
        porcentaje3 = (CheckBox) view.findViewById(R.id.porcentaje3);
        porcentaje4 = (CheckBox) view.findViewById(R.id.porcentaje4);
        porcentaje5 = (CheckBox) view.findViewById(R.id.porcentaje5);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);
        porcentaje1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje1.isChecked()){
                    puntuacion.setText("4");
                    //porcentaje1.setChecked(false);
                    porcentaje2.setChecked(false);
                    porcentaje3.setChecked(false);
                    porcentaje4.setChecked(false);
                    guadra();
                }
            }
        });

        porcentaje2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje2.isChecked()){
                    puntuacion.setText("2");
                    porcentaje1.setChecked(false);
                    porcentaje5.setChecked(false);
                    porcentaje3.setChecked(false);
                    porcentaje4.setChecked(false);
                    guadra();
                }
            }
        });
        porcentaje3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje3.isChecked()){
                    puntuacion.setText("2");
                    porcentaje1.setChecked(false);
                    porcentaje2.setChecked(false);
                    porcentaje5.setChecked(false);
                    porcentaje4.setChecked(false);
                    guadra();
                }
            }
        });
        porcentaje4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje4.isChecked()){
                    puntuacion.setText("2");
                    porcentaje1.setChecked(false);
                    porcentaje2.setChecked(false);
                    porcentaje3.setChecked(false);
                    porcentaje5.setChecked(false);
                    guadra();
                }
            }
        });
        porcentaje4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje1.isChecked()){
                    puntuacion.setText("2");
                    porcentaje1.setChecked(false);
                    porcentaje2.setChecked(false);
                    porcentaje3.setChecked(false);
                    porcentaje5.setChecked(false);
                    guadra();
                }
            }
        });

        porcentaje5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje5.isChecked()){
                    puntuacion.setText("2");
                    porcentaje1.setChecked(false);
                    porcentaje2.setChecked(false);
                    porcentaje3.setChecked(false);
                    porcentaje4.setChecked(false);
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
        editor.putString("puntos_porcentaje_heterogenidad",puntosrapidos_sedimentos);
        editor.commit();

    }

}
