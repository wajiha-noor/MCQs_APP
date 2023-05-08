package com.example.assignment2;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class Splash extends AppCompatActivity {
    ProgressBar pb1;
    LottieAnimationView lav;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pb1=(ProgressBar) findViewById(R.id.progressBar2);
        tv=(TextView)findViewById(R.id.percent);
        lav=(LottieAnimationView)findViewById(R.id.car);
        Animation a= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        lav.setAnimation(a);
        Thread th = new Thread(){
            @Override
            public void run() {
                try {
                    for (int i=0; i<=100; i++) {
                        if(i<50)
                        {
                            sleep(40);
                            String s=Integer.toString(i);
                            tv.setText(s+"%");
                            pb1.setProgress(i);
                        }
                        else{
                            sleep(60);
                            String s=Integer.toString(i);
                            tv.setText(s+"%");
                            pb1.setProgress(i);
                        }

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            };
        th.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);

                startActivity(i);
                finish();
            }
        }, 5000);

    }
}