package com.jerry.materialcolors;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jerry.materialcolors.adapter.MyPageAdapter;
import com.jerry.materialcolors.fragments.MyPageFragment;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerActivity extends ActionBarActivity {

    private String PACKAGE_NAME;

    private Toolbar toolbar;
    private MyPageAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = this.getPackageName();
        setThemeOnStart();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<Fragment> fragments = getFragments();
        mPageAdapter = new MyPageAdapter(getSupportFragmentManager(),fragments);
        ViewPager mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setAdapter(mPageAdapter);

    }


    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<>();

        fList.add(MyPageFragment.newInstance("Fragment 1"));
        fList.add(MyPageFragment.newInstance("Fragment 2"));
        fList.add(MyPageFragment.newInstance("Fragment 3"));

        return fList;
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



}
