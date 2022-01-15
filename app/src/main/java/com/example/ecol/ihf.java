package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import me.relex.circleindicator.CircleIndicator;

public class ihf extends AppCompatActivity {

    ViewPager viewpeger2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componntebiologico);
        getSupportActionBar().setTitle("\nEvaluación IHF");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.cascada);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlueJeans)));
        setContentView(R.layout.activity_ihf);

        //////////////////////////color statucbar ///////////////////////////////////////////////////////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#509CEC")); //Define color blanco.
        }


        viewpeger2 = findViewById(R.id.viewpeger2);
        introadapterihf adapter =new introadapterihf(getSupportFragmentManager());
        viewpeger2.setAdapter(adapter);

/////////////////////////////libreria para dots indicator android////////////////////////////////////////////////////
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicador);
        indicator.setViewPager(viewpeger2);
    }
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder mysalir = new AlertDialog.Builder(this);
        mysalir.setMessage("Deseas salir asegurate de haber guardado tus datos");
        mysalir.setTitle("Atención");
        mysalir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent miIntent =new Intent(ihf.this,dashboardprin.class);
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
