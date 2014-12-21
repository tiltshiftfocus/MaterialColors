package com.jerry.materialcolors.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jerry.materialcolors.R;
import com.jerry.materialcolors.adapter.FoodAdapter;
import com.jerry.materialcolors.utils.Food;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    final private int DIALOG_REQUEST = 0;

    private FoodAdapter mAdapter;
    private RecyclerView mList;
    private FloatingActionButton fab;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        // Init list with food
        List<Food> foodList = new ArrayList();
        initFoodList(foodList);


        // Init RecyclerView
        mList = (RecyclerView) v.findViewById(R.id.recycler_view);
        mList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(llm);

        // Set Adapter
        mAdapter = new FoodAdapter(foodList);
        mList.setAdapter(mAdapter);

        // Init Floating Action Button
        fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.attachToRecyclerView(mList);
        fab.setOnClickListener(new fabClick());

        return v;
    }

    private class fabClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Food thisisFood = new Food("testFood", "Sorry, this is inedible food.");
            mAdapter.add(thisisFood, mAdapter.getItemCount());

        }
    }

    public void initFoodList(List<Food> foodList) {
        foodList.add(new Food("Bread","The best food in the morning for source of energy."));
        foodList.add(new Food("Chicken","PROTEIN?!"));
        foodList.add(new Food("Cake","Fat die you."));
    }
}
