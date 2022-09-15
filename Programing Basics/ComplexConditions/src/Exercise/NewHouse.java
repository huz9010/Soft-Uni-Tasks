package Exercise;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int flowerCount = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (flowerType){
            case "Roses":
                if (flowerCount > 80){
                    price = flowerCount * 5.0 * 0.9;
                }   else
                    price = flowerCount * 5.0;
                break;
            case "Dahlias":
                if (flowerCount > 90){
                    price = flowerCount * 3.8 * 0.85;
                }   else
                    price = flowerCount * 3.8;
                break;
            case "Tulips":
                if (flowerCount > 80){
                    price = flowerCount * 2.8 * 0.85;
                }   else
                    price = flowerCount * 2.8;
                break;
            case "Narcissus":
                if (flowerCount < 120){
                    price = flowerCount * 3.0 * 1.15;
                }   else
                    price = flowerCount * 3.0;
                break;
            case "Gladiolus":
                if (flowerCount < 80){
                    price = flowerCount * 2.5 * 1.2;
                }   else
                    price = flowerCount * 2.5;
                break;
        }
        if (price > budget){
            System.out.printf("Not enough money, you need %.2f leva more.", price - budget);
        }   else
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowerCount, flowerType, budget - price);
    }
}
