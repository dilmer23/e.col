package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import maes.tech.intentanim.CustomIntent;

public class otrosdatos extends AppCompatActivity {
    EditText ph,temaambiente,temagua,conductibildad,oxigeno,caudal;
    CheckBox agricultura,pastoreo,recreativo,ninguno;
    Button comezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otrosdatos);
        comezar =(Button) findViewById(R.id.comezar);
        /* esto son los checkbok y es donde se obtiene los datos */
        agricultura =(CheckBox) findViewById(R.id.agricultura);
        pastoreo =(CheckBox) findViewById(R.id.pastoreo);
        recreativo =(CheckBox) findViewById(R.id.recreativo);
        ninguno =(CheckBox) findViewById(R.id.ninguno);



        agricultura.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (agricultura.isChecked()){
                    pastoreo.setChecked(false);
                    recreativo.setChecked(false);
                    ninguno.setChecked(false);
                    String cadena= "agricultura";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("actividad_rio",cadena);
                    editor.commit();
                }
            }
        });
        pastoreo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (pastoreo.isChecked()){
                    agricultura.setChecked(false);
                    recreativo.setChecked(false);
                    ninguno.setChecked(false);
                    String cadena= "agricultura";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("actividad_rio",cadena);
                    editor.commit();
                }
            }
        });
        recreativo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (recreativo.isChecked()){
                    pastoreo.setChecked(false);
                    recreativo.setChecked(false);
                    ninguno.setChecked(false);
                    String cadena= "actividades recreativas";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("actividad_rio",cadena);
                    editor.commit();
                }
            }
        });
        ninguno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (ninguno.isChecked()){
                    pastoreo.setChecked(false);
                    recreativo.setChecked(false);
                    agricultura.setChecked(false);
                    String cadena= "ninguna actividad";
                    SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("actividad_rio",cadena);
                    editor.commit();
                }
            }
        });


        comezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent =new Intent(otrosdatos.this,dashboardprin.class);
                startActivity(miIntent);
                //CustomIntent.customType(getApplication(),"fadein-to-fadeout");
                finish();
            }
        });

    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder mysalir = new AlertDialog.Builder(this);
        mysalir.setMessage("verifica antes de salir");
        mysalir.setTitle("Alerta");
        mysalir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent miIntent =new Intent(otrosdatos.this,dashboardprin.class);
                startActivity(miIntent);
                finish();
            }
        });
        mysalir.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialogInterface = mysalir.create();
        dialogInterface.show();
    }
}
