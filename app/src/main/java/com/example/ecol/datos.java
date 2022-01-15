package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.HashMap;
import java.util.Map;

public class datos extends AppCompatActivity {
    EditText usuario,dirrecion,logitud,latitud,altura,lugar,fecha,ciudad,departamento,nombreecosistema,nombrepresional,puntoecosistema,codigomuestra,ecosisteaevaluado;
    TextView clima,hidrologia,turbidez,regimenprecpotacion;
    TextView gradocubierta,estructuracubierta,calidadcubierta,gradonaturilidad,qbrresultado;
    TextView coberturavegeteacion,elemtohetero,porcentajesombra,regimenvelocidad,compocionsustrato,frecuenciasrapidos,inclusiconrapidos,ihf;
    TextView bmwproldan,bmwzamora;
    TextView actividad;
    Button enviarResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nDatos E.COL");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.icono_otrosdatos);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_datos);

        enviarResultados=(Button) findViewById(R.id.resultados);

        usuario =(EditText) findViewById(R.id.usuario);
        dirrecion =(EditText) findViewById(R.id.dirrecion);
        logitud =(EditText) findViewById(R.id.logitud);
        latitud =(EditText) findViewById(R.id.latitud);
        altura =(EditText) findViewById(R.id.altura);
        lugar =(EditText) findViewById(R.id.lugar);
        fecha =(EditText) findViewById(R.id.fecha);
        ciudad =(EditText) findViewById(R.id.ciudad1);
        departamento =(EditText) findViewById(R.id.departamento);
        nombreecosistema =(EditText) findViewById(R.id.nombreecosistema);
        nombrepresional =(EditText) findViewById(R.id.nombrepresional);
        puntoecosistema =(EditText) findViewById(R.id.puntoecosistema);
        codigomuestra =(EditText) findViewById(R.id.codigomuestra);
        ecosisteaevaluado =(EditText) findViewById(R.id.ecosisteaevaluado);
        ////////////////////////////////////////////////////////////////////
        clima =(TextView) findViewById(R.id.clima);
        hidrologia =(TextView) findViewById(R.id.hidrologia);
        turbidez =(TextView) findViewById(R.id.turdides);
        regimenprecpotacion =(TextView) findViewById(R.id.precipitacion);
        ///////////////////////////////////////////////////////////////////////////
        gradocubierta =(TextView) findViewById(R.id.gradocubierta);
        estructuracubierta =(TextView) findViewById(R.id.estructuracubierta);
        calidadcubierta =(TextView) findViewById(R.id.calidadcubierta);
        gradonaturilidad =(TextView) findViewById(R.id.gradonaturalidad);
        qbrresultado =(TextView) findViewById(R.id.qbr);
        ////////////////
        bmwproldan=(TextView) findViewById(R.id.biologico1);
        gradocubierta =(TextView) findViewById(R.id.gradocubierta);
        estructuracubierta =(TextView) findViewById(R.id.estructuracubierta);
        calidadcubierta =(TextView) findViewById(R.id.calidadcubierta);
        gradonaturilidad =(TextView) findViewById(R.id.gradonaturalidad);
        qbrresultado =(TextView) findViewById(R.id.qbr);


        ///////////////////////////////////ihf///////////////////////////////////
        coberturavegeteacion=(TextView) findViewById(R.id.coberturavegeteacion);
        elemtohetero =(TextView) findViewById(R.id.elemtohetero);
        porcentajesombra =(TextView) findViewById(R.id.porcentajesombra);
        regimenvelocidad =(TextView) findViewById(R.id.regimenvelocidad);
        compocionsustrato =(TextView) findViewById(R.id.compocionsustrato);
        frecuenciasrapidos =(TextView) findViewById(R.id.frecuenciasrapidos);
        inclusiconrapidos=(TextView) findViewById(R.id.inclusiconrapidos);
        ihf=(TextView) findViewById(R.id.ihf);

        ////////////////////////bioogico////////////////////////
        bmwproldan=(TextView) findViewById(R.id.biologico1);
        bmwzamora=(TextView) findViewById(R.id.biologico2);

        //////////////////////////otros datos///////////////////////
        actividad=(TextView) findViewById(R.id.actividad);


