package com.example.ecol;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import maes.tech.intentanim.CustomIntent;

public class cuantitativo extends Fragment {


    public cuantitativo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =inflater.inflate(R.layout.fragment_cuantitativo, container, false);
        Button btnregresar = (Button) view.findViewById(R.id.btnregresarestudios1);
        btnregresar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ////////////////inten de fragment a activity///////////////////////////////////
                Intent intent = new Intent(getActivity(),tipo_de_estudios.class);
                startActivity(intent);
                CustomIntent.customType(requireActivity(),"fadein-to-fadeout");

            }
        });
        return view;
    }

}
