package com.example.myart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mFirebaseAuth = FirebaseAuth.getInstance();

        SystemClock.sleep(3000);
        Intent registerIntent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(registerIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();

        if (currentUser == null) {
            Intent mainIntent = new Intent(SplashActivity.this,  MainActivity.class);
            startActivity(mainIntent);
            finish();

        }else {

        }
    }
}