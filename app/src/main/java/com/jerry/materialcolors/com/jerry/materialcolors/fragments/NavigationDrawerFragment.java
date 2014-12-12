package com.jerry.materialcolors.com.jerry.materialcolors.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jerry.materialcolors.R;
import com.jerry.materialcolors.com.jerry.materialcolors.utils.NavDrawerClick;

public class NavigationDrawerFragment extends Fragment {

    final public static String PREFERENCES_FILE = "nav_drawer_pref";
    final public static String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private boolean mUserLearned;
    private boolean mFromSavedState;
    private View containerView;

    private String[] array1;
    private ListView lv1;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearned = Boolean.valueOf(readFromPref(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));

        if (savedInstanceState != null) {
            mFromSavedState = true;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

    // setUp() method:
    // it's like an onCreate() submethod for use with the Activity that contains the drawer layout
    public void setUp(int fragmentID, DrawerLayout drawer, Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentID);
        mDrawerLayout = drawer;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!mUserLearned) {
                    mUserLearned = true;
                    saveToPref(getActivity(), KEY_USER_LEARNED_DRAWER, mUserLearned + "");
                }
                getActivity().invalidateOptionsMenu();
                getActivity().setTitle("TEST");

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
                getActivity().setTitle(getText(R.string.title_activity_drawer));
            }

        };

        if (!mUserLearned && !mFromSavedState) {
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        // --- Show Hamburger Menu ---
        // Basically the ActionBarDrawerToggle
        // needs to sync with the drawer fragment itself
        // for animation, etc
        // which requires Runnable
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        array1 = getActivity().getResources().getStringArray(R.array.food);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.items_list, array1);
        lv1 = (ListView) getActivity().findViewById(R.id.navdrawer_listview1);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new NavDrawerClick(getActivity(),getActivity()));

    }

    public static void saveToPref(Context ctx, String settingName, String settingValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(settingName, settingValue);
        editor.apply();
    }

    public static String readFromPref(Context ctx, String settingName, String defaultValue) {
        SharedPreferences sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPref.getString(settingName, defaultValue);
    }

}
