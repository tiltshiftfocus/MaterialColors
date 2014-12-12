package com.jerry.materialcolors.utils;

import android.app.Activity;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jerry.materialcolors.R;
import com.jerry.materialcolors.fragments.BlankFragment2;

public class NavDrawerClick implements ListView.OnItemClickListener {

    private Context context;
    private Activity act1;
    private String[] array1;

    public NavDrawerClick(String[] array1, Activity act1, Context context){
        this.array1 = array1;
        this.context = context;
        this.act1 = act1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(context, array1[position] + " is selected",Toast.LENGTH_SHORT).show();
        //selectItem(position);
    }

    private void selectItem(int position){
    }
}
