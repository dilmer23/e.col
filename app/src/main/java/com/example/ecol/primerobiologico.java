package com.example.ecol;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import me.relex.circleindicator.CircleIndicator;


public class primerobiologico extends Fragment {


    public primerobiologico() {

    }

    private CheckBox familia1,familia2,familia3,familia4,familia5,familia6,familia7,familia8,familia9,familia10;
    private CheckBox familia11,familia12,familia13,familia14,familia15,familia16,familia17,familia18,familia19,familia20;
    private CheckBox familia21,familia22,familia23,familia24,familia25,familia26,familia27,familia28,familia29,familia30;
    private CheckBox familia31,familia32,familia33,familia34,familia35,familia36,familia37,familia38,familia39,familia40;
    private CheckBox familia41,familia42,familia43,familia44,familia45,familia46,familia47,familia48,familia49,familia50;
    private CheckBox familia51,familia52,familia53,familia54,familia55,familia56,familia57,familia58,familia59,familia60;
    private CheckBox familia61,familia62,familia63,familia64,familia65,familia66,familia67,familia68,familia69,familia70;
    private CheckBox familia71,familia72,familia73,familia74,familia75,familia76,familia77,familia78,familia79,familia80;
    private CheckBox familia81,familia82,familia83,familia84,familia85,familia86,familia87,familia88,familia89,familia90;
    private CheckBox familia91,familia92,familia93,familia94;
    private EditText puntuacion;
    private ViewPager viewPager;
    private Button calcualr,btnclavedictonica,btnlimpiar,btncal2;
    private TextView estadopuntuacion;
    private String valor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primerobiologico, container, false);
