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
import android.widget.EditText;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;


public class fragment_rapidos_sedimentos extends Fragment {
    private CheckBox checkrapido1,checkrapido2,checkrapido3,checkrapido5,checkrapido6,checkrapido7;
     TextView puntuacion;

    public fragment_rapidos_sedimentos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_fragment_rapidos_sedimentos, container, false);
        checkrapido1 = (CheckBox) view.findViewById(R.id.checkrapido1);
        checkrapido2 = (CheckBox) view.findViewById(R.id.checkrapido2);
        checkrapido3 = (CheckBox) view.findViewById(R.id.checkrapido3);
        checkrapido5 = (CheckBox) view.findViewById(R.id.checkrapido5);
        checkrapido6 = (CheckBox) view.findViewById(R.id.checkrapido6);
        checkrapido7 = (CheckBox) view.findViewById(R.id.checkrapido7);
        puntuacion = (TextView) view.findViewById(R.id.txtresultadospuntos);

        checkrapido1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkrapido1.isChecked()){
                    puntuacion.setText("10");
                    checkrapido2.setChecked(false);
                    checkrapido3.setChecked(false);
                    checkrapido5.setChecked(false);
                    checkrapido6.setChecked(false);
                    checkrapido7.setChecked(false);
                    guadra();
                }
            }
        });
        checkrapido2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkrapido2.isChecked()){
                    puntuacion.setText("5");
                    checkrapido1.setChecked(false);
                    checkrapido3.setChecked(false);
                    checkrapido5.setChecked(false);
                    checkrapido6.setChecked(false);
                    checkrapido7.setChecked(false);
                    guadra();
                }
            }
        });

         checkrapido3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if (checkrapido3.isChecked()){
                     puntuacion.setText("0");
                     checkrapido1.setChecked(false);
                     checkrapido2.setChecked(false);
                     checkrapido5.setChecked(false);
                     checkrapido6.setChecked(false);
                     checkrapido7.setChecked(false);
                     guadra();
                 }
             }
         });
        checkrapido5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkrapido5.isChecked()){
                    puntuacion.setText("10");
                    checkrapido1.setChecked(false);
                    checkrapido2.setChecked(false);
                    checkrapido3.setChecked(false);
                    checkrapido6.setChecked(false);
                    checkrapido7.setChecked(false);
                    guadra();
                }
            }
        });
        checkrapido6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkrapido6.isChecked()){
                    puntuacion.setText("5");
                    checkrapido1.setChecked(false);
                    checkrapido2.setChecked(false);
                    checkrapido3.setChecked(false);
                    checkrapido5.setChecked(false);
                    checkrapido7.setChecked(false);
                    guadra();
                }
            }
        });
        checkrapido7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkrapido7.isChecked()){
                    puntuacion.setText("0");
                    checkrapido1.setChecked(false);
                    checkrapido2.setChecked(false);
                    checkrapido3.setChecked(false);
                    checkrapido5.setChecked(false);
                    checkrapido6.setChecked(false);
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
        editor.putString("puntos_rapidos_sedimentos",puntosrapidos_sedimentos);
        editor.commit();
    }

}
