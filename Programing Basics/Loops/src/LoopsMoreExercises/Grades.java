package LoopsMoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        int topStudents = 0;
        int good = 0;
        int fair = 0;
        int failed = 0;
        double totalGrade = 0;

        for (int i = 1; i <= students ; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            totalGrade += grade;

            if (grade >= 5) {
                topStudents++;
            } else if (grade >= 4) {
                good++;
            } else if (grade >= 3) {
                fair++;
            }   else {
                failed++;
            }
        }
        double topStudentsPer = topStudents * 100.0 / students;
        double goodPer = good * 100.0 / students;
        double fairPer = fair * 100.0 / students;
        double failedPer = failed * 100.0 / students;
        double averageGrade = totalGrade / students;

        System.out.printf("Top students: %.2f%%%n" +
                "Between 4.00 and 4.99: %.2f%%%n" +
                "Between 3.00 and 3.99: %.2f%%%n" +
                "Fail: %.2f%%%n" +
                "Average: %.2f", topStudentsPer, goodPer, fairPer, failedPer, averageGrade);
    }
}
