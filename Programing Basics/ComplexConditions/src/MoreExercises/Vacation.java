package MoreExercises;

import java.util.Scanner;

public class Vacation {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            double budget = Double.parseDouble(scanner.nextLine());
            String season = scanner.nextLine().toLowerCase();

            String location = "";
            String accommodation = "";
            double price = 0;

            if (budget <= 1000) {
                accommodation = "Camp";
                switch (season){
                    case "summer":
                        location = "Alaska";
                        price = budget * 0.65;
                        break;

                    case "winter":
                        location = "Morocco";
                        price = budget * 0.45;
                        break;
                }
            } else if (budget > 1000 && budget <= 3000) {
                accommodation = "Hut";
                switch (season){
                    case "summer":
                        location = "Alaska";
                        price = budget * 0.8;
                        break;

                    case "winter":
                        location = "Morocco";
                        price = budget * 0.6;
                        break;
                }
            } else {
                accommodation = "Hotel";
                price = budget * 0.9;

                switch (season){
                    case "summer":
                        location = "Alaska";
                        break;

                    case "winter":
                        location = "Morocco";
                        break;
            }
        }
            System.out.printf("%s - %s - %.2f", location, accommodation, price);
    }
}
