package com.example.ecol;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;


public class ragment_ihf_resultados extends Fragment {
    private TextView puntos_cobertura_vegetacion,puntos_composicion_sustrato,puntos_porcentaje_heterogenidad,puntos_frecuencias_rapidos;
    private TextView puntos_porcentaje_cauce,puntos_rapidos_sedimentos,puntos_regimen_velocidad;
    private Button enviarresultado;
    public ragment_ihf_resultados() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_ragment_ihf_resultados, container, false);
        enviarresultado =(Button)  view.findViewById(R.id.resultadoihf);

        ////////////////////////////////////textviwe resultados////////////////////////////////
        puntos_cobertura_vegetacion =(TextView)  view.findViewById(R.id.txtresultvegetacion);
        puntos_composicion_sustrato =(TextView) view.findViewById(R.id.txtresulsubtrato);
        puntos_porcentaje_heterogenidad =(TextView) view.findViewById(R.id.txtresulhetero);
        puntos_frecuencias_rapidos =(TextView) view.findViewById(R.id.txtresultadofrecuenciarapidos);
        puntos_porcentaje_cauce =(TextView) view.findViewById(R.id.txtresulsombra);
        puntos_rapidos_sedimentos =(TextView) view.findViewById(R.id.txtresultadorapidossedimento);
        puntos_regimen_velocidad =(TextView) view.findViewById(R.id.txtresulvelocidad);
        ///////////////////////////cargar resultados obtenidos///////////////////////////////////////////////////
        SharedPreferences preferences=this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String cobertura_vegetacion =preferences.getString("puntos_cobertura_vegetacion","");
        String composicion_sustrato =preferences.getString("puntos_composicion_sustrato","");
        String porcentaje_heterogenidad =preferences.getString("puntos_porcentaje_heterogenidad","");
        String frecuencias_rapidos =preferences.getString("puntos_frecuencias_rapidos","");
        String porcentaje_cauce =preferences.getString("puntos_porcentaje_cauce","");
        String rapidos_sedimentos =preferences.getString("puntos_rapidos_sedimentos","");
        String regimen_velocidad =preferences.getString("puntos_regimen_velocidad","");
        puntos_cobertura_vegetacion.setText(cobertura_vegetacion);
        puntos_composicion_sustrato.setText(composicion_sustrato);
        puntos_porcentaje_heterogenidad.setText(porcentaje_heterogenidad);
        puntos_frecuencias_rapidos.setText(frecuencias_rapidos);
        puntos_porcentaje_cauce.setText(porcentaje_cauce);
        puntos_rapidos_sedimentos.setText(rapidos_sedimentos);
        puntos_regimen_velocidad.setText(regimen_velocidad);
        ////////////////metodo para cargara valores////////////////////////////
        enviarresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoPersonalizado();
            }
        });

        return view;

    }

    private void mostrarDialogoPersonalizado(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.ventaja_emergente_resultasoihf,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        //////////////////////////cargando datos para hacer sumatoria///////////////////////////////////////////
        SharedPreferences preferences=this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String cobertura_vegetacion =preferences.getString("puntos_cobertura_vegetacion","0");
        if (cobertura_vegetacion.equals("0")){
            cobertura_vegetacion="0";
            enviarresultado.setEnabled(false);
        }
        String composicion_sustrato =preferences.getString("puntos_composicion_sustrato","0");
            if (composicion_sustrato.equals("0")){
                composicion_sustrato="0";
                enviarresultado.setEnabled(false);
            }
        String porcentaje_heterogenidad =preferences.getString("puntos_porcentaje_heterogenidad","0");
                if (porcentaje_heterogenidad.equals("0")){
                    cobertura_vegetacion="0";
                    enviarresultado.setEnabled(false);
                }
        String frecuencias_rapidos =preferences.getString("puntos_frecuencias_rapidos","0");
                    if (frecuencias_rapidos.equals("0")){
                        cobertura_vegetacion="0";
                        enviarresultado.setEnabled(false);
                    }
        String porcentaje_cauce =preferences.getString("puntos_porcentaje_cauce","0");
                        if (porcentaje_cauce.equals("0")){
                            cobertura_vegetacion="0";
                            enviarresultado.setEnabled(false);
                        }
        String rapidos_sedimentos =preferences.getString("puntos_rapidos_sedimentos","0");
                            if (rapidos_sedimentos.equals("0")){
                                cobertura_vegetacion="0";
                                enviarresultado.setEnabled(false);
                            }
        String regimen_velocidad =preferences.getString("puntos_regimen_velocidad","0");
                                if (regimen_velocidad.equals("0")){
                                    cobertura_vegetacion="0";
                                    enviarresultado.setEnabled(false);
                                }
                                    ////////////////////////////////////////////////////////////////////////////////////////////
        puntos_cobertura_vegetacion.setText(cobertura_vegetacion);
        puntos_composicion_sustrato.setText(composicion_sustrato);
        puntos_porcentaje_heterogenidad.setText(porcentaje_heterogenidad);
        puntos_frecuencias_rapidos.setText(frecuencias_rapidos);
        puntos_porcentaje_cauce.setText(porcentaje_cauce);
        puntos_rapidos_sedimentos.setText(rapidos_sedimentos);
        puntos_regimen_velocidad.setText(regimen_velocidad);
        ////////////////metodo para cargara valores////////////////////////////

        ///////////////////////sumatoria total/////////////////////////////////////////////////////////////////////
        int puntoscomposicion =Integer.parseInt(puntos_cobertura_vegetacion.getText().toString());
        int puntoporcentaje =Integer.parseInt(puntos_porcentaje_cauce.getText().toString());
        int puntosfrecuencias =Integer.parseInt(puntos_frecuencias_rapidos.getText().toString());
        int puntosporcentaje =Integer.parseInt(puntos_porcentaje_heterogenidad.getText().toString());
        int puntosrapidos =Integer.parseInt(puntos_frecuencias_rapidos.getText().toString());
        int puntossedimento =Integer.parseInt(puntos_rapidos_sedimentos.getText().toString());
        /////////////////////sumatoria/////////////////////////////////////////////////////////////////////////////
        int valoracu= puntoporcentaje+ puntoscomposicion+ puntosfrecuencias+puntosporcentaje+ puntosrapidos+ puntossedimento;
        TextView txt = view.findViewById(R.id.text_dialog);
        final TextView txt2 = view.findViewById(R.id.text_dialog_puntos);
        txt.setText("Total IHF:\n");
        String res = String.valueOf(valoracu);
        txt2.setText(res);
        Button btnReintentar = view.findViewById(R.id.btnReintentar);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
                String resultado_ihf = txt2.getText().toString();
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("puntos_ihf",resultado_ihf);
                editor.commit();
                Intent intent = new Intent(getActivity(),dashboardprin.class);
                startActivity(intent);
                CustomIntent.customType(requireActivity(),"fadein-to-fadeout");
                //Toast.makeText(getActivity(),"Total IHF:"+resultado_ihf,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
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
