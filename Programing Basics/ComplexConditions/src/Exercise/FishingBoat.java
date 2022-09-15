package Exercise;

import java.util.Scanner;

public class FishingBoat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (season){
            case "spring":
                if (fishermen <= 6){
                    price = 3000.0 * 0.9;
                } else if (fishermen <= 11) {
                    price = 3000.0 * 0.85;
                }   else
                    price = 3000.0 * 0.75;
                break;
            case "summer":
            case "autumn":
                if (fishermen <= 6){
                    price = 4200.0 * 0.9;
                } else if (fishermen <= 11) {
                    price = 4200.0 * 0.85;
                }   else
                    price = 4200.0 * 0.75;
                break;
            case "winter":
                if (fishermen <= 6){
                    price = 2600.0 * 0.9;
                } else if (fishermen <= 11) {
                    price = 2600.0 * 0.85;
                }   else
                    price = 2600.0 * 0.75;
                break;
        }
        if (fishermen % 2 == 0 && !season.equals("autumn")){
            price = price * 0.95;
        }
        if (price > budget){
            System.out.printf("Not enough money! You need %.2f leva.", price - budget);
        }   else
            System.out.printf("Yes! You have %.2f leva left.", budget - price);
    }
}
