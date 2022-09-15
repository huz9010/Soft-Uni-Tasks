package NestedLoopsMoreExercises;

import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hoursPerDay = Integer.parseInt(scanner.nextLine());
        double sum = 0;

        for (int i = 1; i <= days ; i++) {

            double currentSum = 0;
            for (int j = 1; j <= hoursPerDay ; j++) {

                if ((i % 2 == 0) && !(j % 2 == 0)) {
                    currentSum = currentSum + 2.5;

                } else if (!(i % 2 == 0) && (j % 2 == 0)) {
                    currentSum = currentSum + 1.25;

                }   else {
                    currentSum = currentSum + 1.0;

                }
            }
            sum = sum + currentSum;
            System.out.printf("Day: %d - %.2f leva%n", i, currentSum);
        }
        System.out.printf("Total: %.2f leva", sum);
    }
}
