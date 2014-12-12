package com.jerry.materialcolors.com.jerry.materialcolors.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jerry.materialcolors.DrawerActivity;

/**
 * Created by zm on 13/12/2014.
 */
public class NavDrawerClick implements ListView.OnItemClickListener {

    private Context context;
    private Activity act1;

    public NavDrawerClick(Activity act1, Context context){
        this.context = context;
        this.act1 = act1;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        goToNavDrawerItem(position);
    }

    private void goToNavDrawerItem(int item){
        Intent intent;
        switch(item){
            case 0:
                intent = new Intent(context, DrawerActivity.class);
                context.startActivity(intent);
                act1.finish();
                break;
        }
    }
}
