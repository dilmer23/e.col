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


public class fragment_estructura_cubierta extends Fragment {
    private CheckBox estructura1,estructura2,estructura4,estructura5,estructura6,estructura7,estructura8;
    private CheckBox estructura9,estructura10,estructura11;
    private TextView puntuacion;

    public fragment_estructura_cubierta() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fragment_estructura_cubierta, container, false);
        estructura1 = (CheckBox) view.findViewById(R.id.estructura1);
        estructura2 = (CheckBox) view.findViewById(R.id.estructura2);
        //estructura3 = (CheckBox) view.findViewById(R.id.estructura3);
        estructura4 = (CheckBox) view.findViewById(R.id.estructura4);
        estructura5 = (CheckBox) view.findViewById(R.id.estructura5);
        estructura6 = (CheckBox) view.findViewById(R.id.estructura6);
        estructura7 = (CheckBox) view.findViewById(R.id.estructura7);
        estructura8 = (CheckBox) view.findViewById(R.id.estructura8);
        estructura9 = (CheckBox) view.findViewById(R.id.estructura9);
        estructura10 = (CheckBox) view.findViewById(R.id.estructura10);
        estructura11 = (CheckBox) view.findViewById(R.id.estructura11);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        estructura1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                int resultado=0;
                if (estructura1.isChecked()){
                    puntuacion.setText("25");
                    resultado= valoracu+Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(resultado);
                    puntuacion.setText(res);
                    //estructura1.setChecked(false);
                    estructura2.setChecked(false);
                    estructura5.setChecked(false);
                    estructura4.setChecked(false);
                    estructura4.setEnabled(false);
                    guadra();
                }
            }
        });
        estructura2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =0;
                if (estructura2.isChecked()){
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    estructura1.setChecked(false);
                    estructura4.setEnabled(true);
                    guadra();
                }
            }
        });

        estructura4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura4.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    estructura1.setEnabled(false);
                    guadra();
                }
            }
        });
        estructura5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura5.isChecked()){
                    puntuacion.setText("0");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        estructura6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura6.isChecked()){
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        estructura7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura7.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        estructura8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura8.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        estructura9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura9.isChecked()){
                    puntuacion.setText("-5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        estructura10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura10.isChecked()){
                    puntuacion.setText("-5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        estructura11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (estructura10.isChecked()){
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
        String puntos_estructura_cubierta = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_estructura_cubierta",puntos_estructura_cubierta);
        editor.commit();
    }

}
