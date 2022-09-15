package June2019;

import java.util.Scanner;

public class MovieStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String actor = scanner.nextLine();

        boolean noMoney = false;

        while (!actor.equals("ACTION")) {
            if (actor.length() > 15)   {
                budget = budget - budget * 0.2;
            }   else {
                double salary = Double.parseDouble(scanner.nextLine());
                budget = budget - salary;
            }

            if (budget < 0) {
                System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
                noMoney = true;
                break;
            }
            actor = scanner.nextLine();
        }
        if (!noMoney)   {
            System.out.printf("We are left with %.2f leva.", budget);
        }
    }
}
