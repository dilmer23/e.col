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


public class fragment_composicion_sustrato extends Fragment {
    private CheckBox opcion1,opcion2,opcion3,opcion4,opcion5,opcion6,opcion7,opcion8;
    TextView puntuacion;

    public fragment_composicion_sustrato() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_composicion_sustrato, container, false);
        opcion1 = (CheckBox) view.findViewById(R.id.opcion1);
        opcion2 = (CheckBox) view.findViewById(R.id.opcion2);
        opcion3 = (CheckBox) view.findViewById(R.id.opcion3);
        opcion4 = (CheckBox) view.findViewById(R.id.opcion4);
        opcion5 = (CheckBox) view.findViewById(R.id.opcion5);
        opcion6 = (CheckBox) view.findViewById(R.id.opcion6);
        opcion7 = (CheckBox) view.findViewById(R.id.opcion7);
        opcion8 = (CheckBox) view.findViewById(R.id.opcion8);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        opcion1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion1.isChecked()){
                    puntuacion.setText("2");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);

                    guadra();
                }
            }
        });

        opcion2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion2.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        opcion3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion3.isChecked()){
                    puntuacion.setText("2");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        opcion4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion4.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);

                    guadra();
                }
            }
        });
        opcion5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion5.isChecked()){
                    puntuacion.setText("2");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        opcion6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion6.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        opcion7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion7.isChecked()){
                    puntuacion.setText("2");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        opcion8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (opcion8.isChecked()){
                    puntuacion.setText("5");
                    valoracu+=Integer.parseInt(puntuacion.getText().toString());
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                    guadra();
                }
            }
        });
        int valoracu =Integer.parseInt(puntuacion.getText().toString());

        if (valoracu>20){
            StyleableToast.makeText(getActivity(),"Valor maximo 20",Toast.LENGTH_LONG,R.style.StyleableToast).show();
        }


        return view;
    }

    private void guadra() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String puntosrapidos_sedimentos = puntuacion.getText().toString();
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("puntos_composicion_sustrato",puntosrapidos_sedimentos);
        editor.commit();

    }

}
