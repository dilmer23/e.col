package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import maes.tech.intentanim.CustomIntent;

public class regimen_hidrologico extends AppCompatActivity {
    RadioButton r1,r2,r3;
    Button enviar;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regimen_hidrologico);

        r1 =(RadioButton)findViewById(R.id.unimodal);
        r2 =(RadioButton)findViewById(R.id.bimodal);
        r3 =(RadioButton)findViewById(R.id.bimodal_unimodal);

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r1.isChecked()){
                    String cadena="ecositema unimodal";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherregimen=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("regimen",sherregimen);
                    editor.commit();
                    Intent c1 = new Intent(regimen_hidrologico.this, dasboarmenu.class);
                    startActivity(c1);
                    StyleableToast.makeText(getApplicationContext(),cadena,Toast.LENGTH_LONG,R.style.StyleableToast).show();

                }
            }
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r2.isChecked()){
                    String cadena="ecositema bimodal";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherregimen=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("regimen",sherregimen);
                    editor.commit();
                    Intent c1 = new Intent(regimen_hidrologico.this, dasboarmenu.class);
                    startActivity(c1);
                    StyleableToast.makeText(getApplicationContext(),cadena,Toast.LENGTH_LONG,R.style.StyleableToast).show();

                }
            }
        });
        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r3.isChecked()){
                    String cadena="ecositema unimodal y bimodal";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherregimen=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("regimen",sherregimen);
                    editor.commit();
                    Intent c1 = new Intent(regimen_hidrologico.this, dasboarmenu.class);
                    startActivity(c1);
                    StyleableToast.makeText(getApplicationContext(),cadena,Toast.LENGTH_LONG,R.style.StyleableToast).show();

                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        StyleableToast.makeText(getApplicationContext(),"usted no ha selecionado por favor Selecione",Toast.LENGTH_LONG,R.style.StyleableToast).show();
    }

}
