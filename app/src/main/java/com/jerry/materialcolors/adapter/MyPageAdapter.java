package com.jerry.materialcolors.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Jerry on 27/12/2014.
 */
public class MyPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public MyPageAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int i) {
        return this.fragments.get(i);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;
        return "Page " + position;
    }
}
