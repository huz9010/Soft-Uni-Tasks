package March2020;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double capacity = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int counter = 0;
        boolean isFull = false;

        while (!input.equals("End"))    {

            double suitcase = Double.parseDouble(input);

            if (counter != 0 && (counter + 1) % 3 == 0)   {
                capacity = capacity - suitcase * 1.1;
            }   else {

                capacity = capacity - suitcase;
            }

            if (capacity < 0)   {
                isFull = true;
                break;
            }

                counter++;


            input = scanner.nextLine();
        }

        if (isFull) {
            System.out.printf("No more space!%n" +
                    "Statistic: %d suitcases loaded.", counter);
        }   else {
            System.out.printf("Congratulations! All suitcases are loaded!%n" +
                    "Statistic: %d suitcases loaded.", counter);
        }
    }
}
