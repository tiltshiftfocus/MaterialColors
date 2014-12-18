package com.jerry.materialcolors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    private String PACKAGE_NAME;
    private Toolbar toolbar;
    private Spinner spinnerColors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = this.getPackageName();
        setThemeOnStart();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        spinnerColors = (Spinner) findViewById(R.id.spinnerColors);
        spinnerColors.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColors.setAdapter(adapter);

        // Set current Theme from sharedPreference
        SharedPreferences sharedpreferences = getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);
        int selection = sharedpreferences.getInt("theme",0);
        spinnerColors.setSelection(selection);


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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        SharedPreferences pref = this.getSharedPreferences(PACKAGE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        switch (i) {
            case 0:
                edit.putInt("theme", 0);
                edit.commit();
                break;
            case 1:
                edit.putInt("theme", 1);
                edit.commit();
                break;
            case 2:
                edit.putInt("theme", 2);
                edit.commit();
                break;
            case 3:
                edit.putInt("theme", 3);
                edit.commit();
                break;
            case 4:
                edit.putInt("theme", 4);
                edit.commit();
                break;
            default:
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void reCreate(View view) {
        this.recreate();
    }

    public void openFAB(View view) {
        Intent i = new Intent(MainActivity.this, FABActivity.class);
        startActivity(i);

    }

    public void circularImageView(View v){
        Intent i = new Intent(MainActivity.this, CircularImage.class);
        startActivity(i);
    }

    public void launchFragmentAct(View v){
        Intent i = new Intent(MainActivity.this, FragmentActivity.class);
        startActivity(i);
    }

    public void openDrawerLayout(View v){
        Intent i = new Intent(MainActivity.this, DrawerActivity.class);
        startActivity(i);
    }

    public void openCardListView(View v){
        Intent i = new Intent(MainActivity.this, CardRecyclerView.class);
        startActivity(i);
    }
}
