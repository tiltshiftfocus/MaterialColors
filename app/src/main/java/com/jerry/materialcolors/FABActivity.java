package com.jerry.materialcolors;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jerry.materialcolors.utils.FABClickListener;
import com.melnykov.fab.FloatingActionButton;


public class FABActivity extends ActionBarActivity {
    private String PACKAGE_NAME;

    private String[] foodArray;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = this.getPackageName();
        setThemeOnStart();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodArray = getApplicationContext().getResources().getStringArray(R.array.food);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.items_list, foodArray);


        ListView listView = (ListView) findViewById(R.id.list1);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(listView);
        fab.setOnClickListener(new FABClickListener(this));
    }

    private void setThemeOnStart() {
        SharedPreferences pref = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);

        switch (pref.getInt("theme", 0)) {
            case 0:
                System.out.println(pref.getInt("theme", 0));
                setTheme(R.style.AppTheme);
                break;
            case 1:
                System.out.println(pref.getInt("theme", 0));
                setTheme(R.style.AppTheme_Pink);
                break;
            case 2:
                System.out.println(pref.getInt("theme", 0));
                setTheme(R.style.AppTheme_Purple);
                break;
            case 3:
                System.out.println(pref.getInt("theme", 0));
                setTheme(R.style.AppTheme_DPurple);
                break;
            case 4:
                System.out.println(pref.getInt("theme", 0));
                setTheme(R.style.AppTheme_Indigo);
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fab, menu);
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


        if (id == R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
