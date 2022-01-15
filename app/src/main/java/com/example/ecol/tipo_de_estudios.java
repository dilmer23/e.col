package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class tipo_de_estudios extends AppCompatActivity {

    Fragment cualitativos,cuantitativo,semicuantitativo,sustratoartificial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_estudios);
        getSupportActionBar().setTitle("\nTipos De Estudio");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_research);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        cualitativos=new cualitativos();
        cuantitativo = new cuantitativo();
        semicuantitativo= new semicuantitativo();
        sustratoartificial = new sustratoartificial();

    }


    @Override
    public void onBackPressed() {
        Intent miIntent =new Intent(tipo_de_estudios.this,consejosActivity.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }

    public void regresarconsejos(View view) {
        Intent miIntent =new Intent(tipo_de_estudios.this,consejosActivity.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }

    public void estudiocualitativo(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendortipoestudios,cualitativos);
        Transaction.commit();
    }

    public void cuantitativo(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendortipoestudios,cuantitativo);
        Transaction.commit();
    }

    public void semicuentitativo(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendortipoestudios,semicuantitativo);
        Transaction.commit();
    }

    public void sustratoartificial(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendortipoestudios,sustratoartificial);
        Transaction.commit();
    }
}
