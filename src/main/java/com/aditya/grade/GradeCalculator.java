package com.aditya.grade;

public class GradeCalculator {

    public int calculateTotal(int[] marks) {

        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new IllegalArgumentException("Marks must be between 0 and 100");
            }
        }

        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    public double calculatePercentage(int[] marks) {
        int total = calculateTotal(marks);
        return (double) total / marks.length;
    }

    public String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public boolean isPassed(double percentage) {
        return percentage >= 40;
    }
}