package com.example.finaltutorialapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finaltutorialapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DifferFragment extends Fragment {

    public DifferFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_differ, container, false);


    }
}
