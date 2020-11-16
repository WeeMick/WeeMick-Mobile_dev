package com.mb.surveyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    RatingBar foodRB;
    Button submitBtn;
    RecyclerView surveyRV;

    ArrayList<SurveyItem> survey = new ArrayList<SurveyItem>();
    SurveyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = findViewById(R.id.nameET);
        foodRB = findViewById(R.id.foodRB);
        submitBtn = findViewById(R.id.submitBtn);
        surveyRV = findViewById(R.id.surveyRV);

        survey.add(new SurveyItem("KFC",2));
        survey.add(new SurveyItem("McDonalds",3));
        survey.add(new SurveyItem("Chippy",1));

        adapter = new SurveyAdapter(survey, R.layout.list_item_view);
        surveyRV.setLayoutManager(new LinearLayoutManager(this));
        surveyRV.setItemAnimator(new DefaultItemAnimator());
        surveyRV.setAdapter(adapter);

        submitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                survey.add(new SurveyItem(nameET.getText().toString(), foodRB.getRating()));
                adapter.notifyDataSetChanged();;
            }
        });


    }
}