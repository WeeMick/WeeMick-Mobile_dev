package com.example.firstapp;

public class Student {
    protected String name;
    protected int age;
    protected double grade;
    protected double height;
    protected double weight;
    protected boolean gender;

    public Student(String name, int age, double grade, double height, double weight, boolean gender) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


}
