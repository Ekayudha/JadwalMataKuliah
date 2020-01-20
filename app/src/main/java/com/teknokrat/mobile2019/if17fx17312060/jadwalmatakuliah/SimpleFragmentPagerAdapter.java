package com.teknokrat.mobile2019.if17fx17312060.jadwalmatakuliah;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FragmentSenin();
        } else if (position == 1){
            return new FragmentSelasa();
        } else if (position == 2) {
            return new FragmentRabu();
        } else if (position == 3) {
            return new FragmentKamis();
        } else
            return new FragmentJumat();
        }


    @Override
    public int getCount() {
        return 5;
    }
}