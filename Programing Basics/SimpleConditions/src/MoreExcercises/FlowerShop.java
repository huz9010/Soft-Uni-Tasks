package MoreExcercises;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int magnolias = Integer.parseInt(scanner.nextLine());
        int hyacinth = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double magnoliasPrice = magnolias * 3.25;
        double hyacinthPrice = hyacinth * 4.0;
        double rosesPrice = roses * 3.5;
        double cactusPrice = cactus * 8.0;

        double profit = magnoliasPrice + hyacinthPrice + rosesPrice + cactusPrice - (magnoliasPrice + hyacinthPrice + rosesPrice + cactusPrice) * 0.05;

        if (profit >= giftPrice) {
            System.out.printf("She is left with %.0f leva.", Math.floor(profit - giftPrice));
        }   else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(giftPrice - profit));
        }
    }
}
