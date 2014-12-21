package com.jerry.materialcolors.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jerry.materialcolors.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFoodFragment extends DialogFragment {

    private Button okButton;
    private Button cancelButton;
    private EditText foodName;
    private EditText foodDesc;

    private Fragment frag;

    public AddFoodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_food, container, false);
        getDialog().setTitle("Add Food");

        foodName = (EditText) v.findViewById(R.id.food_edittext);
        foodDesc = (EditText) v.findViewById(R.id.fooddesc_edittext);

        okButton = (Button) v.findViewById(R.id.dialog_ok_button);
        okButton.setOnClickListener(new okListener());


        cancelButton = (Button) v.findViewById(R.id.dialog_cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return v;
    }


    private class okListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            EditNameDialogListener activity = (EditNameDialogListener) getActivity();
            activity.onFinishEditDialog(foodName.getText().toString(),foodDesc.getText().toString());
            dismiss();

        }
    }

    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText, String inputText2);
    }


}
