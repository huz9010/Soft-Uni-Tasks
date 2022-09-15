package ExamJune2022;

import java.util.Scanner;

public class CatDiet {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int fatPer = Integer.parseInt(scanner.nextLine());
        int proteinPer = Integer.parseInt(scanner.nextLine());
        int carbohydratesPer = Integer.parseInt(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        int waterPer = Integer.parseInt(scanner.nextLine());

        double fat = (totalCalories * fatPer * 1.0) / 9;
        double protein = (totalCalories * proteinPer * 1.0) / 4;
        double carbohydrates = (totalCalories * carbohydratesPer * 1.0) / 4;

        double foodWeight = fat + protein + carbohydrates;
        double caloriesPerGram = totalCalories / foodWeight;
        double calories = caloriesPerGram * (100 - waterPer);

        System.out.printf("%.4f", calories);
    }
}
