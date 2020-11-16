package com.example.multiactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();

        if (extras != null)
        {
            String str = extras.getString("MyVariableName");
            Toast.makeText(MainActivity2.this, "val = " + str, Toast.LENGTH_LONG).show();
        }
    }
}