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
import android.widget.TextView;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;


public class fragment_resultados_qbr extends Fragment {
    private TextView puntos_grado_cubierta,puntos_estructuraa_cubierta,puntos_calidad_cubierta,puntos_grado_naturulidad;
    Button enviarresultado;

    public fragment_resultados_qbr() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cargarpreferencias();
        View view =  inflater.inflate(R.layout.fragment_fragment_resultados_qbr, container, false);
        ////////////////////////////////////textviwe resultados////////////////////////////////
        puntos_grado_cubierta =(TextView)  view.findViewById(R.id.txtpuntos_grado_cubierta);
        puntos_estructuraa_cubierta =(TextView) view.findViewById(R.id.txtpuntos_estructura_cubierta);
        puntos_calidad_cubierta =(TextView) view.findViewById(R.id.txtpuntos_calidad_cubierta);
        puntos_grado_naturulidad =(TextView) view.findViewById(R.id.txtpuntos_grado_naturilidad);
        //resultadosqbr =(TextView) view.findViewById(R.id.txtresultadosqbr);
        enviarresultado =(Button) view.findViewById(R.id.resultadoqbr);

        enviarresultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogoPersonalizado();
            }
        });
        return view;}

    private void mostrarDialogoPersonalizado() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.ventaja_emergente_resultasoihf,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        ///////////////////////////cargar resultados obtenidos///////////////////////////////////////////////////
        SharedPreferences preferences=this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String grado_cubierta =preferences.getString("puntos_grado_cubierta","0");
        if (grado_cubierta.equals("0")){
            grado_cubierta="0";
            enviarresultado.setEnabled(false);
        }
        String estructuraa_cubierta =preferences.getString("puntos_estructura_cubierta","0");
        if (estructuraa_cubierta.equals("0")){
            grado_cubierta="0";
            enviarresultado.setEnabled(false);
        }
        String calidad_cubierta =preferences.getString("puntos_calidad_cubierta","0");
        if (calidad_cubierta.equals("0")){
            grado_cubierta="0";
            enviarresultado.setEnabled(false);
        }
        String grado_naturulidad =preferences.getString("puntos_grado_naturalidad","0");
        if (grado_cubierta.equals("0")){
            grado_cubierta="0";
            enviarresultado.setEnabled(false);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        puntos_grado_cubierta.setText(grado_cubierta);
        puntos_estructuraa_cubierta.setText(estructuraa_cubierta);
        puntos_calidad_cubierta.setText(calidad_cubierta);
        puntos_grado_naturulidad.setText(grado_naturulidad);
        int puntosgradoc =Integer.parseInt(grado_cubierta);
        int puntosestructurac =Integer.parseInt(estructuraa_cubierta);
        int puntoscalidadc =Integer.parseInt(calidad_cubierta);
        int puntosnaturilidadc =Integer.parseInt(calidad_cubierta);
        /////////////////////sumatoria/////////////////////////////////////////////////////////////////////////////
        int valoracu= puntosgradoc+ puntosestructurac+ puntoscalidadc+ puntosnaturilidadc;
        final String res = String.valueOf(valoracu);
        //resultadosqbr.setText(res);
        TextView txt = view.findViewById(R.id.text_dialog);
        final TextView txt2 = view.findViewById(R.id.text_dialog_puntos);
        txt.setText("Total QBR:\n");
        //String ress = String.valueOf(valoracu);
        txt2.setText(res);
        Button btnReintentar = view.findViewById(R.id.btnReintentar);
        btnReintentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
                String resultado_qbr = txt2.getText().toString();
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("qbr",resultado_qbr);
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

    @Override
    public void onResume() {
        super.onResume();
        getPrefs();
    }
    private void getPrefs() {
        SharedPreferences preferences=this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
        String grado_cubierta =preferences.getString("puntos_grado_cubierta","0");
        String estructuraa_cubierta =preferences.getString("puntos_estructura_cubierta","0");
        String calidad_cubierta =preferences.getString("puntos_calidad_cubierta","0");
        String grado_naturulidad =preferences.getString("puntos_grado_naturalidad","0");
        String qbr =preferences.getString("qbrresultado","0");
        puntos_grado_cubierta.setText(grado_cubierta);
        puntos_estructuraa_cubierta.setText(estructuraa_cubierta);
        puntos_calidad_cubierta.setText(calidad_cubierta);
        puntos_grado_naturulidad.setText(grado_naturulidad);
    }

    private void cargarpreferencias() {
        SharedPreferences preferences=this.getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
    }
}
