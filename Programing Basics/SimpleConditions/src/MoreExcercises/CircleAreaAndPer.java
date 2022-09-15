package MoreExcercises;

import java.util.Scanner;

public class CircleAreaAndPer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double area = Math.PI * r * r;
        double per = Math.PI * 2 * r;

        System.out.printf("%.2f%n%.2f", area, per);
    }
}
