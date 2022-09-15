package March2020;

import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double allFood = Double.parseDouble(scanner.nextLine());
        double eatenFood = 0;
        double cat = 0;
        double dog = 0;
        double biscuits = 0;

        for (int i = 1; i <= days; i++) {
            int dogFood = Integer.parseInt(scanner.nextLine());
            int catFood = Integer.parseInt(scanner.nextLine());

            dog += dogFood;
            cat += catFood;
            eatenFood += dogFood + catFood;

            if (i % 3 == 0)  {
                biscuits += (dogFood + catFood) * 0.1;
            }
        }
        double eatenFoodPercent = eatenFood / allFood * 100;
        double dogPercent = dog / eatenFood * 100;
        double catPercent = cat / eatenFood * 100;

        System.out.printf("Total eaten biscuits: %.0fgr.%n" +
                "%.2f%% of the food has been eaten.%n" +
                "%.2f%% eaten from the dog.%n" +
                "%.2f%% eaten from the cat.", biscuits, eatenFoodPercent, dogPercent, catPercent);
    }
}
