package MoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine().toLowerCase();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());

        double profit = 0;

        if (kmPerMonth <= 5000) {
            switch (season){
                case "spring":
                case "autumn":
                    profit = kmPerMonth * 4 * 0.75;
                    break;

                case "summer":
                    profit = kmPerMonth * 4 * 0.9;
                    break;

                case "winter":
                    profit = kmPerMonth * 4 * 1.05;
                    break;
            }
        } else if (kmPerMonth > 5000 && kmPerMonth <= 10000) {
            switch (season){
                case "spring":
                case "autumn":
                    profit = kmPerMonth * 4 * 0.95;
                    break;

                case "summer":
                    profit = kmPerMonth * 4 * 1.1;
                    break;

                case "winter":
                    profit = kmPerMonth * 4 * 1.25;
                    break;
            }
        } else if (kmPerMonth > 10000 && kmPerMonth <= 20000) {
                    profit = kmPerMonth * 4 * 1.45;
        }
        double totalProfit = profit - profit * 0.1;

        System.out.printf("%.2f", totalProfit);
    }
}
