package MoreExcercises;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine());  //скумрия
        double spratPrice = Double.parseDouble(scanner.nextLine());   //цаца
        double bonitoKg = Double.parseDouble(scanner.nextLine());   //паламуд
        double scadKg = Double.parseDouble(scanner.nextLine());   //сафрид
        int shellsKg = Integer.parseInt(scanner.nextLine());

        double bonitoPrice = bonitoKg * (mackerelPrice + mackerelPrice * 0.6);
        double scadPrice = scadKg * (spratPrice + spratPrice * 0.8);
        double shellPrice = shellsKg * 7.5;

        double totalPrice = bonitoPrice + scadPrice + shellPrice;

        System.out.printf("%.2f", totalPrice);
    }
}
