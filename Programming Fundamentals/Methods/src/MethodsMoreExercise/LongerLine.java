package MethodsMoreExercise;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int line1X1 = Integer.parseInt(scanner.nextLine());
        int line1Y1 = Integer.parseInt(scanner.nextLine());

        int line1X2 = Integer.parseInt(scanner.nextLine());
        int line1Y2 = Integer.parseInt(scanner.nextLine());

        int line2X1 = Integer.parseInt(scanner.nextLine());
        int line2Y1 = Integer.parseInt(scanner.nextLine());

        int line2X2 = Integer.parseInt(scanner.nextLine());
        int line2Y2 = Integer.parseInt(scanner.nextLine());

        printLongerLine(line1X1, line1Y1, line1X2, line1Y2, line2X1, line2Y1, line2X2, line2Y2);
    }

    public static void printLongerLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        double line1Length = Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
        double line2Length = Math.sqrt((Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2)));

        if (line1Length >= line2Length) {
            printClosestPoint(x1, y1, x2, y2);
        } else {
            printClosestPoint(x3, y3, x4, y4);
        }
    }

    public static void printClosestPoint(int x1, int y1, int x2, int y2) {
        double distanceFromZero1 = Math.sqrt((Math.pow(x1, 2) + Math.pow(y1, 2)));
        double distanceFromZero2 = Math.sqrt((Math.pow(x2, 2) + Math.pow(y2, 2)));

        if (distanceFromZero1 <= distanceFromZero2) {
            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
        }
    }
}
