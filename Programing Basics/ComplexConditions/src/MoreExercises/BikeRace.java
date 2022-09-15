package MoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int juniorRacers = Integer.parseInt(scanner.nextLine());
        int seniorRacers = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine().toLowerCase();

        double trailTaxes = juniorRacers * 5.5 + seniorRacers * 7.0;
        double crossCountryTaxes = juniorRacers * 8 + seniorRacers * 9.50;
        double downhillTaxes = juniorRacers * 12.25 + seniorRacers * 13.75;
        double roadTaxes = juniorRacers * 20.0 + seniorRacers * 21.5;

        double donation = 0;

        switch (trackType) {
            case "trail":
               donation = trailTaxes - trailTaxes * 0.05;
               break;
            case "cross-country":
                if ((juniorRacers + seniorRacers) >= 50){
                    donation = (crossCountryTaxes - crossCountryTaxes * 0.25) - (crossCountryTaxes - crossCountryTaxes * 0.25) * 0.05;
                }   else {
                    donation = crossCountryTaxes - crossCountryTaxes * 0.05;
                }
                break;
            case "downhill":
                donation = downhillTaxes - downhillTaxes * 0.05;
                break;
            case "road":
                donation = roadTaxes - roadTaxes * 0.05;
                break;
                        }
        System.out.printf("%.2f", donation);
    }
}
