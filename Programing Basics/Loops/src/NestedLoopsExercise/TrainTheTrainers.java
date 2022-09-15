package NestedLoopsExercise;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        double allGradeSum = 0;
        int presentationCount = 0;

        while (!presentation.equals("Finish"))  {

            double gradeSum = 0;
            for (int i = 1; i <= n ; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                gradeSum = gradeSum + grade;
            }
            System.out.printf("%s - %.2f.%n", presentation, gradeSum / n);
            allGradeSum = allGradeSum + (gradeSum / n);
            presentationCount++;
            presentation = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allGradeSum / presentationCount);
    }
}
