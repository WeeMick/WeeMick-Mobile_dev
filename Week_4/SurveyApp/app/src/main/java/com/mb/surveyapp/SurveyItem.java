package com.mb.surveyapp;

public class SurveyItem {
    public SurveyItem(String name, float foodRating) {
        this.name = name;
        this.foodRating = foodRating;
    }

    public String getName() {
        return name;
    }

    public float getFoodRating() {
        return foodRating;
    }

    private String name;
    private float foodRating;
}
