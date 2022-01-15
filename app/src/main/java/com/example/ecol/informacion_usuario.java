package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class informacion_usuario extends AppCompatActivity {
    EditText emailusuario,usuariousuario,entidadusuario;
    TextView nombreusuario,edadusuario;
    Button modificar,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nInformación");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icono_user);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_informacion_usuario);

        nombreusuario =(TextView) findViewById(R.id.nombreusuario);
        emailusuario =(EditText) findViewById(R.id.emailusuario);
        usuariousuario =(EditText) findViewById(R.id.usuariousuario);
        entidadusuario=(EditText) findViewById(R.id.entidadusuario);
        edadusuario=(TextView) findViewById(R.id.edadusuario);
        //salir=(Button) findViewById(R.id.cerrar);
        SharedPreferences preferences=getSharedPreferences("datossecion", Context.MODE_PRIVATE);
        String nombre =preferences.getString("nombreusuario","--");
        String email =preferences.getString("emailusuario","--");
        String usuario =preferences.getString("usuario","--");
        String entidad =preferences.getString("entidadusuario","--");
        int edad = preferences.getInt("edad",1);
        String edadtexto = String.valueOf(edad);
        nombreusuario.setText(nombre);
        emailusuario.setText(email);
        usuariousuario.setText(usuario);
        entidadusuario.setText(entidad);
        edadusuario.setText(edadtexto);
        emailusuario.setEnabled(false);
        usuariousuario.setEnabled(false);
        entidadusuario.setEnabled(false);
        //dirrecion.setEnabled(false);


    }
    public void onBackPressed() {
        Intent miIntent =new Intent(informacion_usuario.this,login.class);
        startActivity(miIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bienvenidonavigetion, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {

            case R.id.btncerrasecion:
                cerarsecion();
                return true;
            case R.id.cerar:
                ceraraactivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}

    private void ceraraactivity() {
        Intent miIntent =new Intent(informacion_usuario.this,bienvenido.class);
        startActivity(miIntent);
        finish();
    }
    private void cerarsecion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(informacion_usuario.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.modal_cerrar_secion,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        TextView txt = view.findViewById(R.id.text_dialog);
        txt.setText("Tenga en cuenta que al cerrar la sesión se elimanaran tus datos");

        Button btnReintentar = view.findViewById(R.id.btnReintentar);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent =new Intent(informacion_usuario.this,login.class);
                SharedPreferences preferences= getSharedPreferences("datossecion", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                startActivity(miIntent);
                finish();
            }
        });
        Button btnCancel = view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }
}
