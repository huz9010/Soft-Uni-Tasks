package NestedLoopsLab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double sum = 0;

        while (!input.equals("End")) {
            String destination = input;
            double budget = Double.parseDouble(scanner.nextLine());

            while (sum < budget)    {
                double currentSum = Double.parseDouble(scanner.nextLine());
                sum = sum + currentSum;
            }
            System.out.printf("Going to %s!", destination);
            System.out.println();
            sum = 0;
            input = scanner.nextLine();
        }
    }
}
