package com.example.ecol;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.util.Hashtable;
import java.util.Map;

import maes.tech.intentanim.CustomIntent;

public class dashboardprin extends AppCompatActivity implements View.OnClickListener {
    LinearLayout biologico,foto,ihf,prueba,qbr;
    Button btnDesbohar,otrosdatos;
    ImageView fotos;
    Button botonCargar;
    //////////////////////camara/////////////////////////////////
    final int COD_FOTO = 20;
    final String CARPETA_RAIZ = "Ecol";
    final String CARPETA_IMAGENES = "imagenes";
    final String RUTA_IMAGEN = CARPETA_RAIZ + CARPETA_IMAGENES;
    String path;
    Bitmap bitmap;
    private String UPLOAD_URL ="https://ecolapp.webcindario.com/img/img.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nEcol Dashboard");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icono_dashboard);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_dashboardprin);
        /////////////////////////////////campos variables////////////////////////////////////////////////////////////////////////////
        btnDesbohar=(Button) findViewById(R.id.btnDesbohar);
        biologico =(LinearLayout) findViewById(R.id.biologico);
        ihf =(LinearLayout) findViewById(R.id.ihf);
        qbr =(LinearLayout) findViewById(R.id.qbr);
        foto =(LinearLayout) findViewById(R.id.foto);
        fotos =(ImageView) findViewById(R.id.fotos);
        prueba =(LinearLayout) findViewById(R.id.camraprueba);
        otrosdatos =(Button) findViewById(R.id.otrosdatos);
        //////////////////////Metodos/////////////////////////////////////////////////////////////////////////////////////////////////
        biologico.setOnClickListener(this);
        ihf.setOnClickListener(this);
        qbr.setOnClickListener(this);


        otrosdatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent =new Intent(dashboardprin.this,otrosdatos.class);
                startActivity(miIntent);
                finish();
            }
        });
        btnDesbohar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), datos.class);
                startActivity(intent);
               envairdatosactivity();
            }
        });

        //////////////////////////// PERMISOS PARA ANDROID 6 O SUPERIOR/////////////////////////////////////////////////////////////////////////////////////
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TomarFoto();
            }
        });
    }

    private void envairdatosactivity() {
        uploadImage();
    }

    ////////////////////////////////////////////////////////Tomar foto y almacenar en galeria/////////////////////////////////////////
    private void TomarFoto() {
        String nombreImagen = "";

        File fileImagen = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        boolean isCreada = fileImagen.exists();
        if(isCreada == false) {
            isCreada = fileImagen.mkdirs();
        }
        if(isCreada == true) {
            nombreImagen = (System.currentTimeMillis() / 1000) + ".jpg";
        }
        path = Environment.getExternalStorageDirectory()+File.separator+RUTA_IMAGEN+File.separator+nombreImagen;
        File imagen = new File(path);

        Intent intent = null;
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authorities = this.getPackageName()+".provider";
            Uri imageUri = FileProvider.getUriForFile(this, authorities, imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent, COD_FOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                        }
                    });
                    bitmap = BitmapFactory.decodeFile(path);
                    fotos.setImageBitmap(bitmap);
                    break;
            }

        }

    }



    private String convertirImgString(Bitmap bitmap) {
        ByteArrayOutputStream array=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,array);
        byte[] imagenByte=array.toByteArray();
        String imagenString= Base64.encodeToString(imagenByte,Base64.DEFAULT);
        return imagenString;
    }

    private void uploadImage(){
        //Mostrar el diálogo de progreso
        final ProgressDialog loading = ProgressDialog.show(this,"Subiendo...","Espere por favor...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();
                        //Mostrando el mensaje de la respuesta
                        Toast.makeText(dashboardprin.this, s , Toast.LENGTH_LONG).show();
                        //Intent intent = new Intent(getApplicationContext(), datos.class);
                        //startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Descartar el diálogo de progreso
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(dashboardprin.this,"Error intente de nuevo", Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Convertir bits a cadena
                String imagen = convertirImgString(bitmap);

                //Obtener el nombre de la imagen
                //String nombre = editTextName.getText().toString().trim();
                SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
                String nombreimagen =preferences.getString("nombreecosistema","");

                //Creación de parámetros
                Map<String,String> params = new Hashtable<String, String>();

                //Agregando de parámetros
                params.put("foto", imagen);
                params.put("nombre", nombreimagen);

                //Parámetros de retorno
                return params;
            }
        };

        //Creación de una cola de solicitudes
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Agregar solicitud a la cola
        requestQueue.add(stringRequest);
    }
    ///////////////////////////////////////////menu dasboar//////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onClick(View view) {
        Intent i ;
        switch (view.getId()){
            case R.id.biologico : i = new Intent(this,componntebiologico.class);
                LinearLayout biologico  = (LinearLayout) findViewById(R.id.biologico);
                startActivity(i);
                break;
            case R.id.ihf : i = new Intent(this,ihf.class);
                LinearLayout ihf  = (LinearLayout) findViewById(R.id.ihf);
                startActivity(i);
                break;
            case R.id.qbr : i = new Intent(this,qrd.class);
                LinearLayout qbr  = (LinearLayout) findViewById(R.id.qbr);
                startActivity(i);
                break;
            default:break;
        }
    }
    //////////////////////////////////////////regresar metodo de boton retroceder//////////////////////////////////////////////////////////////////////
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder mysalir = new AlertDialog.Builder(this);
        mysalir.setMessage("Seguro que Deseas salir");
        mysalir.setTitle("Alerta");
        mysalir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent miIntent =new Intent(dashboardprin.this,bienvenido.class);
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
