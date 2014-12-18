package com.jerry.materialcolors.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jerry.materialcolors.R;
import com.jerry.materialcolors.utils.Food;

import java.util.List;

/**
 * Created by Jerry on 19/12/2014.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {
    List<Food> foodList;

    public FoodAdapter(List<Food> foodList){
        this.foodList = foodList;
    }


    @Override
    public FoodHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list,parent,false);
        return new FoodHolder(v);
    }

    @Override
    public void onBindViewHolder(FoodHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodName.setText(food.getName());
        holder.foodDesc.setText(food.getDesc());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public void add(Food item, int position) {
        foodList.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(Food item) {
        int position = foodList.indexOf(item);
        foodList.remove(position);
        notifyItemRemoved(position);
    }

    public class FoodHolder extends RecyclerView.ViewHolder {

        private TextView foodName;
        private TextView foodDesc;

        public FoodHolder(View itemView) {
            super(itemView);
            foodName = (TextView) itemView.findViewById(R.id.card_tv1);
            foodDesc = (TextView) itemView.findViewById(R.id.card_tv2);
        }
    }
}
