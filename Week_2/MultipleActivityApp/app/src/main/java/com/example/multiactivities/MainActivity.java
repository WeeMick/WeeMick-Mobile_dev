package com.example.multiactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText myEditText;
    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myEditText = findViewById(R.id.myET);
        myButton = findViewById(R.id.myBtn);

        myEditText.setText("Hi there");

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                String  str1 = "Original String";
                intent1.putExtra("MyVariableName", str1);
                startActivity(intent1);
                finish();
            }
        });
    }
}