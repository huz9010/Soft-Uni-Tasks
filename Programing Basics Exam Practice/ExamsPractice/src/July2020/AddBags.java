package July2020;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double over20Kg = Double.parseDouble(scanner.nextLine());
        double bagKg = Double.parseDouble(scanner.nextLine());
        int daysToFlight = Integer.parseInt(scanner.nextLine());
        int bagCount = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        if (bagKg < 10) {
            totalPrice = bagCount * over20Kg * 0.2;
        } else if (bagKg > 20) {
            totalPrice = bagCount * over20Kg;
        }   else {
            totalPrice = bagCount * over20Kg * 0.5;
        }
        if (daysToFlight > 30)  {
            totalPrice = totalPrice * 1.1;
        } else if (daysToFlight < 7) {
            totalPrice = totalPrice * 1.4;
        }   else {
            totalPrice = totalPrice * 1.15;
        }
        System.out.printf("The total price of bags is: %.2f lv.", totalPrice);
    }
}