        SharedPreferences preferences1= getSharedPreferences("datossecion", Context.MODE_PRIVATE);
        String user =preferences1.getString("usuario","--");



        SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        String dirreci =preferences.getString("dirrecion","");
        String logitu =preferences.getString("logitud","");
        String latitu =preferences.getString("latitud","");
        String altur =preferences.getString("altura","");
        String luga =preferences.getString("lugar","");
        String fech =preferences.getString("fecha","");
        String ciuda =preferences.getString("ciudad","");
        String departament =preferences.getString("departamento","");
        String nombreecosistem =preferences.getString("ecositema","");
        String nombrepresiona =preferences.getString("nombrepresional","");
        String puntoecosistem =preferences.getString("puntoecosistema","");
        String codigomuestr =preferences.getString("codigomuestra","");
        String clim =preferences.getString("clima","");
        String turbide =preferences.getString("turbidez","");
        String regime =preferences.getString("regimen","");
        String hidrolog =preferences.getString("hidrologia","");
        String ecositemaeval =preferences.getString("ecositemaevaluado","");
        /////////////////////////////////////////qbr///////////////////////////////////////////////////////
        String grado_cubierta =preferences.getString("puntos_grado_cubierta","0");
        String estructuraa_cubierta =preferences.getString("puntos_estructura_cubierta","0");
        String calidad_cubierta =preferences.getString("puntos_calidad_cubierta","0");
        String grado_naturulidad =preferences.getString("puntos_grado_naturalidad","0");
        String qbrresultados =preferences.getString("qbr","0");
        ////////////////////////////////////////////ihf///////////////////////////////////////////////////
        String cobertura_vegetacion =preferences.getString("puntos_cobertura_vegetacion","");
        String composicion_sustrato =preferences.getString("puntos_composicion_sustrato","");
        String porcentaje_heterogenidad =preferences.getString("puntos_porcentaje_heterogenidad","");
        String frecuencias_rapidos =preferences.getString("puntos_frecuencias_rapidos","");
        String porcentaje_cauce =preferences.getString("puntos_porcentaje_cauce","");
        String rapidos_sedimentos =preferences.getString("puntos_rapidos_sedimentos","");
        String regimen_velocidad =preferences.getString("puntos_regimen_velocidad","");
        String resultadoihf =preferences.getString("puntos_ihf","-");
        /////////////////////////////////////////////biologia///////////////////////////////////////////////
         String biologico1 = preferences.getString("zamora","-");
         String biologico2 = preferences.getString("roldan","-");
        //String res = String.valueOf(biologico1);


        //////////////////////////otrso datos///////////////////////////
        String actividadrealizada = preferences.getString("actividad_rio","-");

        ///////////////////////////////datos principales///////////////////////
        usuario.setText(user);
        dirrecion.setText(dirreci);
        logitud.setText(logitu);
        latitud.setText(latitu);
        altura.setText(altur);
        lugar.setText(luga);
        fecha.setText(fech);
        ciudad.setText(ciuda);
        ecosisteaevaluado.setText(ecositemaeval);
        departamento.setText(departament);
        nombreecosistema.setText(nombreecosistem);
        nombrepresional.setText(nombrepresiona);
        puntoecosistema.setText(puntoecosistem);
        codigomuestra.setText(codigomuestr);
        ////////////////////CLIMA/////////////////
        clima.setText(clim);
        turbidez.setText(turbide);
        hidrologia.setText(hidrolog);
        regimenprecpotacion.setText(regime);
        ///////////////////////////////////////qbr////////////////////////////
        gradocubierta.setText(grado_cubierta);
        estructuracubierta.setText(estructuraa_cubierta);
        calidadcubierta.setText(calidad_cubierta);
        gradonaturilidad.setText(grado_naturulidad);
        qbrresultado.setText(qbrresultados);
        ///////////////////////////////biologico/////////////////////////////
        bmwproldan.setText(biologico2);
        bmwzamora.setText(biologico1);
        /////////////////////////////ihf/////////////////////////////////////
        coberturavegeteacion.setText(cobertura_vegetacion);
        elemtohetero.setText(porcentaje_heterogenidad);
        porcentajesombra.setText(porcentaje_cauce);
        regimenvelocidad.setText(regimen_velocidad);
        compocionsustrato.setText(composicion_sustrato);
        frecuenciasrapidos.setText(frecuencias_rapidos);
        inclusiconrapidos.setText(rapidos_sedimentos);
        ihf.setText(resultadoihf);
        //////////////////////otros datos///////////////////////
        actividad.setText(actividadrealizada);

        enviarResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                if (networkInfo != null && networkInfo.isConnected()) {
                    ejecutarservico("https://ecolapp.webcindario.com/app/datos.php");
                } else {
                    sinconexion();
                }
            }
        });

    }

    private void sinconexion() {
        final AlertDialog.Builder mysalir = new AlertDialog.Builder(this);
        mysalir.setMessage("Desea guardar la información obtenida");
        mysalir.setTitle("Usted no tiene conexión a internet");
        mysalir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent miIntent =new Intent(datos.this,dashboardprin.class);
                startActivity(miIntent);
                finish();
            }
        });
        mysalir.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent miIntent =new Intent(datos.this,bienvenido.class);
                SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);
                preferences.edit().clear().commit();
                startActivity(miIntent);
                finish();
            }
        });
        AlertDialog dialogInterface = mysalir.create();
        dialogInterface.show();
    }

    private void ejecutarservico(final String URL){
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                VolleyLog.d(URL);
                StyleableToast.makeText(getApplicationContext(),"Datos guardado correctamente", Toast.LENGTH_LONG,R.style.StyleableToast).show();
                Intent miIntent =new Intent(datos.this,dashboardprin.class);
                startActivity(miIntent);
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                StyleableToast.makeText(getApplicationContext(),"Ha ocurrido un error ",Toast.LENGTH_LONG,R.style.StyleableToast).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametro=new HashMap<>();
                ///////////////////////////datos principales///////////////////////////////////////
                parametro.put("usuario",usuario.getText().toString());
                parametro.put("dirrecion",dirrecion.getText().toString());
                parametro.put("longitud",logitud.getText().toString());
                parametro.put("latitud",latitud.getText().toString());
                parametro.put("altura",altura.getText().toString());
                parametro.put("lugar",lugar.getText().toString());
                parametro.put("fecha",fecha.getText().toString());
                parametro.put("ciudad",ciudad.getText().toString());
                parametro.put("ecositema_evaluado",ecosisteaevaluado.getText().toString());
                parametro.put("departamento",departamento.getText().toString());
                parametro.put("nombre_ecocistema",nombreecosistema.getText().toString());
                parametro.put("nombre_presional",nombrepresional.getText().toString());
                parametro.put("puntos_cosistema",puntoecosistema.getText().toString());
                parametro.put("codigo_muestra",codigomuestra.getText().toString());
                /////////////////////////CLIMA////////////////////////////////////////
                parametro.put("clima",clima.getText().toString());
                parametro.put("turbidez",turbidez.getText().toString());
                parametro.put("hidrologia",hidrologia.getText().toString());
                parametro.put("regimen_precipitacion",regimenprecpotacion.getText().toString());
                ///////////////////////////////biologia///////////////////////////////////////////////
                parametro.put("bmwp_roldan",bmwproldan.getText().toString());
                parametro.put("bmw_zamora",bmwzamora.getText().toString());
                /////////////////////ihf/////////////////////////////////////////////////////////////
                parametro.put("cobertura_vegeteacion",coberturavegeteacion.getText().toString());
                parametro.put("elemtos_heterogeneidad",elemtohetero.getText().toString());
                parametro.put("porcentaje_sombra",porcentajesombra.getText().toString());
                parametro.put("regimen_velocidad",regimenvelocidad.getText().toString());
                parametro.put("compocion_sustrato",compocionsustrato.getText().toString());
                parametro.put("frecuencias_rapidos",frecuenciasrapidos.getText().toString());
                parametro.put("resultado_ihf",ihf.getText().toString());
                ////////////////////////qbr///////////////////////////////////////////////////////////
                parametro.put("grado_cubierta_vegetacion",gradocubierta.getText().toString());
                parametro.put("estructura_cubierta",estructuracubierta.getText().toString());
                parametro.put("calidad_cubierta",calidadcubierta.getText().toString());
                parametro.put("grado_naturilidad",gradonaturilidad.getText().toString());
                parametro.put("qbr_resultado",qbrresultado.getText().toString());

                return parametro;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
