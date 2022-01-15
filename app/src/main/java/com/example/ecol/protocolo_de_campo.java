package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class protocolo_de_campo extends AppCompatActivity {

    Fragment registro_variables,selecion_tramo,identificacion_marcos,toma_muestras,embalaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocolo_de_campo);
        getSupportActionBar().setTitle("\nProtocolo De campo");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icono_protocoloc);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        registro_variables = new registro_variables();
        selecion_tramo = new selecion_tramo_estudio();
        identificacion_marcos = new identificacion_macros();
        toma_muestras =new toma_muestras();
        embalaje = new embalague_muestras();

    }


    public void regresarconsejostramo(View view) {
        Intent miIntent =new Intent(protocolo_de_campo.this,consejosActivity.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent miIntent =new Intent(protocolo_de_campo.this,consejosActivity.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }

    public void selecion_tramo(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendorprotocolocampo,selecion_tramo);
        Transaction.commit();
    }
    public void Regitro_Variables(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendorprotocolocampo,registro_variables);
        Transaction.commit();
    }

    public void identificacion_macros(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendorprotocolocampo,identificacion_marcos);
        Transaction.commit();
    }

    public void toma_de_muestras(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendorprotocolocampo,toma_muestras);
        Transaction.commit();
    }

    public void embalaje(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendorprotocolocampo,embalaje);
        Transaction.commit();
    }
}
