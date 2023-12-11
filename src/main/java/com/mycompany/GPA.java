package com.mycompany;

import java.util.ArrayList;
import java.util.List;

public class GPA {
    private List<CourseModel> courses;

    public GPA() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(CourseModel course) {
        courses.add(course);
    }

    public double calculateGPA() {
        int totalQualityPoints = courses.stream()
                .mapToInt(course -> course.getCourseUnit() * getGradeUnit(course.getCourseScore()))
                .sum();

        int totalGradeUnits = courses.stream()
                .mapToInt(CourseModel::getCourseUnit)
                .sum();

        return (double) totalQualityPoints / totalGradeUnits;
    }

    public void displayResult() {
        System.out.println("|------------------------|-------------|-------|------------|");
        System.out.println("| COURSE & CODE            COURSE UNIT   GRADE   GRADE-UNIT |");
        System.out.println("|------------------------|-------------|-------|------------|");

        courses.forEach(course -> System.out.printf("| %-14s %s | %-11d | %-5s | %-10d |\n",
                course.getCourseName(), course.getCourseCode(), course.getCourseUnit(), getGrade(course.getCourseScore()), getGradeUnit(course.getCourseScore())));

        System.out.println("\nYour GPA is = " + String.format("%.2f", calculateGPA()) + " to 2 decimal places.");
    }

    private int getGradeUnit(int score) {
        if (score >= 70) {
            return 5;
        } else if (score >= 60) {
            return 4;
        } else if (score >= 50) {
            return 3;
        } else if (score >= 45) {
            return 2;
        } else if (score >= 40) {
            return 1;
        } else {
            return 0;
        }
    }

    private String getGrade(int score) {
        if (score >= 70) {
            return "A";
        } else if (score >= 60) {
            return "B";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 45) {
            return "D";
        } else if (score >= 40) {
            return "E";
        } else {
            return "F";
        }
    }
}
