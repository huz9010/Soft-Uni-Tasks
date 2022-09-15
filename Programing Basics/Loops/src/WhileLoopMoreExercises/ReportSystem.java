package WhileLoopMoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int expected = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int cs = 0;
        int cc = 0;
        int csCounter = 0;
        int ccCounter = 0;
        int counter = 0;
        int allMoney = 0;

        while (!input.equals("End"))    {
            int price = Integer.parseInt(input);
            counter++;

            if (counter % 2 == 0) {
                if (price < 10) {
                    System.out.println("Error in transaction!");
                } else {
                    cc = cc + price;
                    ccCounter++;
                    allMoney = allMoney + price;
                    System.out.println("Product sold!");
                }
            }   else {
                    if (price > 100)    {
                        System.out.println("Error in transaction!");
                    }   else {
                        cs = cs + price;
                        csCounter++;
                        allMoney = allMoney + price;
                        System.out.println("Product sold!");
                    }
                }
            if (allMoney >= expected) {
                break;
            }

            input = scanner.nextLine();
            }
        if (allMoney >= expected)   {
            System.out.printf("Average CS: %.2f%n" +
                    "Average CC: %.2f", (cs * 1.0 / csCounter), (cc * 1.0 / ccCounter));
        }   else {
            System.out.println("Failed to collect required money for charity.");
        }
        }

    }

