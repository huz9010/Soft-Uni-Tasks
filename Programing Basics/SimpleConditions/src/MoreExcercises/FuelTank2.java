package MoreExcercises;

import java.util.Scanner;

public class FuelTank2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine().toLowerCase();
        double fuelAmount = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine().toLowerCase();

        double total = 0;

        switch (fuelType) {
            case "gasoline":
                if (clubCard.equals("yes")) {
                    total = fuelAmount * 2.04;
                } else if (clubCard.equals("no")) {
                    total = fuelAmount * 2.22;
                }
                break;
            case "diesel":
                if (clubCard.equals("yes")) {
                    total = fuelAmount * 2.21;
                } else if (clubCard.equals("no")) {
                    total = fuelAmount * 2.33;
                }
                break;
            case "gas":
                if (clubCard.equals("yes")) {
                    total = fuelAmount * 0.85;
                } else if (clubCard.equals("no")) {
                    total = fuelAmount * 0.93;
                }
                break;
        }

        if (fuelAmount >= 20 && fuelAmount <= 25) {
            System.out.printf("%.2f lv.", total - total * 0.08);
        } else if (fuelAmount > 25) {
            System.out.printf("%.2f lv.", total - total * 0.1);
        } else {
            System.out.printf("%.2f lv.", total);
        }
    }
}

