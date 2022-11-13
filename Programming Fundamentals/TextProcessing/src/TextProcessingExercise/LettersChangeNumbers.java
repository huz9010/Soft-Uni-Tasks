package TextProcessingExercise;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        double total = 0;

        for (int i = 0; i < input.length; i++) {
            total += calculateString(input[i]);
        }
        System.out.printf("%.2f", total);
    }

    public static double calculateString(String input){
        char firstLetter = input.charAt(0);
        char lastLetter = input.charAt(input.length() - 1);
        input = input.replace(input.charAt(0), ' ');
        input = input.replace(input.charAt(input.length() - 1), ' ');
        input = input.trim();
        double num = Double.parseDouble(input);
        double result = 0;

        if (Character.isUpperCase(firstLetter))  {
            result = num / (firstLetter - 64);
        } else if (Character.isLowerCase(firstLetter)) {
            result = num * (firstLetter - 96);
        }

        if (Character.isUpperCase(lastLetter))  {
            result -= lastLetter - 64;
        } else if (Character.isLowerCase(lastLetter)) {
            result += lastLetter - 96;
        }

        return result;
    }
}
