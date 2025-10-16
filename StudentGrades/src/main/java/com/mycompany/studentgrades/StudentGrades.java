package com.mycompany.studentgrades;

import java.util.Scanner;

public class StudentGrades {

// make scanner object 
    static Scanner scanner = new Scanner(System.in);
    static int marks[] = new int[5];
    static String studentName = "";

    public static void main(String[] args) {

        // declare variables 
        int choice;
        boolean running = true;

        // prompt the user for choice and welcome 
        while (running) {
            System.out.println("****************************");
            System.out.println("WELCOME TO THE GRADES APP !!");
            System.out.println("****************************");
            System.out.println();
            System.out.println("1. Input grades ");
            System.out.println("2. Check grades and final average");
            System.out.println("3. See if you qualify for a bursary");
            System.out.println("4. Exit");
            System.out.println("****************************");

            // user has to enter a choice 
            System.out.print("PICK A CHOICE : ");
            choice = scanner.nextInt();

            switch (choice) {  // determines what happens depending on their choice
                case 1 -> {
                    inputGrades();
                }

                case 2 -> {
                    checkGradesAndAverage();
                }
                case 3 ->
                    bursaryQualify(checkGradesAndAverage(), studentName);
                case 4 ->
                    running = false;
                default ->  // if user enters an invalid choice like 5 or words
                    System.out.println("You need to enter a VALID choice (1-4) !!");

            }
        }
        /*
         method to get grades (subject) and enter subject
         method to check average (mean math)
         method to see if student qualifies for bursary 
         */

        // exit message 
        System.out.println("-------------------------------------");
        System.out.println("THANK YOU FOR USING THE RESULTS APP !");
        System.out.println("-------------------------------------");

        scanner.close();

    }

    public static void inputGrades() {
        scanner.nextLine(); // clear buffer after previous nextInt

        System.out.println("**********************");
        System.out.print("Enter your name: ");
        studentName = scanner.nextLine();
        System.out.println();

        for (int i = 0; i < marks.length; i++) {  // for loop so user can keep entering marks
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println();
        System.out.println("Your marks have been captured, " + studentName + "!");
    }

    public static double checkGradesAndAverage() {
        System.out.println("*************************");
        System.out.println("YOUR GRADES FOR THE YEAR");
        System.out.println("*************************");

        if (studentName == null) {  // if statement to see if a student name is captured
            System.out.println("No grades have been captured as yet !");
            return -1;
        }
        System.out.println("Grades for " + studentName + " has been captured.");
        int total = 0;
        for (int mark : marks) {  // for loop to retrieve from marks array
            System.out.println(mark + " ");
            total += mark;
        }
        double average = (double) total / marks.length;
        System.out.println("\nFinal Average: " + average);  // logic for calculating an average
        System.out.println();

        return average;
    }

    public static void bursaryQualify(double average, String studentName) {

        if (average >= 75) {   // if statement to see if student qualifies for a bursary if average is 75% and above 
            System.out.println("Dear " + studentName + ", congratulations you qualify for a bursary !!");

        } else {
            System.out.println("Dear " + studentName + ", you unfortunately do NOT qualify for a bursary.");
        }
    }
}
