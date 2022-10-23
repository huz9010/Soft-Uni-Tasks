package MidExamOct23;

import java.util.Scanner;

public class BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int citiesCount = Integer.parseInt(scanner.nextLine());
        double totalProfit = 0;

        for (int i = 1; i <= citiesCount; i++) {
            String city = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());
            double currentCityIncome = 0;

            if (i % 5 == 0) {
                currentCityIncome = income * 0.9 - expenses;
            } else if (i % 3 == 0) {
                currentCityIncome = income - expenses * 1.5;
            }   else {
                currentCityIncome = income - expenses;
            }
            totalProfit = totalProfit + currentCityIncome;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", city, currentCityIncome);
        }
        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
