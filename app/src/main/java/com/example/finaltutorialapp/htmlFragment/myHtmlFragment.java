package com.example.finaltutorialapp.htmlFragment;

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
    private TextView htmlTag;
    private TextView txtElement;
    private TextView txtAttribute;
    private TextView txtFormat;
    private TextView txtPhrase;
    private TextView txtMeta;
    private TextView txtComment;
    private TextView txtImage;
    private TextView txtTable;
    private TextView txtList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_html, container, false);

        parentFrameLayout = getActivity().findViewById(R.id.main_framelayout);

        htmlIntro = view.findViewById(R.id.html_intro);
        htmlTag = view.findViewById(R.id.tag);
        txtElement = view.findViewById(R.id.element);
        txtAttribute = view.findViewById(R.id.attribute);
        txtFormat = view.findViewById(R.id.format);
        txtPhrase = view.findViewById(R.id.phrase);
        txtMeta = view.findViewById(R.id.metaTag);
        txtComment = view.findViewById(R.id.Comment);
        txtImage = view.findViewById(R.id.images);
        txtTable = view.findViewById(R.id.table);
        txtList = view.findViewById(R.id.list);





        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new FormatingFragment());
            }
        });

        txtTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new TableFragment());
            }
        });


        txtList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ListsFragment());
            }
        });


        txtImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ImagesFragment());
            }
        });
        txtComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new CommentsFragment());
            }
        });
        txtMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new MetaFragment());
            }
        });

        htmlIntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new IntroFragment());

            }
        });

        htmlTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new HtmlTagFragment());
            }
        });
        txtElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new ElementFragment());
            }
        });

        txtAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFragment(new AttributeFragment());
            }
        });

        txtPhrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new PhraseFragment());
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
