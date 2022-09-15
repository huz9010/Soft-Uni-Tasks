package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int charCount = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= charCount; i++) {
            char currentChar = scanner.nextLine().charAt(0);
            sum += currentChar;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
