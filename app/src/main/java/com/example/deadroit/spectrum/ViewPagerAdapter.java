package com.example.deadroit.spectrum;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Deadroit on 1/16/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    final Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = Fragment_One.newInstance();
                break;
            case 1:
                fragment = Fragment_Two.newInstance();
                break;
            case 2:
                fragment = Fragment_Three.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}