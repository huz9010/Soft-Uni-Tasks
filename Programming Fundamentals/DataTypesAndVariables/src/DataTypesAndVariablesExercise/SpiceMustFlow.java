package DataTypesAndVariablesExercise;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int totalSpice = 0;
        int days = 0;

        if (startingYield < 100)    {
            System.out.println(0);
            System.out.println(0);
        }   else {
            while (startingYield >= 100) {
                totalSpice = totalSpice + startingYield - 26;
                days++;
                startingYield -= 10;
            }
        totalSpice -= 26;
        System.out.println(days);
        System.out.println(totalSpice);
        }
    }
}
