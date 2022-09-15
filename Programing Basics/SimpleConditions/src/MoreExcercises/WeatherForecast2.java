package MoreExcercises;

import java.util.Scanner;

public class WeatherForecast2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double deg = Double.parseDouble(scanner.nextLine());

        boolean hot = (deg >= 26 && deg <= 35);
        boolean warm = (deg >= 20.1 && deg <= 25.9);
        boolean mild = (deg >= 15 && deg <= 20);
        boolean cool = (deg >= 12 && deg <= 14.9);
        boolean cold = (deg >= 5 && deg <= 11.9);

        if (hot) {

            System.out.println("Hot");
        } else if (warm) {
            System.out.println("Warm");
        } else if (mild) {
            System.out.println("Mild");
        } else if (cool) {
            System.out.println("Cool");
        }   else if (cold) {
            System.out.println("Cold");
        }   else {
            System.out.println("unknown");
        }

        }
}


