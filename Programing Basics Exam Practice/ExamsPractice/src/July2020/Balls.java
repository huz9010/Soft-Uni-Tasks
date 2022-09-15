package July2020;

import com.sun.jdi.IntegerValue;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int ballCount = Integer.parseInt(scanner.nextLine());

        int redCount = 0;
        int orangeCount = 0;
        int yellowCount = 0;
        int whiteCount = 0;
        int otherCount = 0;
        int blackCount = 0;

        int points = 0;

        for (int i = 1; i <= ballCount; i++) {

            String color = scanner.nextLine();

            switch (color)  {
                case "red":
                    points = points + 5;
                    redCount++;
                    break;

                case "orange":
                    points = points + 10;
                    orangeCount++;
                    break;

                case "yellow":
                    points = points + 15;
                    yellowCount++;
                    break;

                case "white":
                    points = points + 20;
                    whiteCount++;
                    break;

                case "black":
                    points = (int) Math.floor(points / 2);
                    blackCount++;
                    break;

                default:
                    otherCount++;

            }
        }
        System.out.printf("Total points: %d%n" +
                "Red balls: %d%n" +
                "Orange balls: %d%n" +
                "Yellow balls: %d%n" +
                "White balls: %d%n" +
                "Other colors picked: %d%n" +
                "Divides from black balls: %d", points, redCount, orangeCount, yellowCount, whiteCount, otherCount, blackCount);
    }
}
