package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout;
    TextView     myTextView;
    ScrollView   myScrollView;
    ArrayList<Student> students = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        myLayout = new LinearLayout( this);
        myTextView = new TextView( this);
        myScrollView = new ScrollView(this);

//        myTextView.setText("Hello from Java");
        myTextView.setTextSize(30);
        myTextView.setTextColor(Color.rgb(250,0,255));
        myTextView.setTypeface(Typeface.SERIF, Typeface.ITALIC);

        myLayout.addView(myTextView);

        myScrollView.addView(myLayout);
        setContentView(myScrollView);

        //setContentView(myLayout);

//        showSomeNumbers();
        showSomeStudents();
    }

//    void showSomeNumbers()
//    {
//        int i;
//        String str = "";
//        for(i=1; i<20; i++)
//        {
//            str=str + "Number " + i + "\n";
//        }
//
//        myTextView.setText(str);
//    }

    void showSomeStudents() {
        students.add(new Student("Bob", 21, 55.5, 160.2, 12.6, true));
        students.add(new Student("Mary", 19, 70.3, 155.0, 8.5, false));
        students.add(new Student("Fred", 35, 66.0, 187.9, 14.2, true));

        String str = "";
        double totalHeight = 0;
        double totalWeight = 0;
        int noOfStudents = students.size();

        for (Student s:students)
        {
            totalHeight += s.getHeight();
            totalWeight += s.getWeight();
            str = str + "Name " + s.getName() + " age " + s.getAge() + " grade " + s.getGrade() + " height " + s.getHeight() + " weight " + s.getWeight() + " is male? " + s.isGender() +  "\n";
        }

        str += "Average height: " + getAvgHeight(totalHeight, noOfStudents) + "\n Average weight: "  + getAvgWeight(totalWeight, noOfStudents) ;
//        myTextView.setText(str);
         myTextView.setText(str);

    }

    /*
    * should not be dividing double by int - different types
     */
    double getAvgHeight(double totalHeight, int noOfStudents)
    {
        return totalHeight / noOfStudents;
    }

    double getAvgWeight(double totalWeight, int noOfStudents)
    {
        return totalWeight / noOfStudents;
    }
}