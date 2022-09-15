package BasicSyntaxConditionalStatementsandLoopsMoreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String title = "";
        double sum = 0;
        boolean noMoney = false;

        while (!input.equals("Game Time")) {
            title = input;
            switch (title) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (budget < 39.99) {
                        System.out.println("Too Expensive");
                    } else {
                        sum += 39.99;
                        budget -= 39.99;
                        System.out.printf("Bought %s%n", title);
                    }
                    break;
                case "CS: OG":
                    if (budget < 15.99) {
                        System.out.println("Too Expensive");
                    } else {
                        sum += 15.99;
                        budget -= 15.99;
                        System.out.printf("Bought %s%n", title);
                    }
                    break;
                case "Zplinter Zell":
                    if (budget < 19.99) {
                        System.out.println("Too Expensive");
                    } else {
                        sum += 19.99;
                        budget -= 19.99;
                        System.out.printf("Bought %s%n", title);
                    }
                    break;
                case "Honored 2":
                    if (budget < 59.99) {
                        System.out.println("Too Expensive");
                    } else {
                        sum += 59.99;
                        budget -= 59.99;
                        System.out.printf("Bought %s%n", title);
                    }
                    break;
                case "RoverWatch":
                    if (budget < 29.99) {
                        System.out.println("Too Expensive");
                    } else {
                        sum += 29.99;
                        budget -= 29.99;
                        System.out.printf("Bought %s%n", title);
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }
            if (budget == 0) {
                noMoney = true;
                break;
            } else {
                input = scanner.nextLine();
            }
        }
        if (noMoney) {
            System.out.println("Out of money!");
        } else {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", sum, budget);
        }
    }
}
