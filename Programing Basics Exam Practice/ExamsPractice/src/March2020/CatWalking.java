package March2020;

import java.util.Scanner;

public class CatWalking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minsWalking = Integer.parseInt(scanner.nextLine());
        int walksPerDay = Integer.parseInt(scanner.nextLine());
        int caloriesTaken = Integer.parseInt(scanner.nextLine());

        int caloriesBurned = 5 * minsWalking * walksPerDay;

        if (caloriesBurned >= caloriesTaken / 2){
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", caloriesBurned);
        }   else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", caloriesBurned);
        }
    }
}
