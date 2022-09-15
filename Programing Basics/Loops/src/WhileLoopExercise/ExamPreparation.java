package WhileLoopExercise;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxPoorGrades = Integer.parseInt(scanner.nextLine());
        String lastProblem = "";
        int poorGrades = 0;
        boolean isFailed = true;
        double gradeSum = 0;
        int problemsSolved = 0;

        while (poorGrades < maxPoorGrades)  {
            String currentProblem = scanner.nextLine();


            if (currentProblem.equals("Enough"))    {
                isFailed = false;
                break;
            }
            double currentGrade = Double.parseDouble(scanner.nextLine());
            if (currentGrade <= 4)  {
                poorGrades++;
            }
            gradeSum = gradeSum + currentGrade;
            problemsSolved++;
            lastProblem = currentProblem;
        }
        if (isFailed)   {
            System.out.printf("You need a break, %d poor grades.", poorGrades);
        }   else {
            System.out.printf("Average score: %.2f%n" +
                    "Number of problems: %d%n" +
                    "Last problem: %s", (gradeSum/problemsSolved), problemsSolved, lastProblem);
        }
    }
}
