package com.jerry.materialcolors.utils;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

/**
 * Created by zm on 6/12/2014.
 */
public class FABClickListener implements FloatingActionButton.OnClickListener{

    Context context;

    public FABClickListener(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context,"Hello World!",Toast.LENGTH_SHORT).show();
    }
}
