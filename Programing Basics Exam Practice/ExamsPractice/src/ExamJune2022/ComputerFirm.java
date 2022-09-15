package ExamJune2022;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pcCount = Integer.parseInt(scanner.nextLine());
        double sells = 0;
        double rating = 0;

        for (int i = 1; i <= pcCount; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            double currentSells = 0;

            int currentRating = num % 10;
            rating = rating + currentRating;
            int possibleSells = num / 10;

            if (currentRating == 2) {
                currentSells = 0;
            } else if (currentRating == 3) {
                currentSells = possibleSells * 0.5;
            } else if (currentRating == 4) {
                currentSells = possibleSells * 0.7;
            } else if (currentRating == 5) {
                currentSells = possibleSells * 0.85;
            } else if (currentRating == 6) {
                currentSells = possibleSells;
            }
            sells = sells + currentSells;
        }
        double avgRating = rating / pcCount;
        System.out.printf("%.2f%n%.2f", sells, avgRating);
    }
}
