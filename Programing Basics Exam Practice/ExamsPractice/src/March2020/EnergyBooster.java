package March2020;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine().toLowerCase();
        String setSize = scanner.nextLine().toLowerCase();
        int setCount = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (fruit)  {
            case "watermelon":
                if (setSize.equals("small"))    {
                    price = 2 * 56.0 * setCount;
                }   else {
                    price = 5 * 28.70 * setCount;
                }
                break;
            case "mango":
                if (setSize.equals("small"))    {
                    price = 2 * 36.66 * setCount;
                }   else {
                    price = 5 * 19.60 * setCount;
                }
                break;
            case "pineapple":
                if (setSize.equals("small"))    {
                    price = 2 * 42.10 * setCount;
                }   else {
                    price = 5 * 24.80 * setCount;
                }
                break;
            case "raspberry":
                if (setSize.equals("small"))    {
                    price = 2 * 20.0 * setCount;
                }   else {
                    price = 5 * 15.20 * setCount;
                }
                break;
        }
        if (price >= 400 && price <= 1000)   {
            price -= price * 0.15;
        } else if (price >= 1000) {
            price -= price * 0.5;
        }
        System.out.printf("%.2f lv.", price);
    }
}
