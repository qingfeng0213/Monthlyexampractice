package com.example.monthlyexampractice;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.monthlyexampractice.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView animation;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = findViewById(R.id.animation);

        ObjectAnimator translationY = ObjectAnimator.ofFloat(animation, "translationY", animation.getTranslationY(), 800);
        //动画时间
        translationY.setDuration(3000);
        //动画开始
        translationY.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}
