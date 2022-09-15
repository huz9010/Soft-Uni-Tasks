package June2019;

import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double total = 0;

        switch (destination)    {
            case "Dubai":
                if (season.equals("Winter"))    {
                    total = days * 45000 * 0.7;
                }   else {
                    total = days * 40000 * 0.7;
                }
                break;

            case "Sofia":
                if (season.equals("Winter"))    {
                    total = days * 17000 * 1.25;
                }   else {
                    total = days * 12500 * 1.25;
                }
                break;

            case "London":
                if (season.equals("Winter"))    {
                    total = days * 24000;
                }   else {
                    total = days * 20250;
                }
                break;
        }
        if (budget > total) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", (budget - total));
        }   else {
            System.out.printf("The director needs %.2f leva more!", (total - budget));
        }
    }
}
