package com.example.myart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ResetPasswordFragment extends Fragment {


    public ResetPasswordFragment() {

    }

    private FrameLayout parentFramelayout;

    private EditText registeredEmail;
    private Button resetPasswordBtn;
    private TextView goBack;

    private ViewGroup emailIconContainer;
    private ImageView emailIcon;
    private TextView emailText;
    private ProgressBar mProgressBar;

    private FirebaseAuth mFirebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);

        registeredEmail = view.findViewById(R.id.forgot_pass_email);

        mFirebaseAuth = FirebaseAuth.getInstance();

        resetPasswordBtn = view.findViewById(R.id.reset_pass_btn);
        goBack = view.findViewById(R.id.fotgot_pass_goback);

        emailIconContainer = view.findViewById(R.id.forgot_pass_email_icon_container);
        emailIcon = view.findViewById(R.id.forgot_pass_email_icon);
        emailText = view.findViewById(R.id.forgot_pass_email_text);
        mProgressBar = view.findViewById(R.id.forgot_email_progressbar);

        parentFramelayout = getActivity().findViewById(R.id.register_framelayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        registeredEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkinputs();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        resetPasswordBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(emailIconContainer);
                emailIcon.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.VISIBLE);
                emailText.setVisibility(View.GONE);

                resetPasswordBtn.setEnabled(false);
                resetPasswordBtn.setTextColor(Color.argb(50, 255, 255, 255));
                mFirebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    ScaleAnimation scaleAnimation = new ScaleAnimation(1,0,1,0);
                                    scaleAnimation.setDuration(100);
                                    scaleAnimation.setInterpolator(new AccelerateInterpolator());
                                    scaleAnimation.setRepeatMode(Animation.REVERSE);
                                    scaleAnimation.setRepeatCount(1);
                                    scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                                        @Override
                                        public void onAnimationStart(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationEnd(Animation animation) {

                                        }

                                        @Override
                                        public void onAnimationRepeat(Animation animation) {

                                        }
                                    });

                                    emailIcon.startAnimation(scaleAnimation);
                                    Toast.makeText(getActivity(), "Письмо успешно отправлено!", Toast.LENGTH_SHORT).show();

                                } else {
                                    String error = task.getException().getMessage();
                                    resetPasswordBtn.setEnabled(true);
                                    resetPasswordBtn.setTextColor(Color.rgb(255, 255, 255));

                                    TransitionManager.beginDelayedTransition(emailIconContainer);
                                    emailText.setVisibility(View.VISIBLE);
                                    emailText.setText(error);

                                    emailIcon.setVisibility(View.VISIBLE);
                                }
                                mProgressBar.setVisibility(View.GONE);


                            }
                        });


            }
        });



        goBack.setOnClickListener(v -> setFragment(new SignInFragment()));
    }

    private void checkinputs() {
        if (TextUtils.isEmpty(registeredEmail.getText())) {
            resetPasswordBtn.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.argb(50, 255, 255, 255));

        } else {
            resetPasswordBtn.setEnabled(true);
            resetPasswordBtn.setTextColor(Color.rgb(255, 255, 255));


        }
    }


    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);

        fragmentTransaction.replace(parentFramelayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}