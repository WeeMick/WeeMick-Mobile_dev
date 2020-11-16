package com.example.firstuiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    EditText myEditText;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * References to instances of objects
         */
        myTextView = findViewById(R.id.myTV1);
        myEditText = findViewById(R.id.myPT);
        myButton = findViewById(R.id.myBtn1);

        myTextView.setText("Hi there");

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = myEditText.getText().toString();
                myTextView.setText("Your name is " + str);

                Toast.makeText(MainActivity.this, "hello!", Toast.LENGTH_LONG).show();
            }
        });
    }
}