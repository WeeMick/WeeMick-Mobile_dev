package com.example.soundpoolbuilderdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    SoundPool mySounds;
    int s1;
    int s2;
    AudioAttributes audioAttributes;
    View.OnClickListener h = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mySounds.play (s1, 1.0f, 1.0f, 1, 0, 1);
            mySounds.play (s2, 1.0f, 1.0f, 1, 0, 1);
        }
    };
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //code greater or equal to API 21 (lollipop)

            audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            mySounds = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }
        else {
            mySounds = new SoundPool(2, AudioManager.STREAM_MUSIC, 1);
        }
        s1 = mySounds.load(this, R.raw.cat, 1);
        s2 = mySounds.load(this, R.raw.dog, 1);

        b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(h);
    }
}
