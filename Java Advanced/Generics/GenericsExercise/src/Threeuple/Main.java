package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, address, town);

        input = scanner.nextLine().split("\\s+");
        name = input[0];
        int littersOfBeer = Integer.parseInt(input[1]);
        boolean drunkOrNot = input[2].equals("drunk");
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(name, littersOfBeer, drunkOrNot);

        input = scanner.nextLine().split("\\s+");
        name  = input[0];
        double accountBalance = Double.parseDouble(input[1]);
        String bankName = input[2];
        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(name, accountBalance, bankName);

        System.out.println(firstThreeuple);
        System.out.println(secondThreeuple);
        System.out.println(thirdThreeuple);
    }
}
