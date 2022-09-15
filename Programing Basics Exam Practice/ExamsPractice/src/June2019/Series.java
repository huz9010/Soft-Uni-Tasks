package June2019;

import java.util.Scanner;

public class Series {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int seriesCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= seriesCount; i++) {
            String title = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());

            switch (title)  {
                case "Thrones":
                    budget = budget - price / 2;
                    break;
                case "Lucifer":
                    budget = budget - price * 0.6;
                    break;
                case "Protector":
                    budget = budget - price * 0.7;
                    break;
                case "TotalDrama":
                    budget = budget - price * 0.8;
                    break;
                case "Area":
                    budget = budget - price * 0.9;
                    break;
                default:
                    budget = budget - price;
            }
        }
        if (budget < 0) {
            System.out.printf("You need %.2f lv. more to buy the series!", Math.abs(budget));
        }   else {
            System.out.printf("You bought all the series and left with %.2f lv.", budget);
        }
    }
}
