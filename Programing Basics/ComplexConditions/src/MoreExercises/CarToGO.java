package MoreExercises;

import java.util.Scanner;

public class CarToGO {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();

        String carClass = "";
        String carType = "";
        double carPrice = 0;

        if (budget <= 100) {
            carClass = "Economy class";
            switch (season){
                case "summer":
                    carType = "Cabrio";
                    carPrice = budget * 0.35;
                    break;

                case "winter":
                    carType = "Jeep";
                    carPrice = budget * 0.65;
                    break;
            }
        } else if (budget > 100 && budget <= 500) {
            carClass = "Compact class";
            switch (season){
                case "summer":
                    carType = "Cabrio";
                    carPrice = budget * 0.45;
                    break;

                case "winter":
                    carType = "Jeep";
                    carPrice = budget * 0.80;
                    break;
            }
        } else {
            carClass = "Luxury class";
            carType = "Jeep";
            carPrice = budget * 0.9;
        }

        System.out.printf("%s%n%s - %.2f", carClass, carType, carPrice);
    }
}
