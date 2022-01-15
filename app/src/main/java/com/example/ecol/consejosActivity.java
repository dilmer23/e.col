package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Switch;

import maes.tech.intentanim.CustomIntent;

public class consejosActivity extends AppCompatActivity  {

    Fragment consejosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nConsejos Basicos");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.consejos);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_consejos);

        consejosFragment=new consejosFragment();

    }
    //boton regresar a actividad bienvenido
    public void regresar(View view) {
        Intent miIntent =new Intent(consejosActivity.this,bienvenido.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }

    //boton siguinete a actividad ubicacion
    public void siguienteubicacion(View view) {
        Intent miIntent =new Intent(consejosActivity.this,ubicacion.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }



    public void tipodeestudios(View view) {
        Intent miIntent =new Intent(consejosActivity.this,tipo_de_estudios.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();

    }

    @Override
    public void onBackPressed() {
        Intent miIntent =new Intent(consejosActivity.this,bienvenido.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();

    }

    public void protocolocampo(View view) {
        Intent miIntent =new Intent(consejosActivity.this,protocolo_de_campo.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }

    public void equipo_herramientas(View view) {
        FragmentTransaction Transaction=getSupportFragmentManager().beginTransaction();
        Transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Transaction.replace(R.id.contendortipoestudios,consejosFragment);
        Transaction.commit();

    }
}
