import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine().toLowerCase();
        String day = scanner.nextLine().toLowerCase();
        double amount = Double.parseDouble(scanner.nextLine());
        double price = 0;

        if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday") || day.equals("friday")) {
            if (fruit.equals("banana")) {
                price = amount * 2.5;
            }
            if (fruit.equals("apple")) {
                price = amount * 1.2;
            }
            if (fruit.equals("orange")) {
                price = amount * 0.85;
            }
            if (fruit.equals("grapefruit")) {
                price = amount * 1.45;
            }
            if (fruit.equals("kiwi")) {
                price = amount * 2.7;
            }
            if (fruit.equals("pineapple")) {
                price = amount * 5.5;
            }
            if (fruit.equals("grapes")) {
                price = amount * 3.85;
            }


        } else if (day.equals("saturday") || day.equals("sunday")) {
            if (fruit.equals("banana")) {
                price = amount * 2.7;
            }
            if (fruit.equals("apple")) {
                price = amount * 1.25;
            }
            if (fruit.equals("orange")) {
                price = amount * 0.90;
            }
            if (fruit.equals("grapefruit")) {
                price = amount * 1.60;
            }
            if (fruit.equals("kiwi")) {
                price = amount * 3;
            }
            if (fruit.equals("pineapple")) {
                price = amount * 5.6;
            }
            if (fruit.equals("grapes")) {
                price = amount * 4.2;
            }
        }
        if (price == 0){
            System.out.println("error");
        }   else System.out.printf("%.2f",price);


    }
}