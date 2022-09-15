package MoreExcercises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int food = Integer.parseInt(scanner.nextLine());
        double dogsFoodPerDay = Double.parseDouble(scanner.nextLine());
        double catsFoodPerDay = Double.parseDouble(scanner.nextLine());
        double turtlesFoodPerDay = Double.parseDouble(scanner.nextLine());

        double dogsFood = dogsFoodPerDay * days;
        double catsFood = catsFoodPerDay * days;
        double turtlesFood = turtlesFoodPerDay / 1000 * days;

        double neededFood = dogsFood + catsFood + turtlesFood;

        if (neededFood <= food) {
            System.out.printf("%.0f kilos of food left.", Math.floor(food - neededFood));
        }   else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(neededFood - food));
        }
    }
}