/////////////////////////////////////////inicializar checkbok////////////////////////////////////////////////////
        familia1 = (CheckBox) view.findViewById(R.id.familia1);
        familia2 = (CheckBox) view.findViewById(R.id.familia2);
        familia3 = (CheckBox) view.findViewById(R.id.familia3);
        familia4 = (CheckBox) view.findViewById(R.id.familia4);
        familia5 = (CheckBox) view.findViewById(R.id.familia5);
        familia6 = (CheckBox) view.findViewById(R.id.familia6);
        familia7 = (CheckBox) view.findViewById(R.id.familia7);
        familia8 = (CheckBox) view.findViewById(R.id.familia8);
        familia9 = (CheckBox) view.findViewById(R.id.familia9);
        familia10 = (CheckBox) view.findViewById(R.id.familia10);
        familia11 = (CheckBox) view.findViewById(R.id.familia11);
        familia12 = (CheckBox) view.findViewById(R.id.familia12);
        familia13 = (CheckBox) view.findViewById(R.id.familia13);
        familia14 = (CheckBox) view.findViewById(R.id.familia14);
        familia15 = (CheckBox) view.findViewById(R.id.familia15);
        familia16 = (CheckBox) view.findViewById(R.id.familia16);
        familia17 = (CheckBox) view.findViewById(R.id.familia17);
        familia18 = (CheckBox) view.findViewById(R.id.familia18);
        familia19 = (CheckBox) view.findViewById(R.id.familia19);
        familia20 = (CheckBox) view.findViewById(R.id.familia20);
        familia21 = (CheckBox) view.findViewById(R.id.familia21);
        familia22 = (CheckBox) view.findViewById(R.id.familia22);
        familia23 = (CheckBox) view.findViewById(R.id.familia23);
        familia24 = (CheckBox) view.findViewById(R.id.familia24);
        familia25 = (CheckBox) view.findViewById(R.id.familia25);
        familia26 = (CheckBox) view.findViewById(R.id.familia26);
        familia27 = (CheckBox) view.findViewById(R.id.familia27);
        familia28 = (CheckBox) view.findViewById(R.id.familia28);
        familia29 = (CheckBox) view.findViewById(R.id.familia29);
        familia30 = (CheckBox) view.findViewById(R.id.familia30);
        familia31 = (CheckBox) view.findViewById(R.id.familia31);
        familia32 = (CheckBox) view.findViewById(R.id.familia32);
        familia33 = (CheckBox) view.findViewById(R.id.familia33);
        familia34 = (CheckBox) view.findViewById(R.id.familia34);
        familia35 = (CheckBox) view.findViewById(R.id.familia35);
        familia36 = (CheckBox) view.findViewById(R.id.familia36);
        familia37 = (CheckBox) view.findViewById(R.id.familia37);
        //familia38 = (CheckBox) view.findViewById(R.id.familia38);
        familia39 = (CheckBox) view.findViewById(R.id.familia39);
        familia40 = (CheckBox) view.findViewById(R.id.familia40);
        familia41 = (CheckBox) view.findViewById(R.id.familia41);
        familia42 = (CheckBox) view.findViewById(R.id.familia42);
        familia43 = (CheckBox) view.findViewById(R.id.familia43);
        familia44 = (CheckBox) view.findViewById(R.id.familia44);
        familia45 = (CheckBox) view.findViewById(R.id.familia45);
        familia46 = (CheckBox) view.findViewById(R.id.familia46);
        familia47 = (CheckBox) view.findViewById(R.id.familia47);
        familia48 = (CheckBox) view.findViewById(R.id.familia48);
        familia49 = (CheckBox) view.findViewById(R.id.familia49);
        familia50 = (CheckBox) view.findViewById(R.id.familia50);
        familia51 = (CheckBox) view.findViewById(R.id.familia51);
        familia52 = (CheckBox) view.findViewById(R.id.familia52);
        familia53 = (CheckBox) view.findViewById(R.id.familia53);
        familia54 = (CheckBox) view.findViewById(R.id.familia54);
        familia55 = (CheckBox) view.findViewById(R.id.familia55);
        familia56 = (CheckBox) view.findViewById(R.id.familia56);
        familia57 = (CheckBox) view.findViewById(R.id.familia57);
        familia58 = (CheckBox) view.findViewById(R.id.familia58);
        familia59 = (CheckBox) view.findViewById(R.id.familia59);
        familia60 = (CheckBox) view.findViewById(R.id.familia60);
        familia61 = (CheckBox) view.findViewById(R.id.familia61);
        familia62 = (CheckBox) view.findViewById(R.id.familia62);
        familia63 = (CheckBox) view.findViewById(R.id.familia63);
        familia64 = (CheckBox) view.findViewById(R.id.familia64);
        familia65 = (CheckBox) view.findViewById(R.id.familia65);
        familia66 = (CheckBox) view.findViewById(R.id.familia66);
        familia67 = (CheckBox) view.findViewById(R.id.familia67);
        familia68 = (CheckBox) view.findViewById(R.id.familia68);
        familia69 = (CheckBox) view.findViewById(R.id.familia69);
        familia70 = (CheckBox) view.findViewById(R.id.familia70);
        familia71 = (CheckBox) view.findViewById(R.id.familia71);
        familia72 = (CheckBox) view.findViewById(R.id.familia72);
        familia73 = (CheckBox) view.findViewById(R.id.familia73);
        familia74 = (CheckBox) view.findViewById(R.id.familia74);
        familia75 = (CheckBox) view.findViewById(R.id.familia75);
        familia76 = (CheckBox) view.findViewById(R.id.familia76);
        familia77 = (CheckBox) view.findViewById(R.id.familia77);
        familia78 = (CheckBox) view.findViewById(R.id.familia78);
        familia79 = (CheckBox) view.findViewById(R.id.familia79);
        familia80 = (CheckBox) view.findViewById(R.id.familia80);
        familia81 = (CheckBox) view.findViewById(R.id.familia81);
        familia82 = (CheckBox) view.findViewById(R.id.familia82);
        familia83 = (CheckBox) view.findViewById(R.id.familia83);
        familia84 = (CheckBox) view.findViewById(R.id.familia84);
        familia85 = (CheckBox) view.findViewById(R.id.familia85);
        familia86 = (CheckBox) view.findViewById(R.id.familia86);
        familia87 = (CheckBox) view.findViewById(R.id.familia87);
        familia88 = (CheckBox) view.findViewById(R.id.familia88);
        familia89 = (CheckBox) view.findViewById(R.id.familia89);
        familia90 = (CheckBox) view.findViewById(R.id.familia90);
        familia91 = (CheckBox) view.findViewById(R.id.familia91);
        familia92 = (CheckBox) view.findViewById(R.id.familia92);
        familia93 = (CheckBox) view.findViewById(R.id.familia93);
        familia94 = (CheckBox) view.findViewById(R.id.familia94);



        puntuacion = (EditText) view.findViewById(R.id.puntuacion);
        puntuacion.setVisibility(View.GONE);
        calcualr =(Button) view.findViewById(R.id.cal);

       // calcularzamora=(Button) view.findViewById(R.id.cal2);
        //calcualr.setEnabled(false);
        btnclavedictonica =(Button) view.findViewById(R.id.btnclavedictonica);
        btnlimpiar =(Button) view.findViewById(R.id.btnlimpiar);
        btncal2=(Button) view.findViewById(R.id.cal2);
        estadopuntuacion=(TextView) view.findViewById(R.id.estadopuntuacion);
        estadopuntuacion.setText("SU PUNTUACIÓN:\n");

        viewPager = getActivity().findViewById(R.id.viewpeger);



        btnclavedictonica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                puntuacion.setText("0");
                familia1.setChecked(false);
                familia2.setChecked(false);
                familia3.setChecked(false);
                familia4.setChecked(false);
                familia5.setChecked(false);
                familia6.setChecked(false);
                familia7.setChecked(false);
                familia8.setChecked(false);
                familia9.setChecked(false);
                familia10.setChecked(false);
                familia11.setChecked(false);
                familia12.setChecked(false);
                familia13.setChecked(false);
                familia14.setChecked(false);
                familia15.setChecked(false);
                familia16.setChecked(false);
                familia17.setChecked(false);
                familia18.setChecked(false);
                familia19.setChecked(false);
                familia20.setChecked(false);
                familia21.setChecked(false);
                familia22.setChecked(false);
                familia23.setChecked(false);
                familia24.setChecked(false);
                familia25.setChecked(false);
                familia26.setChecked(false);
                familia27.setChecked(false);
                familia28.setChecked(false);
                familia29.setChecked(false);
                familia30.setChecked(false);
                familia31.setChecked(false);
                familia32.setChecked(false);
                familia33.setChecked(false);
                familia34.setChecked(false);
                familia35.setChecked(false);
                familia36.setChecked(false);
                familia37.setChecked(false);
                //familia38.setChecked(false);
                familia39.setChecked(false);
                familia40.setChecked(false);
                familia41.setChecked(false);
                familia42.setChecked(false);
                familia43.setChecked(false);
                familia44.setChecked(false);
                familia45.setChecked(false);
                familia46.setChecked(false);
                familia47.setChecked(false);
                familia48.setChecked(false);
                familia49.setChecked(false);
                familia50.setChecked(false);
                familia51.setChecked(false);
                familia52.setChecked(false);
                familia53.setChecked(false);
                familia54.setChecked(false);
                familia55.setChecked(false);
                familia56.setChecked(false);
                familia57.setChecked(false);
                familia58.setChecked(false);
                familia59.setChecked(false);
                familia60.setChecked(false);
                familia61.setChecked(false);
                familia62.setChecked(false);
                familia63.setChecked(false);
                familia64.setChecked(false);
                familia65.setChecked(false);
                familia66.setChecked(false);
                familia67.setChecked(false);
                familia68.setChecked(false);
                familia69.setChecked(false);
                familia70.setChecked(false);
                familia71.setChecked(false);
                familia72.setChecked(false);
                familia73.setChecked(false);
                familia74.setChecked(false);
                familia75.setChecked(false);
                familia76.setChecked(false);
                familia77.setChecked(false);
                familia78.setChecked(false);
                familia79.setChecked(false);
                familia80.setChecked(false);
                familia81.setChecked(false);
                familia82.setChecked(false);
                familia83.setChecked(false);
                familia84.setChecked(false);
                familia85.setChecked(false);
                familia86.setChecked(false);
                familia87.setChecked(false);
                familia88.setChecked(false);
                familia89.setChecked(false);
                familia90.setChecked(false);
                familia91.setChecked(false);
                familia92.setChecked(false);
                familia93.setChecked(false);
                familia94.setChecked(false);


                btncal2.setEnabled(true);
                calcualr.setEnabled(true);
                estadopuntuacion.setBackgroundColor(Color.parseColor("#A0D468"));


            }
        });

        puntuacion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                valor= puntuacion.getText().toString();
                estadopuntuacion.setText(valor);
                SharedPreferences preferences = getActivity().getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("bmwprol",valor);
                editor.commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        ///////////////////////////////Calculo de índice BMWP/Col ///////////////////////////////////////////////////////
        calcualr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                ////////////////////////variable inicial en 0 ///////////////////////////////////
                if (familia1.isChecked()) {
                    valoracu+=-9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia2.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia3.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia4.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia5.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia6.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia7.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia8.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia9.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia10.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia11.isChecked()) {
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia12.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia13.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia14.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia15.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia16.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia17.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia18.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia19.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia20.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia21.isChecked()) {
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia22.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia23.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia24.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia25.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia26.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia27.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia28.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia29.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia30.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia31.isChecked()) {
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia32.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia33.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia34.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia35.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia36.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia37.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                //if (familia38.isChecked()){
                    //valoracu+=6;
                    //String res = String.valueOf(valoracu);
                    //puntuacion.setText(res);
                //}
                if (familia39.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia40.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia41.isChecked()) {
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia42.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia43.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia44.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia45.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia46.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia47.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia48.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia49.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia50.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia51.isChecked()) {
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia52.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia53.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia54.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia55.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia56.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia57.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia58.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia59.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia60.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia61.isChecked()) {
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia62.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia63.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia64.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia65.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia66.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia67.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia68.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia69.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia70.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia71.isChecked()) {
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia72.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia73.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia74.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia75.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia76.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia77.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia78.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia79.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia80.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia1.isChecked()) {
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia82.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia83.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia84.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia85.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia86.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia87.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia88.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia89.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia90.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia91.isChecked()) {
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia92.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia93.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia94.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                btncal2.setEnabled(false);
                calcualr.setEnabled(false);
////////////////////////////validaciones indicadores de color/////////////////////////////////////////////////
                if (valoracu<15){
                    // rojo muy critico
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#f44336"));
                }if((valoracu>16)&&( valoracu <35)){
                    //naranja critico
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#ff9800"));
                }if((valoracu>26)&&( valoracu <60)){
                    //amarillo dudoso
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#ffeb3b"));
                }if((valoracu>61)&&( valoracu <100)){
                    //verde aceptable
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#009688"));
                }if((valoracu>101)&&( valoracu <150)){
                    //azul buena
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#03a9f4"));
                }

                ///////////////////////////////////guardar datos en el telfono//////////////////////////
                SharedPreferences preferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
                String rodal=estadopuntuacion.getText().toString();;
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("roldan",rodal);
                editor.commit();
            }

        });


        btncal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////////////////////////variable inicial en 0 ///////////////////////////////////
                int valoracu =Integer.parseInt(puntuacion.getText().toString());
                if (familia1.isChecked()) {
                    valoracu+=-9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia2.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia3.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia4.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia5.isChecked()){
                    valoracu+=2;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia6.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia7.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia8.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia9.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia10.isChecked()){
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia11.isChecked()) {
                    valoracu+=3;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia12.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia13.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia14.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia15.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia16.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia17.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia18.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia19.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia20.isChecked()){
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia21.isChecked()) {
                    valoracu+=4;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia22.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia23.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia24.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia25.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia26.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia27.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia28.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia29.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia30.isChecked()){
                    valoracu+=5;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia31.isChecked()) {
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia32.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia33.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia34.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia35.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia36.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia37.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                //if (familia38.isChecked()){
                //valoracu+=6;
                //String res = String.valueOf(valoracu);
                //puntuacion.setText(res);
                //}
                if (familia39.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia40.isChecked()){
                    valoracu+=6;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia41.isChecked()) {
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia42.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia43.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia44.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia45.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia46.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia47.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia48.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia49.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia50.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia51.isChecked()) {
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia52.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia53.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia54.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia55.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia56.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia57.isChecked()){
                    valoracu+=7;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia58.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia59.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia60.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia61.isChecked()) {
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia62.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia63.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia64.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia65.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia66.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia67.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia68.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia69.isChecked()){
                    valoracu+=8;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia70.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia71.isChecked()) {
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia72.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia73.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia74.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia75.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia76.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia77.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia78.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia79.isChecked()){
                    valoracu+=9;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia80.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia1.isChecked()) {
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia82.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia83.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia84.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia85.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia86.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia87.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia88.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia89.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia90.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia91.isChecked()) {
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia92.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia93.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                if (familia94.isChecked()){
                    valoracu+=10;
                    String res = String.valueOf(valoracu);
                    puntuacion.setText(res);
                }
                btncal2.setEnabled(false);
                calcualr.setEnabled(false);
////////////////////////////validaciones indicadores de color/////////////////////////////////////////////////
                if (valoracu<15){
                    // rojo muy critico
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#f44336"));
                }if((valoracu>16)&&( valoracu <35)){
                    //naranja critico
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#ff9800"));
                }if((valoracu>26)&&( valoracu <60)){
                    //amarillo dudoso
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#ffeb3b"));
                }if((valoracu>61)&&( valoracu <100)){
                    //verde aceptable
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#009688"));
                }if((valoracu>101)&&( valoracu <150)){
                    //azul buena
                    estadopuntuacion.setBackgroundColor(Color.parseColor("#03a9f4"));
                }


                ///////////////////////////////////guardar datos en el telfono//////////////////////////
                SharedPreferences preferences = getContext().getSharedPreferences("datos", Context.MODE_PRIVATE);
                String zamora=estadopuntuacion.getText().toString();;
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("zamora",zamora);
                editor.commit();

            }
        });


        return view;

    }

}

