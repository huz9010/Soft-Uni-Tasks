package MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num; i++) {
            if (digitSumIsDivisibleBy8(i) && oneOddDigit(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean digitSumIsDivisibleBy8(int a){
        boolean isDivisible = false;
        int sum = 0;
        while (a > 0)   {
            sum += a % 10;
            a = a / 10;
        }
        if (sum % 8 == 0) {
            isDivisible = true;
        }
        return isDivisible;
    }

    public static boolean oneOddDigit(int a){
        boolean oddDigit = false;

        while (a > 0)   {
            int currentDigit = a % 10;
            if (currentDigit % 2 != 0) {
                oddDigit = true;
                break;
            }   else {
                a = a / 10;
            }
        }
        return oddDigit;
    }
}
