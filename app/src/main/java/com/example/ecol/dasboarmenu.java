package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.HashMap;
import java.util.Map;

import maes.tech.intentanim.CustomIntent;

public class dasboarmenu extends AppCompatActivity implements View.OnClickListener {


    //////////////////////////////////inicializando variables privadas///////////////////////////////////////////////////////////////
    CardView regimenhidrologico,clima,hidrologia,turbidezc;
    Button btnSiguiente;
    EditText datoclima,tubidezdato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nClima Y Hidrologia");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.iconoclima);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlueJeans)));
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_dasboarmenu);


        ////////////////////////////////////////////////carViwe variables/////////////////////////////////////////////////////////////////
        hidrologia =(CardView)findViewById(R.id.hidrologia);
        clima =(CardView)findViewById(R.id.clima);
        regimenhidrologico =(CardView)findViewById(R.id.regimenhidrologico);
        turbidezc =(CardView)findViewById(R.id.turbidez);
        btnSiguiente =(Button) findViewById(R.id.btnSiguiente);
        //////////////////////Metodos/////////////////////////////////////////////////////////////////////////////////////////////////
        clima.setOnClickListener(this);
        hidrologia.setOnClickListener(this);
        regimenhidrologico.setOnClickListener(this);
        turbidezc.setOnClickListener(this);

        //SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        //String clima =preferences.getString("clima",null);
        //String logitu =preferences.getString("hidrologia",null);
        //String latitu =preferences.getString("turbidez",null);
        //String regimen =preferences.getString("regimen",null);

        //if ( (clima == null) || (clima.isEmpty())) {
          // btnSiguiente.setVisibility(View.INVISIBLE);
        //}
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onClick(View v) {
        Intent i ;
        switch (v.getId()){
            case R.id.clima : i = new Intent(this,clima.class);
                CardView clima  = (CardView) findViewById(R.id.clima);
                clima.setBackgroundColor(Color.YELLOW);
                startActivity(i);
                break;
            case R.id.hidrologia : i = new Intent(this,hidrologia.class);
                CardView hidrologia  = (CardView) findViewById(R.id.hidrologia);
                hidrologia.setBackgroundColor(Color.YELLOW);
            startActivity(i);
            break;
            case R.id.turbidez : i = new Intent(this,turbidez.class);
                CardView turbidez  = (CardView) findViewById(R.id.turbidez);
                turbidez.setBackgroundColor(Color.YELLOW);
            startActivity(i);
            break;
           case R.id.regimenhidrologico : i = new Intent(this,regimen_hidrologico.class);
                CardView regimen  = (CardView) findViewById(R.id.regimenhidrologico);
                regimen.setBackgroundColor(Color.YELLOW);
                startActivity(i);break;
            default:break;
        }

    }

    public void siguientedas(View view) {
        Intent intent = new Intent(this, dashboardprin.class);
        //btnSiguiente.setBackgroundColor(Color.parseColor("#FF8411"));
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");

    }
//    @Override
//    public void onBackPressed() {
//        Intent miIntent =new Intent(dasboarmenu.this,consejosActivity.class);
//        startActivity(miIntent);
//        finish();
//    }
}
