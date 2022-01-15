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
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;


public class fragment_cobertura_vegetacion_acuatica extends Fragment {

    private CheckBox porcentaje1,porcentaje2,porcentaje3,porcentaje4,porcentaje5,porcentaje6;
    private TextView puntuacion;
    public fragment_cobertura_vegetacion_acuatica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fragment_cobertura_vegetacion_acuatica, container, false);
        porcentaje1 = (CheckBox) view.findViewById(R.id.porcentaje1);
        porcentaje2 = (CheckBox) view.findViewById(R.id.porcentaje2);
        porcentaje3 = (CheckBox) view.findViewById(R.id.porcentaje3);
        porcentaje4 = (CheckBox) view.findViewById(R.id.porcentaje4);
        porcentaje5 = (CheckBox) view.findViewById(R.id.porcentaje5);
        porcentaje6 = (CheckBox) view.findViewById(R.id.porcentaje6);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        porcentaje1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje1.isChecked()){
                    int valoracu =Integer.parseInt(puntuacion.getText().toString());
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });

        porcentaje2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje2.isChecked()){
                    int valoracu =Integer.parseInt(puntuacion.getText().toString());
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        porcentaje3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje3.isChecked()){
                    int valoracu =Integer.parseInt(puntuacion.getText().toString());
                    puntuacion.setText("10");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        porcentaje4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje4.isChecked()){
                    int valoracu =Integer.parseInt(puntuacion.getText().toString());
                    puntuacion.setText("5");
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        porcentaje5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje5.isChecked()){
                    int valoracu =Integer.parseInt(puntuacion.getText().toString());
                    puntuacion.setText("10");
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        porcentaje6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (porcentaje6.isChecked()){
                    int valoracu =Integer.parseInt(puntuacion.getText().toString());
                    puntuacion.setText("5");
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });

        int valoracu =Integer.parseInt(puntuacion.getText().toString());
        if (valoracu>30){
            StyleableToast.makeText(getActivity(),"Valor maximo 20", Toast.LENGTH_LONG,R.style.StyleableToast).show();
        }

        return view;
    }

    private void guadra() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String puntosrapidos_sedimentos = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_cobertura_vegetacion",puntosrapidos_sedimentos);
        editor.commit();

    }

}
