package com.example.ecol;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import org.json.JSONException;
import org.json.JSONObject;

import maes.tech.intentanim.CustomIntent;

public class login extends AppCompatActivity {
//private SharedPreferences preferences;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nEcol");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.login);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        validarsecion();


        TextView registro =(TextView)findViewById(R.id.registroLogin);
        TextView recuperacion_contra =(TextView)findViewById(R.id.txtrecuperacionpasw);
        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        final EditText usuarioT = (EditText)findViewById(R.id.usuarioLogin);
        final EditText claveT = (EditText)findViewById(R.id.claveLogin);

        recuperacion_contra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://ecol.atwebpages.com/login.php");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registro = new Intent(login.this,registro.class);
                login.this.startActivity(registro);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                final String usuarios = usuarioT.getText().toString();
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("usuario",usuarios);
                editor.commit();
            final String usuario = usuarioT.getText().toString();
                if(TextUtils.isEmpty(usuario)) {
                    usuarioT.setError("Verifique tiene un Campo vacio"); return;
                }
            final String clave = claveT.getText().toString();
                if(TextUtils.isEmpty(clave)) {
                    claveT.setError("Verifique tiene un Campo vacio"); return;
                }
                Response.Listener<String> respuesta  = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            progressDialog = new ProgressDialog(login.this);
                            progressDialog.setMessage("Iniciando..."); // Setting Message
                            progressDialog.setTitle("Espere un momento"); // Setting Title
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                            progressDialog.show(); // Display Progress Dialog
                            progressDialog.setCancelable(false);
                        try {
                            JSONObject jsonRespuesta = new JSONObject(response);
                            boolean ok = jsonRespuesta.getBoolean("success");
                            if (ok == true){
                                String usuario = jsonRespuesta.getString("usuario");
                                String email = jsonRespuesta.getString("email");
                                String nombre = jsonRespuesta.getString("nombre");
                                String entidad = jsonRespuesta.getString("entidad");
                                int edad = jsonRespuesta.getInt("edad");
                                ///////////////cargar usuario/////////////////////////////////////////////////////////////////
                                SharedPreferences preferences= getSharedPreferences("datossecion", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor= preferences.edit();
                                editor.putString("usuario",usuario);
                                editor.putString("nombreusuario",nombre);
                                editor.putString("emailusuario",email);
                                editor.putString("entidadusuario",entidad);
                                editor.putInt("edad",edad);
                                editor.commit();
                                ////////////////////laza actividad//////////////////////////////////////////////////////////
                                Intent bienvenido =   new Intent(login.this,bienvenido.class);
                                bienvenido.putExtra("nombre",nombre);
                                bienvenido.putExtra("edad",edad);
                                login.this.startActivity(bienvenido);
                              /////////////////////////toast con estilos  libreria //////////////////////////////////////////////////////////////////
                                StyleableToast.makeText(getApplicationContext(),"Bienvenido: \n"+ nombre +"  a Ecol app para la conservacion de nuestra agua",Toast.LENGTH_LONG,R.style.StyleableToast).show();

                            }else{
                                AlertDialog.Builder alerta = new AlertDialog.Builder(login.this);
                                alerta.setMessage("Hubo un Fallo Revise De nuevo Sus Datos")
                                        .setNegativeButton("Intenta de nuevo",null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e) {
                            e.getMessage();
                        }
                    }
                };
                LoginRequest  r = new LoginRequest(usuario,clave,respuesta);
                RequestQueue cola = Volley.newRequestQueue(login.this);
                cola.add(r);
            }
        });


    }

    private void validarsecion() {
        SharedPreferences preferences=getSharedPreferences("datossecion", Context.MODE_PRIVATE);
        String usuario =preferences.getString("usuario",null);
        if (usuario != null){
            Intent bienvenido =   new Intent(login.this,bienvenido.class);
            login.this.startActivity(bienvenido);
            finish();
        }
    }

    //alert dialog para salir de la app
    @Override
    public void onBackPressed() {
        final androidx.appcompat.app.AlertDialog.Builder mysalir = new androidx.appcompat.app.AlertDialog.Builder(this);
        mysalir.setMessage("Deseas salir de la aplicacion Ecol");
        mysalir.setTitle("Alerta");
        mysalir.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        mysalir.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        androidx.appcompat.app.AlertDialog dialogInterface = mysalir.create();
        dialogInterface.show();
    }
}
