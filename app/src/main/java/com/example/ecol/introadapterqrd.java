package com.example.ecol;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class introadapterqrd extends FragmentPagerAdapter {

    public introadapterqrd(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragment_grado_cubierta();
            case 1:
                return  new fragment_estructura_cubierta();
            case 2:
                return  new fragment_Calidad_cubierta();
            case 3:
                return  new fragment_grado_naturalidad();
            case 4:
                return  new fragment_resultados_qbr();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}