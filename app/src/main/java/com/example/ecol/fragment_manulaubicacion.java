package com.example.ecol;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragment_manulaubicacion extends Fragment {


    public fragment_manulaubicacion() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista =  inflater.inflate(R.layout.fragment_fragment_manulaubicacion, container, false);

        return vista;
    }

}
