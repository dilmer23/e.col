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


public class fragment_Calidad_cubierta extends Fragment {
    private CheckBox calidad1,calidad2,calidad3,calidad4,calidad5,calidad6,calidad7,calidad8;
    private TextView puntuacion;

    public fragment_Calidad_cubierta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fragment__calidad_cubierta, container, false);

        calidad1 = (CheckBox) view.findViewById(R.id.calidad1);
        calidad2 = (CheckBox) view.findViewById(R.id.calidad2);
        calidad3 = (CheckBox) view.findViewById(R.id.calidad3);
        calidad4 = (CheckBox) view.findViewById(R.id.calidad4);
        calidad5 = (CheckBox) view.findViewById(R.id.calidad5);
        calidad6 = (CheckBox) view.findViewById(R.id.calidad6);
        calidad7 = (CheckBox) view.findViewById(R.id.calidad7);
        calidad8 = (CheckBox) view.findViewById(R.id.calidad8);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        calidad1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                int resultado=0;
                if (calidad1.isChecked()){
                    puntuacion.setText("25");
                    resultado= valoracu+Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(resultado);
                    puntuacion.setText(res);
                    calidad2.setChecked(false);
                    calidad3.setChecked(false);
                    calidad4.setChecked(false);
                    calidad5.setChecked(false);
                    calidad6.setChecked(false);
                    calidad7.setChecked(false);
                    calidad8.setChecked(false);
                    calidad3.setEnabled(false);
                    guadra();
                }
            }
        });
        calidad2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                if (calidad2.isChecked()){
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    calidad1.setChecked(false);
                    calidad3.setEnabled(true);
                    guadra();
                }
            }
        });
        calidad3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (calidad3.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    calidad1.setEnabled(false);
                    guadra();
                }
            }
        });
        calidad4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (calidad4.isChecked()){
                    puntuacion.setText("0");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);

                    guadra();
                }
            }
        });
        calidad5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (calidad5.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        calidad6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (calidad6.isChecked()){
                    puntuacion.setText("-10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        calidad7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (calidad7.isChecked()){
                    puntuacion.setText("-5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        calidad8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (calidad8.isChecked()){
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
        String puntos_calidad_cubierta = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_calidad_cubierta",puntos_calidad_cubierta);
        editor.commit();

    }

}