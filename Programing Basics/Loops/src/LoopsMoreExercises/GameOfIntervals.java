package LoopsMoreExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());

        double totalPoints = 0;
        int f0t9 = 0;
        int f10t19 = 0;
        int f20t29 = 0;
        int f30t39 = 0;
        int f40t50 = 0;
        int invalid = 0;

        for (int i = 1; i <= moves ; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            if (num >= 0 && num <= 9)   {
                totalPoints += num * 0.2;
                f0t9++;
            } else if (num >= 10 && num <= 19) {
                totalPoints += num * 0.3;
                f10t19++;
            } else if (num >= 20 && num <= 29) {
                totalPoints += num * 0.4;
                f20t29++;
            } else if (num >= 30 && num <= 39) {
                totalPoints += 50;
                f30t39++;
            } else if (num >= 40 && num <= 50) {
                totalPoints += 100;
                f40t50++;
            }   else {
                totalPoints = totalPoints / 2;
                invalid++;
            }
        }

        double f0t9Per = f0t9 * 100.0 / moves;
        double f10t19Per = f10t19 * 100.0 / moves;
        double f20t29Per = f20t29 * 100.0 / moves;
        double f30t39Per = f30t39 * 100.0 / moves;
        double f40t50Per = f40t50 * 100.0 / moves;
        double invalidPer = invalid * 100.0 / moves;

        System.out.printf("%.2f%n" +
                "From 0 to 9: %.2f%%%n" +
                "From 10 to 19: %.2f%%%n" +
                "From 20 to 29: %.2f%%%n" +
                "From 30 to 39: %.2f%%%n" +
                "From 40 to 50: %.2f%%%n" +
                "Invalid numbers: %.2f%%", totalPoints * 1.0, f0t9Per, f10t19Per, f20t29Per, f30t39Per, f40t50Per, invalidPer);
    }
}
