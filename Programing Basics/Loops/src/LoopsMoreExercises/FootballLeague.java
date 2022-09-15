package LoopsMoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        int fans = Integer.parseInt(scanner.nextLine());

        int sectorA = 0;
        int sectorB = 0;
        int sectorV = 0;
        int sectorG = 0;
        for (int i = 1; i <= fans ; i++) {
            char sector = scanner.nextLine().charAt(0);

            switch (sector) {
                case 'A':
                   sectorA++;
                   break;
                case 'B':
                    sectorB++;
                    break;
                case 'V':
                    sectorV++;
                    break;
                case 'G':
                    sectorG++;
                    break;
            }
        }
        double sectorAfans = sectorA * 100.0 / fans;
        double sectorBfans = sectorB * 100.0 / fans;
        double sectorVfans = sectorV * 100.0 / fans;
        double sectorGfans = sectorG * 100.0 / fans;
        double fansPercent = fans * 100.0 / capacity;

        System.out.printf("%.2f%%%n" +
                "%.2f%%%n" +
                "%.2f%%%n" +
                "%.2f%%%n" +
                "%.2f%%%n", sectorAfans, sectorBfans, sectorVfans , sectorGfans, fansPercent);
    }
}
