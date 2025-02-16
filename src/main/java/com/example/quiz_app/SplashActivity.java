package com.example.quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;

public class SplashActivity extends AppCompatActivity {
    ShapeableImageView iv_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

        Animation fadeIn= AnimationUtils.loadAnimation(this,R.anim.fade_in);
        iv_logo.startAnimation(fadeIn);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);

    }
    public void init(){
        iv_logo=findViewById(R.id.iv_logo);
    }
}
