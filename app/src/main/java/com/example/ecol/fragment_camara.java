package com.example.ecol;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class fragment_camara extends Fragment {
     Button camara,buscar;
     ImageView imageView;
     EditText editTextName;
     Bitmap bitmap;
     int PICK_IMAGE_REQUEST = 1;
     String UPLOAD_URL ="https://serverandrofast.webcindario.com/upload.php";
     String KEY_IMAGEN = "foto";
     String KEY_NOMBRE = "nombre";

    public fragment_camara() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fragment_camara, container, false);
        camara = (Button) view.findViewById(R.id.abrircamara);
        buscar = (Button) view.findViewById(R.id.subir);
        editTextName = (EditText) view.findViewById(R.id.editText);
        imageView  = (ImageView) view.findViewById(R.id.imageView);

        return view;
    }

}
