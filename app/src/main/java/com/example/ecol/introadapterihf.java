package com.example.ecol;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class introadapterihf extends FragmentPagerAdapter {

    public introadapterihf(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fragment_rapidos_sedimentos();
            case 1:
                return  new fragment_frecuencia_rapidos();
            case 2:
                return  new fragment_composicion_sustrato();
            case 3:
                return  new fragment_regimen_de_velocidad();
            case 4:
                return  new fragment_procentaje_sombra();
            case 5:
                return  new fragment_elementos_heteronegialidad();
            case 6:
                return  new fragment_cobertura_vegetacion_acuatica();
            case 7:
                return  new ragment_ihf_resultados();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 8;
    }
}
