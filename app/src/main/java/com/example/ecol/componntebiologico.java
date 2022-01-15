package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import me.relex.circleindicator.CircleIndicator;

public class componntebiologico extends AppCompatActivity {
    ViewPager viewPager;
    Button btnsiguienteecologia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componntebiologico);
        getSupportActionBar().setTitle("\nTest Biologico");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_lombriz);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorGrass)));
       // btnsiguienteecologia = findViewById(R.id.btnbiologiasigi);
        /////////////ocular button programaticamente///////////////////////////
       // btnsiguienteecologia.setVisibility(View.GONE);
//////////////////////////color statucbar ///////////////////////////////////////////////////////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#A0D468")); //Define color blanco.
        }

        viewPager = findViewById(R.id.viewpeger);
        intoadapter adapter =new intoadapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

/////////////////////////////libreria para dots indicator android////////////////////////////////////////////////////
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicador);
        indicator.setViewPager(viewPager);






    }
}
