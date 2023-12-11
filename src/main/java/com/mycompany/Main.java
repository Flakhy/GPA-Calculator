package com.mycompany;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GPA gpaCalculator = new GPA();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter course name (type 'exit' to finish): ");
            String courseName = scanner.nextLine();

            if (courseName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter course code: ");
            String courseCode = scanner.nextLine();

            
            int courseUnit;
            while (true) {
                try {
                    System.out.println("Enter course unit between 1 and 10: ");
                    courseUnit = scanner.nextInt();

                    if (courseUnit >= 1 && courseUnit <= 10) {
                        break; 
                    } else {
                        System.out.println("Error: Course unit must be between 1 and 10. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a number for course unit.");
                    scanner.nextLine(); 
                }
            }

            int courseScore;
            while (true) {
                try {
                    System.out.println("Enter course score (0 to 100): ");
                    courseScore = scanner.nextInt();

                    if (courseScore >= 0 && courseScore <= 100) {
                        break; 
                    } else {
                        System.out.println("Error: Course score must be between 0 and 100. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid integer for course score.");
                    scanner.nextLine(); 
                }
            }

            scanner.nextLine(); 

            CourseModel course = new CourseModel(courseName, courseCode, courseUnit, courseScore);
            gpaCalculator.addCourse(course);
        }

        gpaCalculator.displayResult();
        scanner.close();
    }
}
