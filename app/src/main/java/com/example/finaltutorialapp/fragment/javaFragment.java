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

/**
 * A simple {@link Fragment} subclass.
 */
public class javaFragment extends Fragment {

    public javaFragment() {
        // Required empty public constructor
    }
    private FrameLayout parentFrameLayout;
    private TextView intro;
    private TextView oopJava;
    private TextView javabasic;
    private TextView workingObj;
    private TextView arraytxt;
    private TextView txtxclass;
    private TextView txtMore;
    private TextView txtApplet;
    private TextView txtGraph;
    private TextView txtAnime;
    private TextView txtmoreAnim;
    private TextView txtmanage;
    private TextView txtabstract;
    private TextView txttidbits;
    private TextView txtmodifier;
    private TextView txtpackages;
    private TextView txtExcepyion;
    private TextView txtMulti;
    private TextView txtDiffer;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_java, container, false);

        parentFrameLayout = getActivity().findViewById(R.id.main_framelayout);
        intro = view.findViewById(R.id.html_intro);
        oopJava = view.findViewById(R.id.tag);
        javabasic = view.findViewById(R.id.element);
        workingObj = view.findViewById(R.id.attribute);
        arraytxt = view.findViewById(R.id.format);
        txtxclass = view.findViewById(R.id.phrase);
        txtMore = view.findViewById(R.id.metaTag);
        txtApplet = view.findViewById(R.id.Comment);
        txtGraph = view.findViewById(R.id.images);
        txtAnime = view.findViewById(R.id.table);
        txtmoreAnim = view.findViewById(R.id.list);
        txtmanage = view.findViewById(R.id.quick);
        txtabstract = view.findViewById(R.id.useful);
        txttidbits = view.findViewById(R.id.discussion);
        txtmodifier = view.findViewById(R.id.txtmodifiers);
        txtpackages = view.findViewById(R.id.packages);
        txtExcepyion = view.findViewById(R.id.exceptiion);
        txtMulti = view.findViewById(R.id.multi);
        txtDiffer = view.findViewById(R.id.def);








        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

intro.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        setFragment(new IntroFragment());

    }
});
        oopJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new javaoopFragment());
            }
        });

        javabasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new BasicFragment());
            }
        });

        arraytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new arrayFragment());
            }
        });

        workingObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new workingObjectFragment());
            }
        });

        txtxclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new classesAppFragment());
            }
        });

        txtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new moreAboutFragment() );
            }
        });
        txtApplet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new appletFragment());
            }
        });

        txtGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new GraphicFragment());
            }
        });
        txtAnime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new AnimeFragment());
            }
        });

        txttidbits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new TidbitsFragment());
            }
        });

        txtabstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new AbstractFragment());
            }
        });

        txtmoreAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new MoreAnimFragment());
            }
        });

        txtmanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new EventFragment());
            }
        });
        txtmodifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ModifiersFragment());
            }
        });

        txtpackages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new PackagesFragment());
            }
        });

        txtExcepyion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new ExceptionFragment());
            }
        });

        txtMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new MultithreadingFragment());
            }
        });

        txtDiffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new DifferFragment());
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
