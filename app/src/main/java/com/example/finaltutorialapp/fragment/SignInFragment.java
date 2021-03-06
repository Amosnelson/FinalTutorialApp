package com.example.finaltutorialapp.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.finaltutorialapp.MainActivity;
import com.example.finaltutorialapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.finaltutorialapp.RegisterActivity.onResetPasswordFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {


    public SignInFragment() {
        // Required empty public constructor
    }

    private TextView dontHaveAnAccount,forgotPassword;
    private FrameLayout parentFrameLayout;
    private EditText password,email;
    private ImageButton closeBtn;
    private Button signInBtn;
    private FirebaseAuth firebaseAuth;
    private String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private ProgressBar progressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        dontHaveAnAccount = view.findViewById(R.id.already_have_acct);
        parentFrameLayout  = getActivity().findViewById(R.id.register_framelayout);

        closeBtn = view.findViewById(R.id.sign_up_close);
        email = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sign_in_password);
        signInBtn = view.findViewById(R.id.sign_up_btn);
        progressBar = view.findViewById(R.id.sign_up_progressBar);
        forgotPassword = view.findViewById(R.id.sign_in_forgot_password);


        firebaseAuth = FirebaseAuth.getInstance();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dontHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                setFragment( new SignUpFragment());
            }
        });
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onResetPasswordFragment=true ;
                setFragment(new ResetPasswordFragment());
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmailAndPassword();
            }
        });
    }

    private void checkEmailAndPassword() {

        if (email.getText().toString().matches(emailPattern)){

            if (password.length()>=8)
            {
                progressBar.setVisibility(View.VISIBLE);
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(50,255,255,255));

                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()){
                                    mainIntent();

                                }else {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    signInBtn.setEnabled(false);
                                    signInBtn.setTextColor(Color.rgb(255,255,255));

                                    String error = task.getException().getMessage();
                                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            } else{
                Toast.makeText(getActivity(),"Incorrect email or password!",Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(getActivity(),"Incorrect email or password!",Toast.LENGTH_LONG).show();


        }


    }

    private void checkInputs() {
        if (!TextUtils.isEmpty(email.getText()))
        {
            if (!TextUtils.isEmpty(password.getText())){

                signInBtn.setEnabled(true);
                signInBtn.setTextColor(Color.rgb(255,255,255));


            }  else{
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(50,255,255,255));



            }
        }else
        {
            signInBtn.setEnabled(false);
            signInBtn.setTextColor(Color.argb(50,255,255,255));



        }
    }

    private void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slidepout_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }


    private void mainIntent(){
        Intent mainintent = new Intent(getActivity(), MainActivity.class);
        startActivity(mainintent);
        getActivity().finish();

    }
}
