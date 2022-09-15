package BasicSyntaxConditionalStatementsandLoopsExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("Start"))  {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2)    {
                sum += coin;
            }   else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End"))    {

            switch (input)  {
                case "Nuts":
                    if (sum < 2)    {
                        System.out.println("Sorry, not enough money");
                    }   else {
                        System.out.printf("Purchased %s%n", input);
                        sum = sum - 2;
                    }
                    break;

                case "Water":
                    if (sum < 0.7)    {
                        System.out.println("Sorry, not enough money");
                    }   else {
                        System.out.printf("Purchased %s%n", input);
                        sum = sum - 0.7;
                    }
                    break;

                case "Crisps":
                    if (sum < 1.5)    {
                        System.out.println("Sorry, not enough money");
                    }   else {
                        System.out.printf("Purchased %s%n", input);
                        sum = sum - 1.5;
                    }
                    break;

                case "Soda":
                    if (sum < 0.8)    {
                        System.out.println("Sorry, not enough money");
                    }   else {
                        System.out.printf("Purchased %s%n", input);
                        sum = sum - 0.8;
                    }
                    break;

                case "Coke":
                    if (sum < 1)    {
                        System.out.println("Sorry, not enough money");
                    }   else {
                        System.out.printf("Purchased %s%n", input);
                        sum = sum - 1;
                    }
                    break;

                default:
                    System.out.println("Invalid product");
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
