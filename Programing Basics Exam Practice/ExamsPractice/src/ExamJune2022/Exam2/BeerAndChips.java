package ExamJune2022.Exam2;

import java.util.Scanner;

public class BeerAndChips {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int beers = Integer.parseInt(scanner.nextLine());
        int chips = Integer.parseInt(scanner.nextLine());

        double beersPrice = beers * 1.2;
        double chipsPrice = Math.ceil(chips * (beersPrice * 0.45));
        double total = beersPrice + chipsPrice;

        if (budget >= total)    {
            System.out.printf("%s bought a snack and has %.2f leva left.", name, (budget - total));
        }   else {
            System.out.printf("%s needs %.2f more leva!", name, (total - budget));
        }
    }
}
