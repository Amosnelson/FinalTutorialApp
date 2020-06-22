package com.example.finaltutorialapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.finaltutorialapp.R;
import com.example.finaltutorialapp.htmlFragment.IntroFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class myHtmlFragment extends Fragment {

    public myHtmlFragment() {
        // Required empty public constructor
    }
    private FrameLayout parentFrameLayout;
    private TextView htmlIntro;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_html, container, false);

        parentFrameLayout = getActivity().findViewById(R.id.main_framelayout);

        htmlIntro = view.findViewById(R.id.html_intro);




        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        htmlIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new IntroFragment());

            }
        });
    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slidepout_from_right );
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
