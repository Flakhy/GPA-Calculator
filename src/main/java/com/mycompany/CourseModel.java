package com.mycompany;

public class CourseModel {
    private String courseName;
    private String courseCode;
    private int courseUnit;
    private int courseScore;

    public CourseModel(String courseName, String courseCode, int courseUnit, int courseScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseUnit = courseUnit;
        this.courseScore = courseScore;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public int getCourseScore() {
        return courseScore;
    }
}
