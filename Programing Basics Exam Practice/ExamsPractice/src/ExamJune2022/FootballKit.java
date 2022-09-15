package ExamJune2022;

import java.util.Scanner;

public class FootballKit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double tShirtPrice = Double.parseDouble(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double shortsPrice = tShirtPrice * 0.75;
        double socksPrice = shortsPrice * 0.2;
        double shoePrice = (tShirtPrice + shortsPrice) * 2;

        double totalPrice = (tShirtPrice + shortsPrice + socksPrice + shoePrice) * 0.85;

        if (totalPrice >= giftPrice)    {
            System.out.printf("Yes, he will earn the world-cup replica ball!%n" +
                    "His sum is %.2f lv.", totalPrice);
        }   else {
            System.out.printf("No, he will not earn the world-cup replica ball.%n" +
                    "He needs %.2f lv. more.", (giftPrice - totalPrice));
        }
    }
}
