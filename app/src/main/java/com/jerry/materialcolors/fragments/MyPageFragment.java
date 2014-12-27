package com.jerry.materialcolors.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jerry.materialcolors.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends Fragment {


    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final MyPageFragment newInstance(String message) {
        MyPageFragment f = new MyPageFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }




    public MyPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.fragment_my_page, container, false);
        TextView messageTextView = (TextView) v.findViewById(R.id.pager_TextView1);
        messageTextView.setText(message);

        return v;
    }


}
