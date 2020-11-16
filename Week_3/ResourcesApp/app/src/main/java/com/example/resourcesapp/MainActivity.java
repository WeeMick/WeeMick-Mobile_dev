package com.example.resourcesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton myImgBtn;
    MediaPlayer dogSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImgBtn = findViewById(R.id.puppyImgBtn);
        dogSound = MediaPlayer.create(this, R.raw.duck_quack);

        myImgBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dogSound.start();
            }
        });
    }
}