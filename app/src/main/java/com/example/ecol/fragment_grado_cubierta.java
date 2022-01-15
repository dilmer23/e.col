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


public class fragment_grado_cubierta extends Fragment {
    private CheckBox grado1,grado2,grado3,grado4,grado5,grado6,grado7,grado8;
    private TextView puntuacion;

    public fragment_grado_cubierta() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fragment_grado_cubierta, container, false);
        grado1 = (CheckBox) view.findViewById(R.id.grado1);
        grado2 = (CheckBox) view.findViewById(R.id.grado2);
        grado3 = (CheckBox) view.findViewById(R.id.grado3);
        grado4 = (CheckBox) view.findViewById(R.id.grado4);
        grado5 = (CheckBox) view.findViewById(R.id.grado5);
        grado6 = (CheckBox) view.findViewById(R.id.grado6);
        grado7 = (CheckBox) view.findViewById(R.id.grado7);
        grado8 = (CheckBox) view.findViewById(R.id.grado8);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        grado1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                int resultado=0;
                if (grado1.isChecked()){
                    puntuacion.setText("25");
                    resultado= valoracu+Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(resultado);
                    puntuacion.setText(res);
                    grado2.setChecked(false);
                    grado3.setChecked(false);
                    grado4.setChecked(false);
                    grado5.setChecked(false);
                    grado6.setChecked(false);
                    grado7.setChecked(false);
                    grado8.setChecked(false);
                    grado3.setEnabled(false);
                    guadra();
                }
            }
        });
        grado2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                if (grado2.isChecked()){
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    grado1.setChecked(false);
                    grado3.setEnabled(true);
                    guadra();
                }
            }
        });
        grado3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (grado3.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    grado1.setEnabled(false);
                    guadra();
                }
            }
        });
        grado4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (grado4.isChecked()){
                    puntuacion.setText("0");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);

                    guadra();
                }
            }
        });
        grado5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (grado5.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        grado6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (grado6.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        grado7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (grado7.isChecked()){
                    puntuacion.setText("-5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        grado8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (grado8.isChecked()){
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
        String puntos_grado_cubierta = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_grado_cubierta",puntos_grado_cubierta);
        editor.commit();

    }

}