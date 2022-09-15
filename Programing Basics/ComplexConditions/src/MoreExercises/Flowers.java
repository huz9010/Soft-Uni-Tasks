package MoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine().toLowerCase();
        String holiday = scanner.nextLine().toLowerCase();

        int totalFlowers = chrysanthemums + roses + tulips;

        double sSChrysanthemumsPrice = chrysanthemums * 2.0;
        double aWChrysanthemumsPrice = chrysanthemums * 3.75;
        double sSRosesPrice = roses * 4.1;
        double aWRosesPrice = roses * 4.5;
        double sSTulipsPrice = tulips * 2.50;
        double aWTulipsPrice = tulips * 4.15;

        double sSTotal = sSChrysanthemumsPrice + sSRosesPrice + sSTulipsPrice;
        double aWTotal = aWChrysanthemumsPrice + aWRosesPrice + aWTulipsPrice;

        double sSTotalHoliday = sSTotal + sSTotal * 0.15;
        double awTotalHoliday = aWTotal + aWTotal * 0.15;

        double totalPrice = 0;

        switch (holiday) {
            case "y":
                if (tulips > 7 && season.equals("spring")) {
                    totalPrice = sSTotalHoliday - sSTotalHoliday * 0.05;
                } else if (season.equals("spring") || season.equals("summer")) {
                    totalPrice = sSTotalHoliday;
                } else if (roses >= 10 && season.equals("winter")) {
                    totalPrice = awTotalHoliday - awTotalHoliday * 0.1;
                } else if (season.equals("winter") || season.equals("autumn")) {
                    totalPrice = awTotalHoliday;
                }
                break;

            case "n":
                if (tulips > 7 && season.equals("spring")) {
                    totalPrice = sSTotal - sSTotal * 0.05;
                } else if (season.equals("spring") || season.equals("summer")) {
                    totalPrice = sSTotal;
                } else if (roses >= 10 && season.equals("winter")) {
                    totalPrice = aWTotal - aWTotal * 0.1;
                } else if (season.equals("winter") || season.equals("autumn")) {
                    totalPrice = aWTotal;
                }
                break;
        }

                if (totalFlowers > 20) {
                    totalPrice = totalPrice - totalPrice * 0.2;
                }
            System.out.printf("%.2f" , totalPrice +2);
        }
    }

