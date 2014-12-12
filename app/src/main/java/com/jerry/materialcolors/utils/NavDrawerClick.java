package com.jerry.materialcolors.utils;

import android.app.Activity;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jerry.materialcolors.R;
import com.jerry.materialcolors.fragments.BlankFragment2;

public class NavDrawerClick implements ListView.OnItemClickListener {

    private Context context;
    private Activity act1;

    public NavDrawerClick(Activity act1, Context context){
        this.context = context;
        this.act1 = act1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    private void selectItem(int position){
    }
}
