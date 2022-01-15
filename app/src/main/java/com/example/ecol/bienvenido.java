package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import maes.tech.intentanim.CustomIntent;
public class bienvenido extends AppCompatActivity {
    Spinner combodepartamentos;
    EditText nombrecositema,puntomuestreo;
    Button comezar;
    Fragment userdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nNueva Evaluación");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icono_nuevo_registro);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_bienvenido);

        nombrecositema =(EditText) findViewById(R.id.nombreecosistema);
        puntomuestreo = (EditText)findViewById(R.id.puntomuestreo);
        userdatos = new userdatos();
        comezar=(Button)findViewById(R.id.comezar);
        //comezar.setOnClickListener(this);


        combodepartamentos=(Spinner)findViewById(R.id.iddepartamento);
        ArrayAdapter<CharSequence> adarter=ArrayAdapter.createFromResource(this,
                R.array.departamentos,android.R.layout.simple_spinner_item);
        combodepartamentos.setAdapter(adarter);

        //String departamento = combodepartamentos.getSelectedItem().toString();

        SharedPreferences preferences= getSharedPreferences("datossecion", Context.MODE_PRIVATE);
        String nameuser =preferences.getString("nombreusuario","");
        final TextView mensaje = (TextView)findViewById(R.id.mensaje);
        Intent i = this.getIntent();
        String nombre = i.getStringExtra("nombre");
        //int edad = i.getIntExtra("edad",-1);
        mensaje.setText(mensaje.getText()+" "+nameuser+"");


        comezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miinten =new Intent(bienvenido.this,consejosActivity.class);
                SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
                String departamento =(String) combodepartamentos.getSelectedItem();
                String ecositema = nombrecositema.getText().toString();
                if(TextUtils.isEmpty(ecositema)) {
                    nombrecositema.setError("Verifique tiene un Campo vacio"); return;
                }
                String muestreopunto = puntomuestreo.getText().toString();
                if(TextUtils.isEmpty(muestreopunto)) {
                    puntomuestreo.setError("Verifique tiene un Campo vacio"); return;
                }
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("departamento",departamento);
                editor.putString("ecositema",ecositema);
                editor.putString("nombrepuntos",muestreopunto);
                editor.commit();
                startActivity(miinten);
            }
        });
    }
    //alert dialog para salir de la desboar bienvenido
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder mysalir = new AlertDialog.Builder(this);
        mysalir.setMessage("Seguro que Deseas salir");
        mysalir.setTitle("Alerta");
        mysalir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent miIntent =new Intent(bienvenido.this,login.class);
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
////////////////////////////menu ////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pricipal, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.btninfo:
                salir();
                return true;
            case R.id.btnusuario:
                mostrainfouser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
///////////////////////////////////////////////////////////////////////////////////////
    private void mostrainfouser() {
        Intent miIntent =new Intent(bienvenido.this,informacion_usuario.class);
        startActivity(miIntent);
        finish();
    }

    private void salir() {
        AlertDialog.Builder builder = new AlertDialog.Builder(bienvenido.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_info_ecol,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        ImageView cerrar = view.findViewById(R.id.cerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    public void consultarresultados(View view) {
        Intent miinten =new Intent(bienvenido.this,dashboardprin.class);
        startActivity(miinten);

    }
}
