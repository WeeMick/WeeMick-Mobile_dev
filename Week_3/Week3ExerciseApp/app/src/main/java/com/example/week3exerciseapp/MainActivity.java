package com.example.week3exerciseapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton b1;
    MediaPlayer mp1;
    View.OnClickListener b1Handler = new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            mp1.start();
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (ImageButton) findViewById(R.id.bongoBtn);

        b1.setOnClickListener(b1Handler);
        mp1=MediaPlayer.create(this, R.raw.duck_quack);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Toast.makeText(MainActivity.this, "Item clicked: " + id, Toast.LENGTH_LONG);
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

