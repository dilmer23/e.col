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
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import maes.tech.intentanim.CustomIntent;

public class clima extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button enviar;
    CardView card1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima);

        r1 =(RadioButton)findViewById(R.id.dia_soleado);
        r2 =(RadioButton)findViewById(R.id.dia_nublado);
        r3 =(RadioButton)findViewById(R.id.dia_llovizna);
        r4 =(RadioButton)findViewById(R.id.dia_lluviafuerte);

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r1.isChecked()){
                    String cadena="dia_soleado";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherclima=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("clima",sherclima);
                    editor.commit();
                    Intent c1 = new Intent(clima.this, dasboarmenu.class);
                    startActivity(c1);
                    StyleableToast.makeText(getApplicationContext(),cadena,Toast.LENGTH_LONG,R.style.StyleableToast).show();

                }
            }
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r2.isChecked()){
                    String cadena="dia_nublado";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherclima=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("clima",sherclima);
                    editor.commit();
                    Intent c1 = new Intent(clima.this, dasboarmenu.class);
                    startActivity(c1);
                    StyleableToast.makeText(getApplicationContext(),cadena,Toast.LENGTH_LONG,R.style.StyleableToast).show();

                }
            }
        });
        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r3.isChecked()){
                    String cadena="dia_llovizna";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherclima=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("clima",sherclima);
                    editor.commit();
                    Intent c1 = new Intent(clima.this, dasboarmenu.class);
                    startActivity(c1);
                    StyleableToast.makeText(getApplicationContext(),cadena,Toast.LENGTH_LONG,R.style.StyleableToast).show();

                }
            }
        });
        r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (r4.isChecked()){
                    String cadena="dia_lluvia_fuerte";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    String sherclima=cadena;
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("clima",sherclima);
                    editor.commit();
                    Intent c1 = new Intent(clima.this, dasboarmenu.class);
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
