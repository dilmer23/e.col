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


public class fragment_grado_naturalidad extends Fragment {
    private CheckBox naturalidad1,naturalidad2,naturalidad3,naturalidad4,naturalidad5,naturalidad6,naturalidad7,naturalidad8;
    private TextView puntuacion;

    public fragment_grado_naturalidad() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_grado_naturalidad, container, false);
        naturalidad1 = (CheckBox) view.findViewById(R.id.naturalida1);
        naturalidad2 = (CheckBox) view.findViewById(R.id.naturalida2);
        naturalidad3 = (CheckBox) view.findViewById(R.id.naturalida3);
        naturalidad4 = (CheckBox) view.findViewById(R.id.naturalida4);
        naturalidad5 = (CheckBox) view.findViewById(R.id.naturalida5);
        naturalidad6 = (CheckBox) view.findViewById(R.id.naturalida6);
        naturalidad7 = (CheckBox) view.findViewById(R.id.naturalida7);
        naturalidad8 = (CheckBox) view.findViewById(R.id.naturalida8);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        naturalidad1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                int resultado=0;
                if (naturalidad1.isChecked()){
                    puntuacion.setText("25");
                    resultado= valoracu+Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(resultado);
                    puntuacion.setText(res);
                    naturalidad2.setChecked(false);
                    naturalidad3.setChecked(false);
                    naturalidad4.setChecked(false);
                    naturalidad5.setChecked(false);
                    naturalidad6.setChecked(false);
                    naturalidad7.setChecked(false);
                    naturalidad8.setChecked(false);
                    naturalidad3.setEnabled(false);
                    guadra();
                }
            }
        });
        naturalidad2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                if (naturalidad2.isChecked()){
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    naturalidad1.setChecked(false);
                    naturalidad3.setEnabled(true);
                    guadra();
                }
            }
        });
        naturalidad3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (naturalidad3.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    naturalidad1.setEnabled(false);
                    guadra();
                }
            }
        });
        naturalidad4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (naturalidad4.isChecked()){
                    puntuacion.setText("0");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);

                    guadra();
                }
            }
        });
        naturalidad5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (naturalidad5.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        naturalidad6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (naturalidad6.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        naturalidad7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (naturalidad7.isChecked()){
                    puntuacion.setText("-5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        naturalidad8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (naturalidad8.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });

        return view;
    }

    private void guadra() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String puntos_grado_naturalidad = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_grado_naturalidad",puntos_grado_naturalidad);
        editor.commit();

    }

}
