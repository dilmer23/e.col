package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import maes.tech.intentanim.CustomIntent;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class dashboard extends AppCompatActivity{
        EditText dirrecion,longitud,lat,txtlugar,txtciudad,txtprofesional,fecha,altura;
        EditText nombreecocistema,departamento,puntomuestreo,otroecosistema,codigomues;
        Button btnDesbohar;
        CheckBox rio,quebrada,canio;
        DatePickerDialog picker;
        ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setTitle("\nDatos Basicos");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icono_datos_basicos);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        rio =(CheckBox)findViewById(R.id.rio);
        quebrada =(CheckBox) findViewById(R.id.quebrada);
        canio =(CheckBox) findViewById(R.id.canios);
        dirrecion=(EditText) findViewById(R.id.dirrecion);
        longitud=(EditText) findViewById(R.id.longitud);
        lat=(EditText) findViewById(R.id.lat);
        altura=(EditText) findViewById(R.id.altura);
        codigomues=(EditText) findViewById(R.id.codigodemuestra);
        //////////////////////////////////////////variables gurdado datos basicos/////////////////////////////////////////////////////////////////
        nombreecocistema=(EditText) findViewById(R.id.txtnombreecocistema);
        departamento=(EditText) findViewById(R.id.txtdepartamento);
        puntomuestreo=(EditText) findViewById(R.id.txtpuntomuestreo);
        txtciudad=(EditText) findViewById(R.id.txtciudad);
        txtprofesional=(EditText) findViewById(R.id.txtprofesional);
        txtlugar=(EditText) findViewById(R.id.txtlugar);
        dirrecion=(EditText) findViewById(R.id.dirrecion);
        otroecosistema=(EditText) findViewById(R.id.ecosistemaotro);
        longitud=(EditText) findViewById(R.id.longitud);
        lat=(EditText) findViewById(R.id.lat);
        fecha=(EditText) findViewById(R.id.txtfecha);
        btnDesbohar=(Button) findViewById(R.id.btnDesbohar);


        rio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rio.isChecked()){
                    String ecositema = rio.getText().toString();
                    SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("ecositemaevaluado",ecositema);
                    editor.commit();
                    canio.setChecked(false);
                    quebrada.setChecked(false);
                }
            }
        });
        quebrada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (quebrada.isChecked()){
                    String ecositema = quebrada.getText().toString();
                    SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("ecositemaevaluado",ecositema);
                    editor.commit();
                    canio.setChecked(false);
                    rio.setChecked(false);
                }
            }
        });
        canio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (canio.isChecked()){
                    String ecositema = canio.getText().toString();
                    SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= preferences.edit();
                    editor.putString("ecositemaevaluado",ecositema);
                    editor.commit();
                    rio.setChecked(false);
                    quebrada.setChecked(false);
                }
            }
        });
        cargardatos();

        //titulodatos=(TextView) findViewById(R.id.titulodatos);
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
          //  titulodatos.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        //}
        ////////////////////////////////////data piker/////////////////////////////////////////////////////////////////////////////////////////
        fecha=(EditText) findViewById(R.id.txtfecha);
        fecha.setInputType(InputType.TYPE_NULL);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                //int hour = cldr.get(Calendar.HOUR_OF_DAY);
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(dashboard.this,new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view ,int year, int monthOfYear, int dayOfMonth) {
                                fecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        ////////////////////////////////Recibe los de ubicacion datos en la actividad/////////////////////////////////////////////////////////////
        Bundle mibuble=this.getIntent().getExtras();

            String direccion = mibuble.getString("dr");
            dirrecion.setText("" +direccion);
            String lon = mibuble.getString("longitud");
            longitud.setText("" +lon);
            String latitud = mibuble.getString("lactitud");
            lat.setText("" +latitud);
            String altur = mibuble.getString("altura");
            altura.setText("" +altur);


        ////////////////////////////////////// ejecutar funcion del web servic para relizar insercion/////////////////////////////////////////////
        btnDesbohar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardardatos();
            }
        });

    }

    private void guardardatos() {
        Intent miinten =new Intent(dashboard.this,dasboarmenu.class);
        SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        String dirrec = dirrecion.getText().toString();
        String longi = longitud.getText().toString();
        String lati = lat.getText().toString();
        String altu = altura.getText().toString();
        String lug = txtlugar.getText().toString();
        if(TextUtils.isEmpty(lati)) {
            lat.setError("Verifique tiene un Campo vacio"); return; }
        String fech = fecha.getText().toString();
        String ciud = txtciudad.getText().toString();
        if(TextUtils.isEmpty(ciud)) {
            txtciudad.setError("Verifique tiene un Campo vacio"); return; }
        String depart = departamento.getText().toString();
        //String nombreeco = nombreecocistema.getText().toString();
        String profesiona = txtprofesional.getText().toString();
        if(TextUtils.isEmpty(profesiona)) {
            txtprofesional.setError("Verifique tiene un Campo vacio"); return; }
        String puntoec = puntomuestreo.getText().toString();
        String codigomue =codigomues.getText().toString();
        if(TextUtils.isEmpty(codigomue)) {
            codigomues.setError("Verifique tiene un Campo vacio"); return; }
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("dirrecion",dirrec);
        editor.putString("logitud",longi);
        editor.putString("latitud",lati);
        editor.putString("altura",altu);
        editor.putString("lugar",lug);
        editor.putString("fecha",fech);
        editor.putString("ciudad",ciud);
        editor.putString("departamento",depart);
        //editor.putString("nombreecosistema",nombreeco);
        editor.putString("nombrepresional",profesiona);
        editor.putString("puntoecosistema",puntoec);
        editor.putString("codigomuestra",codigomue);
        editor.commit();
        progressDialog = new ProgressDialog(dashboard.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("ProgressDialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        startActivity(miinten);
    }

    private void cargardatos() {
        SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        String muestreopunto =preferences.getString("nombrepuntos","");
        String ecositema =preferences.getString("ecositema","");
        String departamentore =preferences.getString("departamento","");
        //nombreecocistema.setText(ecositema);
        departamento.setText(departamentore);
        puntomuestreo.setText(muestreopunto);
        nombreecocistema.setText(ecositema);
        departamento.setEnabled(false);
        puntomuestreo.setEnabled(false);
        nombreecocistema.setEnabled(false);
    }

}
