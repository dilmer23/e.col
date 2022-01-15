package com.example.ecol;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import maes.tech.intentanim.CustomIntent;


public class userdatos extends Fragment {
    ImageView cerrar;

    public userdatos() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_userdatos, container, false);
        cerrar =(ImageView)  view.findViewById(R.id.cerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),bienvenido.class);
                startActivity(intent);
                CustomIntent.customType(requireActivity(),"fadein-to-fadeout");
            }
        });


        return view;
    }

}
