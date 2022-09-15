package ExamJune2022.Exam2;

import java.util.Scanner;

public class PuppyCare {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int boughtFood = Integer.parseInt(scanner.nextLine());
        int foodInGrams = boughtFood * 1000;
        String input = scanner.nextLine();

        while (!input.equals("Adopted")) {
            int foodEaten = Integer.parseInt(input);

            foodInGrams = foodInGrams - foodEaten;
            input = scanner.nextLine();
        }
        if (foodInGrams >= 0)  {
            System.out.printf("Food is enough! Leftovers: %d grams.", foodInGrams);
        }   else {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(foodInGrams));
        }
    }
}

