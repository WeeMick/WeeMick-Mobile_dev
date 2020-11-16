package com.mb.surveyapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.ViewHolder> {
    private ArrayList<SurveyItem> survey;
    private int listItemLayout;

    public SurveyAdapter(ArrayList<SurveyItem> survey, int listItemLayout) {
        this.survey = survey;
        this.listItemLayout = listItemLayout;
    }

    @NonNull
    @Override
    public SurveyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SurveyAdapter.ViewHolder holder, int position) {
        holder.text_in_list_item.setText(survey.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return survey.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public TextView text_in_list_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_in_list_item = itemView.findViewById(R.id.text_in_list_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("MyTag", "you clicked me " + getLayoutPosition()+text_in_list_item.getText());
        }
    }
}
