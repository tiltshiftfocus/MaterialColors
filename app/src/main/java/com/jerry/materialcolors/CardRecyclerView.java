package com.jerry.materialcolors;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.jerry.materialcolors.adapter.FoodAdapter;
import com.jerry.materialcolors.utils.Food;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class CardRecyclerView extends ActionBarActivity {

    private String PACKAGE_NAME;

    private Toolbar toolbar;
    private FoodAdapter mAdapter;
    private RecyclerView mList;
    private FloatingActionButton fab;
    private SwipeRefreshLayout mSwipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = this.getPackageName();
        setThemeOnStart();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler_view);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        List<Food> foodList = new ArrayList();
        initFoodList(foodList);

        mList = (RecyclerView) findViewById(R.id.recycler_view);
        mList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(llm);

        mAdapter = new FoodAdapter(foodList);
        mList.setAdapter(mAdapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToRecyclerView(mList);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food thisisFood = new Food("testFood", "Sorry, this is inedible food.");
                mAdapter.add(thisisFood, mAdapter.getItemCount());
            }
        });

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        mSwipeLayout.setColorSchemeColors(getResources().getColor(R.color.accent));
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new InitTask().execute();
            }
        });


    }

    public void initFoodList(List<Food> foodList) {
        foodList.add(new Food("Bread","The best food in the morning for source of energy."));
        foodList.add(new Food("Chicken","PROTEIN?!"));
        foodList.add(new Food("Cake","Fat die you."));
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

    private class InitTask extends AsyncTask<Void,Void,Void>{

        private List<Food> foodList;

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(),"Renewing...",Toast.LENGTH_SHORT).show();
            mAdapter.clearApplications();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            foodList = new ArrayList();
            initFoodList(foodList);
            mAdapter.setList(foodList);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mAdapter.notifyDataSetChanged();
            mSwipeLayout.setRefreshing(false);
            Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_SHORT).show();
            super.onPostExecute(aVoid);
        }
    }


}
