package com.shitab14.videoplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView logo;

    Animation intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.logo);
        intro= AnimationUtils.loadAnimation(this,R.anim.intro_animation);

        logo.startAnimation(intro);

        final Intent i = new Intent(this, VideoPlayerActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }
}
