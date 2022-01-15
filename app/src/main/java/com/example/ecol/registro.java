package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import org.json.JSONException;
import org.json.JSONObject;

import maes.tech.intentanim.CustomIntent;

public class registro extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setTitle("Registro");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final EditText nombreT  =(EditText)findViewById(R.id.nombreRegistro);
        final EditText usuarioT =(EditText)findViewById(R.id.usuarioRegistro);
        final EditText claveT   =(EditText)findViewById(R.id.claveRegistro);
        final EditText edadT    =(EditText)findViewById(R.id.txtEdad);
        final EditText entidadT =(EditText)findViewById(R.id.entidadRegistro);
        final EditText emailT    =(EditText)findViewById(R.id.txtemail);
        Button btnRegistro = (Button)findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////////////////////// validaciones de campos vacios/////////////////////////////////////////
                String  nombre = nombreT.getText().toString();
                if(TextUtils.isEmpty(nombre)) {
                    nombreT.setError("Verifique tiene un Campo vacio"); return;
                }
                String usuario = usuarioT.getText().toString();
                if(TextUtils.isEmpty(usuario)) {
                    usuarioT.setError("Verifique tiene un Campo vacio"); return;
                }
                String clave = claveT.getText().toString();
                if(TextUtils.isEmpty(clave)) {
                    claveT.setError("Verifique tiene un Campo vacio"); return;
                }
                int edad = Integer.parseInt(edadT.getText().toString());

                String entidad = entidadT.getText().toString();
                if(TextUtils.isEmpty(entidad)) {
                    entidadT.setError("Verifique tiene un Campo vacio"); return;
                }
                String  email = emailT.getText().toString();
                if(TextUtils.isEmpty(email)) {
                    emailT.setError("Verifique tiene un Campo vacio"); return;
                }


                final Response.Listener<String> respuesta = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonRepuesta = new JSONObject(response);
                            boolean ok = jsonRepuesta.getBoolean("correcto");
                            if(ok==true){
                                Intent i =  new Intent(registro.this, login.class);
                                StyleableToast.makeText(getApplicationContext(),"Bienvenido: \nUsted se Registro Exitosamente",Toast.LENGTH_LONG,R.style.StyleableToast).show();
                                registro.this.startActivity(i);
                                registro.this.finish();
                            }
                        }catch (JSONException e) {
                            e.getMessage();
                        }
                    }
                };
                RegistroRequest  r = new RegistroRequest(nombre,usuario,clave,edad,entidad,email,respuesta);
                RequestQueue cola = Volley.newRequestQueue(registro.this);
                cola.add(r);
            }
        });
    }
        ////////////////////////////boton regresar evento onclick regresar a actividad principal ////////////////////////////////////
    public void onClick(View view) {
        Intent miIntent =new Intent(registro.this,login.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }

    @Override
    public void onBackPressed() {
        Intent miIntent =new Intent(registro.this,login.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }
}
