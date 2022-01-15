package com.example.ecol;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class intoadapter extends FragmentPagerAdapter {

    public intoadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new primerobiologico();
            case 1:
                return  new segundobiologico();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
