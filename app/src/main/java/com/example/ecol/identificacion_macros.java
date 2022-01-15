package com.example.ecol;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import maes.tech.intentanim.CustomIntent;


public class identificacion_macros extends Fragment {


    public identificacion_macros() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view  =inflater.inflate(R.layout.fragment_identificacion_macros, container, false);
        Button btnregresar = (Button) view.findViewById(R.id.btnregresarestudios1);
        btnregresar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ////////////////inten de fragment a activity///////////////////////////////////
                Intent intent = new Intent(getActivity(),protocolo_de_campo.class);
                startActivity(intent);
                CustomIntent.customType(requireActivity(),"fadein-to-fadeout");

            }
        });
        return view;
    }

}
