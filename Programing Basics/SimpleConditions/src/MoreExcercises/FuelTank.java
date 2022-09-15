package MoreExcercises;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine().toLowerCase();
        double fuel = Double.parseDouble(scanner.nextLine());

        if (fuelType.equals("diesel") && fuel >= 25) {
            System.out.println("You have enough diesel.");
        }   else if (fuelType.equals("diesel") && fuel < 25) {
            System.out.println("Fill your tank with diesel!");
        } else if (fuelType.equals("gasoline") && fuel >= 25) {
            System.out.println("You have enough gasoline.");
        } else if (fuelType.equals("gasoline") && fuel < 25) {
            System.out.println("Fill your tank with gasoline!");
        } else if (fuelType.equals("gas") && fuel >= 25) {
            System.out.println("You have enough gas.");
        } else if (fuelType.equals("gas") && fuel < 25) {
            System.out.println("Fill your tank with gas!");
        }   else {
            System.out.println("Invalid fuel!");
        }
    }
}
