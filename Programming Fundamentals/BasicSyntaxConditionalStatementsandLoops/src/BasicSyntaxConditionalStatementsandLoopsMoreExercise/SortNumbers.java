package BasicSyntaxConditionalStatementsandLoopsMoreExercise;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());
        double num3 = Double.parseDouble(scanner.nextLine());

        if (num3 <= num2 && num2 <= num1) {
            System.out.printf("%.0f%n", num1);
            System.out.printf("%.0f%n", num2);
            System.out.printf("%.0f%n", num3);
        } else if (num2 <= num3 && num3 <= num1) {
            System.out.printf("%.0f%n", num1);
            System.out.printf("%.0f%n", num3);
            System.out.printf("%.0f%n", num2);
        } else if (num3 <= num1) {
            System.out.printf("%.0f%n", num2);
            System.out.printf("%.0f%n", num1);
            System.out.printf("%.0f%n", num3);
        } else if (num3 <= num2) {
            System.out.printf("%.0f%n", num2);
            System.out.printf("%.0f%n", num3);
            System.out.printf("%.0f%n", num1);
        } else if (num2 <= num1) {
            System.out.printf("%.0f%n", num3);
            System.out.printf("%.0f%n", num1);
            System.out.printf("%.0f%n", num2);
        } else {
            System.out.printf("%.0f%n", num3);
            System.out.printf("%.0f%n", num2);
            System.out.printf("%.0f%n", num1);
        }
    }
}
