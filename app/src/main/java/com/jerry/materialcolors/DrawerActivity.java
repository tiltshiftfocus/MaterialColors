package com.jerry.materialcolors;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jerry.materialcolors.fragments.NavigationDrawerFragment;


public class DrawerActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private String PACKAGE_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = this.getPackageName();
        setThemeOnStart();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_toolbar);


        // Set Support Toolbar
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.nav_drawer1);
        drawerFragment.setUp(R.id.nav_drawer1, (DrawerLayout) findViewById(R.id.drawer_layout1), toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setThemeOnStart() {
        SharedPreferences pref = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);

        switch (pref.getInt("theme", 0)) {
            case 0:
                setTheme(R.style.AppTheme);
                break;
            case 1:
                setTheme(R.style.AppTheme_Pink);
                break;
            case 2:
                setTheme(R.style.AppTheme_Purple);
                break;
            case 3:
                setTheme(R.style.AppTheme_DPurple);
                break;
            case 4:
                setTheme(R.style.AppTheme_Indigo);
                break;
            default:
                break;
        }
    }
}
