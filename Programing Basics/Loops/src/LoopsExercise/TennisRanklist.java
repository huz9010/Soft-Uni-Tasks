package LoopsExercise;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);

        int tournaments = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());
        int tournamentPoints = 0;
        int wins = 0;

        for (int i = 1; i <= tournaments ; i++) {
            String level = scanner.nextLine().toLowerCase();

            switch (level)  {
                case "w":
                    tournamentPoints += 2000;
                    wins++;
                    break;
                case "f":
                    tournamentPoints += 1200;
                    break;
                case "sf":
                    tournamentPoints += 720;
                    break;
            }
        }
        int totalPoints = tournamentPoints + startingPoints;
        double averagePoints = Math.floor(tournamentPoints * 1.0/ tournaments);
        double winPercentage = wins * 100.0 / tournaments;

        System.out.printf("Final points: %d%n" +
                "Average points: %.0f%n" +
                "%.2f%%", totalPoints, averagePoints, winPercentage);
    }
}
