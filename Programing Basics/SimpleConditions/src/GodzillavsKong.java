import java.util.Scanner;

public class GodzillavsKong {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statist = Integer.parseInt(scanner.nextLine());
        double costumePrice = Double.parseDouble(scanner.nextLine());

        double decorPrice = budget * 0.1;
        double allCostumePrice = costumePrice * statist;

        double totalCost = 0;

        if (statist > 150) {
            totalCost = decorPrice + (allCostumePrice - allCostumePrice * 0.1);
        }   else {
            totalCost = decorPrice + allCostumePrice;
        }
        if (budget < totalCost) {
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.", totalCost - budget);
        }   else {
            System.out.printf("Action!%nWingard starts filming with %.2f leva left.", budget - totalCost);
        }
    }
}
